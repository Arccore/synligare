package org.eclipse.eatop.volvo.sgraphml.gefeditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.eatop.volvo.sgraphml.gefeditor.model.resources.ResourceManager;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

public class Utils {

	//Singleton
	static public Utils INSTANCE = new Utils();
	private Utils(){};
	
	
	static private Shell shell;
	static private GraphicalViewer graphicalViewer;
	static private IEditorPart editorPart;
	
	protected ResourceManager resourceManager;
	
	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	static public void setShell(Shell s){
		shell = s;
	}
	
	static public Shell getShell(){
		return shell;
	}
	
	
	public static GraphicalViewer getGraphicalViewer() {
		return graphicalViewer;
	}

	public static void setGraphicalViewer(GraphicalViewer graphicalViewer) {
		Utils.graphicalViewer = graphicalViewer;
	}
	
	public static IEditorPart getEditorPart() {
		return editorPart;
	}

	public static void setEditorPart(IEditorPart editorPart) {
		Utils.editorPart = editorPart;
	}
	

	static public void showInformationMessage(final String message){
          	MessageDialog.openInformation(shell, "GEF Editor", message);
		}
	
	static public void showErrorMessage(final String message){
        		MessageDialog.openError(shell, "GEF Editor", message);
	}

	static public boolean showQuestion(final String message){
		boolean bQuestion;
	
       	bQuestion = MessageDialog.openQuestion(shell, "GEF Editor", message);
		return bQuestion;
	}
	
	
	static public double getZoomLevel(){

		double zoomLevel = 1.0;
		
	    RootEditPart root = graphicalViewer.getRootEditPart();
         if (root instanceof ScalableRootEditPart)
         {
             ScalableRootEditPart scalableRoot = (ScalableRootEditPart) root;
             
             ZoomManager zoomManager = scalableRoot.getZoomManager();
             zoomLevel = zoomManager.getZoom();
         }
		
         return zoomLevel;
	}
	
		
	static public Point screenPoint2ModelPoint(Point screenPoint){

		double zoomLevel = 1.0;
		Point modelPoint = new Point(screenPoint);
		
	    RootEditPart root = graphicalViewer.getRootEditPart();
         if (root instanceof ScalableRootEditPart)
         {
             ScalableRootEditPart scalableRoot = (ScalableRootEditPart) root;
             
             ZoomManager zoomManager = scalableRoot.getZoomManager();
             zoomLevel = zoomManager.getZoom();

     		//Top-left corner of Canvas in model coordinates
             Viewport viewport = zoomManager.getViewport();
             Point view = viewport.getViewLocation();

             modelPoint = (modelPoint.translate(view).scale(1/zoomLevel));
         }

		return modelPoint;
	}

	/***
	 * Takes zoom level into account to transform a delta from absolute screen coordinates to model coordinates.  
	 * @param screenDelta
	 * @return
	 */
	static public Point screenDelta2ModelDelta(Point screenDelta){
		double zoomLevel = 1.0;
		Point modelPoint = new Point(screenDelta);
		
	    RootEditPart root = graphicalViewer.getRootEditPart();
         if (root instanceof ScalableRootEditPart)
         {
             ScalableRootEditPart scalableRoot = (ScalableRootEditPart) root;
             
             ZoomManager zoomManager = scalableRoot.getZoomManager();
             zoomLevel = zoomManager.getZoom();
             modelPoint = (modelPoint.scale(1/zoomLevel));
         }

		return modelPoint;
	}
	
	
	static public Pattern createScaledPattern(Graphics graphics, 
			float x1, float y1, float x2, float y2, Color color1, Color color2)
			{
				double scale = graphics.getAbsoluteScale();
				Device device = Display.getCurrent();
				return new Pattern(device, (int) Math.ceil(x1 * scale), (int) Math.ceil(y1 * scale),
				(int)Math.floor(x2 * scale), (int) Math.floor(y2 * scale), color1, color2);
			}
	
	/***
	 * Find a filename that is not in the workspace, derived from "base" by adding a number until 
	 * we find an unused filename. 
	 * For example: base ="kalle.txt", newExtension=".drf" and "kalle1.drf", "kalle2.drf" exist --> "kalle3.drf"
	 * 
	 */
	public IFile generateUniqueFilename(IFile base, String newExtension){

		IPath basePath = base.getProjectRelativePath();
		
		String baseFilename = base.getName();
        String baseFilenameNoExt = baseFilename.substring(0, baseFilename.lastIndexOf('.'));
		
		
		IPath newPath = basePath.removeLastSegments(1).append(baseFilenameNoExt + "." + newExtension);
		IProject project = base.getProject();
		IFile newFile = project.getFile(newPath);
		boolean bFound = false;
		int n = 0;
		while (!bFound)
		{
			if (newFile.exists()){
		    	n++;
				newPath = basePath.removeLastSegments(1).append(baseFilenameNoExt + n + "." + newExtension);
				newFile = project.getFile(newPath);
			}
		else{
				bFound = true;
			}
		}
		return newFile;
	}
	
	
}