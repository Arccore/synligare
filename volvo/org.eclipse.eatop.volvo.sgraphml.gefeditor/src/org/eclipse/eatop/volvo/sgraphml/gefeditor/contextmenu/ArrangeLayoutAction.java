package org.eclipse.eatop.volvo.sgraphml.gefeditor.contextmenu;

import java.awt.geom.Point2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.eatop.eastadl21.CommunicationHardwarePin;
import org.eclipse.eatop.eastadl21.EADirectionKind;
import org.eclipse.eatop.eastadl21.FailureOutPort;
import org.eclipse.eatop.eastadl21.FaultInPort;
import org.eclipse.eatop.eastadl21.FunctionFlowPort;
import org.eclipse.eatop.eastadl21.HardwarePort;
import org.eclipse.eatop.eastadl21.IOHardwarePin;
import org.eclipse.eatop.semcon.placeandroute.PNREdge;
import org.eclipse.eatop.semcon.placeandroute.PNRGraph;
import org.eclipse.eatop.semcon.placeandroute.PNRNode;
import org.eclipse.eatop.semcon.placeandroute.PlaceAndRoute;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.Pair;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.Utils;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.commands.NodeTypeChangeConstraintCommand;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.commands.PolyLineEdgeSetBendPointsCommand;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.commands.TouchNodeLabelCommand;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.controller.GraphMLTypeEditPart;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.controller.GroupNodeEditPart;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.controller.PolyLineEdgeEditPart;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.dnd.EAXMLprocessor;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.model.ModelProcessor;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.graphdrawing.graphml.xmlns.DataType;
import org.graphdrawing.graphml.xmlns.EdgeType;
import org.graphdrawing.graphml.xmlns.GraphType;
import org.graphdrawing.graphml.xmlns.GraphmlType;
import org.graphdrawing.graphml.xmlns.NodeType;

import eu.synligare.sgraphml.BaseNodeType;
import eu.synligare.sgraphml.GeometryType;
import eu.synligare.sgraphml.GroupNodeType;
import eu.synligare.sgraphml.NodeLabelType;
import eu.synligare.sgraphml.PathType;
import eu.synligare.sgraphml.PointType;
import eu.synligare.sgraphml.PolyLineEdgeType;
import eu.synligare.sgraphml.PortNodeType;
import eu.synligare.sgraphml.SgraphmlFactory;
import eu.synligare.sgraphml.SgraphmlPackage;
import eu.synligare.sgraphml.ShapeNodeType;


public class ArrangeLayoutAction extends SelectionAction {

	private final static String EAST_ADL_EXPLORER = 
			"org.eclipse.eatop.examples.explorer.views.eastadlExplorer";

	public static final String ARRANGE_LAYOUT_ACTION = "ArrangeLayoutAction";
	public static final String REQ_ARRANGE_LAYOUT_ACTION = "ArrangeLayoutAction";

	Request request;

	
	
	
	/**
	 * Create a new instance of the class.
	 * @param part
	 */
	public ArrangeLayoutAction(IWorkbenchPart part) {
		super(part);
		setId(ARRANGE_LAYOUT_ACTION);
		setText("Arrange Layout");
		request = new Request(REQ_ARRANGE_LAYOUT_ACTION);
	}

	//Pair: Left = PNRNode/PNREdge, Right=BaseNodeType/PolyLineEdgeEditPart
	Map<String, Pair<Object, Object>> mapEAPath2modelObjs = new HashMap<String, Pair<Object, Object>>();	    

	//Converts contents of one graph and calls it self recursively for subgraphs. 	    
	protected boolean ConvertSgraphml2PNR(GraphType sgmlGraph, PNRGraph pnrGraph){

		//Nodes
		EList<NodeType> nodes = sgmlGraph.getNode();
		for (NodeType node : nodes){

			PNRNode pnrNode;

			EList<DataType> dataNodes = node.getData();
			DataType d0 = dataNodes.get(0);
			FeatureMap fm = d0.getMixed();

			BaseNodeType baseNode = null;
			String pnrType = "PhonyType";

			for (FeatureMap.Entry entry : fm){
				if (entry.getEStructuralFeature().getFeatureID() == SgraphmlPackage.DOCUMENT_ROOT__SHAPE_NODE){
					baseNode = (ShapeNodeType)entry.getValue();
					//Actually, a shapenode is not really a groupnode, but we pretend here it's a groupnode without children
					pnrType = "GroupNode";
					break;
				}
				else if (entry.getEStructuralFeature().getFeatureID() == SgraphmlPackage.DOCUMENT_ROOT__GROUP_NODE){
					baseNode = (GroupNodeType)entry.getValue();
					pnrType = "GroupNode";
					break;
				}
				else if (entry.getEStructuralFeature().getFeatureID() == SgraphmlPackage.DOCUMENT_ROOT__PORT_NODE){
					baseNode = (PortNodeType)entry.getValue();
					//"In", "Out" or "InOut"
					pnrType = getPNRDirection(node, (PortNodeType)baseNode);
					break;
				}
			}    				

			pnrNode = new PNRNode(node.getId(), pnrType, pnrGraph);
			GeometryType geometry = baseNode.getGeometry();
			//Note: We lose some resolution here.
			pnrNode.setX((int)(geometry.getX() + 0.5));
			pnrNode.setY((int)(geometry.getY() + 0.5));
			pnrNode.setH((int)(geometry.getHeight() + 0.5));
			pnrNode.setW((int)(geometry.getWidth() + 0.5));
			pnrGraph.addNode(pnrNode);
			
			if (mapEAPath2modelObjs.containsKey(node.getId())){
				Utils.showErrorMessage("The path " + node.getId() + " is not unique. Error in EAXML. ");
				return false;
			}
			mapEAPath2modelObjs.put(node.getId(), Pair.of((Object)pnrNode, (Object)baseNode));

			if (baseNode instanceof GroupNodeType){
				//Children of GroupNode is a new graph 
				GraphType childGraph = node.getGraph().get(0);
				PNRGraph gPNRchild = new PNRGraph(childGraph.getId(), childGraph.getEdgedefault().toString(), pnrNode);
				pnrNode.setGraph(gPNRchild);
				ConvertSgraphml2PNR(childGraph, gPNRchild);
			}


		}

		//Edges - there will only be edges in the top graph, so when it's time for edges all nodes are defined
		EList<EdgeType> edges = sgmlGraph.getEdge();
		for (EdgeType edge : edges){

			String sourceDotPath = edge.getSource();
			PNRNode pnrSourceNode = (PNRNode)mapEAPath2modelObjs.get(sourceDotPath).getLeft();

			String targetDotPath = edge.getTarget();
			PNRNode pnrTargetNode = (PNRNode)mapEAPath2modelObjs.get(targetDotPath).getLeft();

			if (pnrSourceNode == null){
				Utils.showErrorMessage("Could not find source edge reference: " + sourceDotPath);
				continue;	
			}
			if (pnrTargetNode == null){
				Utils.showErrorMessage("Could not find target edge reference: " + targetDotPath);
				continue;
			}

			PNREdge pnrEdge = new PNREdge(edge.getId(), pnrSourceNode, pnrTargetNode);
			pnrSourceNode.addEdge(pnrEdge);
			pnrTargetNode.addEdge(pnrEdge);
			
			
			//Add route points
			DataType d1 = edge.getData().get(0);
			FeatureMap fm = d1.getMixed();

			for (FeatureMap.Entry entry : fm){
				if (entry.getEStructuralFeature().getFeatureID() == SgraphmlPackage.DOCUMENT_ROOT__POLY_LINE_EDGE){
					PolyLineEdgeType polyLineEdge = (PolyLineEdgeType)entry.getValue();

					PathType path = polyLineEdge.getPath();
					EList<PointType> points = path.getPoint();

					for (PointType point : points) {
						Point2D point2D = new Point2D.Float((float)point.getX(), (float)point.getY());
						pnrEdge.addPointToRoute(point2D);
					}
					
					if (mapEAPath2modelObjs.containsKey(edge.getId())){
						Utils.showErrorMessage("The path " + edge.getId() + " is not unique. Error in EAXML. ");
						return false;
					}

					mapEAPath2modelObjs.put(edge.getId(), Pair.of((Object)pnrEdge, (Object)polyLineEdge)); 
					break;
				}
			}    		
			

		}

		return true;
	}


	//In, Out, InOut

	String getPNRDirection(NodeType node, PortNodeType portNode){

		if (node.getId() != null){
			String dotPath = node.getId();
			
			EObject port = EAXMLprocessor.getEObjectbyDotPath(dotPath);
			if (port == null)
			{
				Utils.showErrorMessage("Element reference " + node.getId() + " is no valid object.");
			}
			else{
				EADirectionKind dir;
				
				if (port instanceof FunctionFlowPort){
					FunctionFlowPort ffp = (FunctionFlowPort)port;
					dir = ffp.getDirection();
				}
				else if (port instanceof IOHardwarePin){
					IOHardwarePin pin = (IOHardwarePin)port;
					dir = pin.getDirection();
				}
				else if (port instanceof FaultInPort){
					dir = EADirectionKind.IN;
				}
				else if (port instanceof FailureOutPort){
					dir = EADirectionKind.OUT;
				}
				else if (port instanceof CommunicationHardwarePin){
					CommunicationHardwarePin pin = (CommunicationHardwarePin)port;
					dir = pin.getDirection();
				}
				else if (port instanceof HardwarePort){
					HardwarePort pin = (HardwarePort)port;
					//TODO: Make this more general
					dir = EADirectionKind.INOUT; 
				}

				else{
					Utils.showErrorMessage("Unsupported metaclass " + port.eClass().getName() + " in direction calculations.");
					dir = EADirectionKind.IN;
				}
					

				switch (dir){
				case IN:
					return "In";
				case INOUT:
					return "InOut";
				case OUT:
					return "Out";
				default:
					Utils.showErrorMessage("Unknown direction for port" + EAXMLprocessor.elementName(port));
					return "In";
				}
			}
		}

		//No object => guess using horisontal text attribute
		NodeLabelType nodeLabel = portNode.getNodeLabel().get(0);

		switch(nodeLabel.getHorizontalTextPosition()){
		case CENTER:
			return "InOut";
		case LEFT:
			return "Out";
		case RIGHT:
			return "In";
		default:
			return "In";
		}
	}

	
	public void updateSGraphMLModel(PNRGraph gpNR0){
		CompoundCommand cc = new CompoundCommand();
		
		//Traverse PNR model with a while loop & stack 
		Deque<PNRNode> s = new ArrayDeque<PNRNode>(gpNR0.getNodes());
		while(!s.isEmpty()){
		    PNRNode n = s.pop();
		    //Update node geometry
		    BaseNodeType baseNode = null;
		    baseNode = (BaseNodeType)mapEAPath2modelObjs.get(n.getId()).getRight();
		    
		    
		    NodeTypeChangeConstraintCommand command = new NodeTypeChangeConstraintCommand();
		    command.setModel(baseNode);
		    Rectangle r = new Rectangle();
		    r.x = n.getX();
		    r.y = n.getY();
		    r.width = n.getW();
		    r.height = n.getH();
		    command.setNewConstraint(r);
	
		    cc.add(command);  
	
		    if (baseNode instanceof PortNodeType){
		    	//touch port label to so it is updated, i..e. follows the node move 
				TouchNodeLabelCommand touchCommand = new TouchNodeLabelCommand();
				NodeLabelType nodeLabel = ((PortNodeType)baseNode).getNodeLabel().get(0);
				touchCommand.setNodeLabel(nodeLabel);
				cc.add(touchCommand);
		    }
		    
		    //Visit Edges
		    for(Iterator<PNREdge> it2 = n.getEdges().iterator(); it2.hasNext();){
		    	PNREdge e = it2.next();
		    	if(e.getSource().getId() == n.getId()){
		    		//Only handle edge for source node
		    		PolyLineEdgeEditPart polyLineEdgeEditPart = (PolyLineEdgeEditPart)mapEAPath2modelObjs.get(e.getId()).getRight();
		    		PolyLineEdgeType polyLineEdge = (PolyLineEdgeType)polyLineEdgeEditPart.getModel();
		    		PolyLineEdgeSetBendPointsCommand pointsCommand = new PolyLineEdgeSetBendPointsCommand();
		    		
		    		EList<PointType> pointsSgml = ECollections.newBasicEList();

		    		java.util.List<Point2D> route = e.getRoute();
		    		
		    		//skip first and last point of route since they are handled by the source and target portnode
		    	//	for (int i = 0; i < route.size(); i++){

		    		for (int i = 1; i < route.size() - 1; i++){
		    			Point2D p = route.get(i);
		    			PointType pointSgml = SgraphmlFactory.eINSTANCE.createPointType();
		    			//The calculated points are in grid coordinates, convert to model coordinates
		    			//The -1 term is because the midpoint of the ports are typically 14x14, and the anchor algorithm 
		    			//seems to regard midpoint as (7,7) in a (1..14, 1..14) coordinate system for the port, i.e. we need to 
		    			//subtract one pixel to align the line.
		    			pointSgml.setX(p.getX() * e.getSource().getSeparator() + e.getSource().getSeparator() / 2 - 1);
		    			pointSgml.setY(p.getY() * e.getSource().getSeparator() + e.getSource().getSeparator() / 2 - 1);
		    			pointsSgml.add(pointSgml);
		    		}	

		    		pointsCommand.setPolyLineEdge(polyLineEdge);	
		    		pointsCommand.setNewPoints(pointsSgml);
		    		cc.add(pointsCommand);
		    	}
		    }
		    
		    //Add graph nodes for subgraph
		    if (n.getGraph() != null){
		    	for(Iterator<PNRNode> it = n.getGraph().getNodes().iterator(); it.hasNext();){
		    		s.push(it.next());
		    	}
		    }
		} 	
		
		Utils.INSTANCE.executeGEFCommand(cc);
	}
	
		Set<PolyLineEdgeEditPart> selectedEdges = new HashSet<PolyLineEdgeEditPart>();
	
		//Converts contents of one graph and calls it self recursively for subgraphs. 	    
		
		protected boolean convertSgraphml2PNR_(List<EditPart> selectedParts, PNRGraph pnrGraph){
		
			List<EditPart> topParts = retrieveTopParts(selectedParts);
			
			if (!convertNodes(topParts, pnrGraph))
			{
				return false;
			}
			
			//Convert Edges in selectedEdges
			for (PolyLineEdgeEditPart polyLineEdge : selectedEdges){

				EdgeType gmlEdge = (EdgeType)((EObject)polyLineEdge.getModel()).eContainer().eContainer();
				
				String sourceDotPath = gmlEdge.getSource();
				String targetDotPath = gmlEdge.getTarget();

				//make sure both source and target node is included
				if (mapEAPath2modelObjs.containsKey(sourceDotPath) && mapEAPath2modelObjs.containsKey(targetDotPath)){
					PNRNode pnrSourceNode = (PNRNode)mapEAPath2modelObjs.get(sourceDotPath).getLeft();
					PNRNode pnrTargetNode = (PNRNode)mapEAPath2modelObjs.get(targetDotPath).getLeft();

					PNREdge pnrEdge = new PNREdge(gmlEdge.getId(), pnrSourceNode, pnrTargetNode);
					pnrSourceNode.addEdge(pnrEdge);
					pnrTargetNode.addEdge(pnrEdge);
				
					
			/*		
					DataType d1 = edge.getData().get(0);
					FeatureMap fm = d1.getMixed();

					for (FeatureMap.Entry entry : fm){
						if (entry.getEStructuralFeature().getFeatureID() == SgraphmlPackage.DOCUMENT_ROOT__POLY_LINE_EDGE){
							PolyLineEdgeType polyLineEdge = (PolyLineEdgeType)entry.getValue();
*/
							// Skip adding route points - PNR algoritm does not use them
									
							if (mapEAPath2modelObjs.containsKey(gmlEdge.getId())){
								Utils.showErrorMessage("The path " + gmlEdge.getId() + " is not unique. Error in EAXML or sgraphml. ");
								return false;
							}

							
							mapEAPath2modelObjs.put(gmlEdge.getId(), Pair.of((Object)pnrEdge, (Object)polyLineEdge)); 
						//	break;
					//	}
					}    		
				//}
					
				
			}
			return true;
		}
			
		//When user selects editparts he may select a GroupNodeEditPart as well as its content EditParts
		//This function filters away editparts that has a container in the selectedParts
		private List<EditPart> retrieveTopParts(List<EditPart> selectedParts) {

			List<EditPart> topParts = new ArrayList<EditPart>();
			
			//O(n2)
			for (EditPart selectedPart : selectedParts) {
				boolean bIsTopPart = true;
				for (EditPart testPart : selectedParts){
						if (selectedPart.equals(testPart)){
							continue;
						}
						if (isContainerEditPart(selectedPart, testPart)){
							bIsTopPart = false;
							break;
						}
				}

				if (bIsTopPart){
					topParts.add(selectedPart);
				}
			} 
			
			return topParts;
		}

		//returns true if part is in the subtree of containerPart
		private boolean isContainerEditPart(EditPart part, EditPart containerPart) {
		
			boolean bFound = false;
			part = part.getParent();
			
			while (!(part instanceof ScalableRootEditPart) && !bFound){
				bFound = part.equals(containerPart);
				part = part.getParent();
			}
			
			return bFound;
		}


		protected boolean convertNodes(List<EditPart> selectedParts, PNRGraph pnrGraph){
		
			for (EditPart selectedPart : selectedParts) {
		
				EObject modelObject = (EObject)selectedPart.getModel();
				
				if (modelObject instanceof PolyLineEdgeType){
					selectedEdges.add((PolyLineEdgeEditPart)selectedPart);
				}

				else if (modelObject instanceof BaseNodeType){
					//Nodes
					BaseNodeType baseNode = (BaseNodeType)modelObject;
					NodeType node =  (NodeType)baseNode.eContainer().eContainer();
							
					String pnrType = "PhonyType";
					
					if (baseNode instanceof GroupNodeType){
						pnrType = "GroupNode";
						
					}
					else if (baseNode instanceof ShapeNodeType){
						//Actually, a shapenode is not really a groupnode, but we pretend here it's a groupnode without children
						pnrType = "GroupNode";
						addEdges(selectedPart);
					}
					else if (baseNode instanceof PortNodeType){
						//"In", "Out" or "InOut"
						pnrType = getPNRDirection(node, (PortNodeType)baseNode);
						addEdges(selectedPart);
					}
					
					PNRNode pnrNode = new PNRNode(node.getId(), pnrType, pnrGraph);
					GeometryType geometry = baseNode.getGeometry();
					//Note: We lose some resolution here.
					pnrNode.setX((int)(geometry.getX() + 0.5));
					pnrNode.setY((int)(geometry.getY() + 0.5));
					pnrNode.setH((int)(geometry.getHeight() + 0.5));
					pnrNode.setW((int)(geometry.getWidth() + 0.5));
					pnrGraph.addNode(pnrNode);
				
					if (mapEAPath2modelObjs.containsKey(node.getId())){
						Utils.showErrorMessage("The path " + node.getId() + " is not unique. Error in EAXML. ");
						return false;
					}		
					mapEAPath2modelObjs.put(node.getId(), Pair.of((Object)pnrNode, (Object)baseNode));
	
					if (baseNode instanceof GroupNodeType){
						
						//Children of GroupNode is a new graph 
						GraphType childGraph = node.getGraph().get(0);
						PNRGraph gPNRchild = new PNRGraph(childGraph.getId(), childGraph.getEdgedefault().toString(), pnrNode);
						pnrNode.setGraph(gPNRchild);
						@SuppressWarnings("unchecked")
						List<EditPart> childParts = selectedPart.getChildren();
						
						if (!convertNodes (childParts, gPNRchild)){
							return false;
						}

					}
				}
				else if (modelObject instanceof GraphmlType){
					return convertNodes(selectedPart.getChildren(), pnrGraph);
				}
			}
	
			return true;
		}

		//Adds incoming and outgoing edges of selectedPart to the selectedEdges Set
		private void addEdges(EditPart selectedPart) {
			AbstractGraphicalEditPart part = (AbstractGraphicalEditPart)selectedPart;

	//	System.out.println ("Add edges: " + ((NodeType)((EObject)selectedPart.getModel()).eContainer().eContainer()).getId());	
	//	System.out.println ("Before: " + selectedEdges.size());
				
			@SuppressWarnings("unchecked")
			List<PolyLineEdgeEditPart> sourceEdges = part.getSourceConnections();
			selectedEdges.addAll(sourceEdges);
			
			@SuppressWarnings("unchecked")
			List<PolyLineEdgeEditPart> targetEdges = part.getTargetConnections();
			selectedEdges.addAll(targetEdges);
	//	System.out.println ("After: " + selectedEdges.size());
			
		}
			
			
	@Override
	public void run() {   	
		
		//Seems to be a GEF bug with getSelectedObjects() that often returns null in the run() method. Use this longer but safer approach to get the selection instead.
		IStructuredSelection currentSelection = (IStructuredSelection)Utils.INSTANCE.getEditorPart().getSite().getSelectionProvider().getSelection();
		
	
		
	   @SuppressWarnings("unchecked") 
	   List<EditPart> editParts = (List<EditPart>)currentSelection.toList();

	   if (editParts.size() == 0){
		   //nothing selected - select all editparts on top level
		   RootEditPart root = Utils.INSTANCE.getGraphicalViewer().getRootEditPart();
		   GraphMLTypeEditPart graphMLEditPart = (GraphMLTypeEditPart)root.getChildren().get(0);
		   
		   editParts = graphMLEditPart.getChildren();
	   }

		mapEAPath2modelObjs.clear();
		selectedEdges.clear();
		PNRGraph gPNR0 = new PNRGraph("g0", "directed", null);
		   
		if (convertSgraphml2PNR_ (editParts, gPNR0)){
			PlaceAndRoute pnr = new PlaceAndRoute();
			pnr.doPNR(gPNR0);	
		
			updateSGraphMLModel(gPNR0);
		}
	        
		/*
		
		//SGraphML -> Semcon PNR format
		mapEAPath2modelObjs.clear();
		GraphType rootGraph = ModelProcessor.INSTANCE.getRootGraph();
		PNRGraph gPNR0 = new PNRGraph(rootGraph.getId(), rootGraph.getEdgedefault().toString(), null);

		if (ConvertSgraphml2PNR(rootGraph, gPNR0)){
			PlaceAndRoute pnr = new PlaceAndRoute();
			pnr.doPNR(gPNR0);	
		
			updateSGraphMLModel(gPNR0);
		}
		*/
	}

	@Override
	protected boolean calculateEnabled() {

		return true;

	}

}