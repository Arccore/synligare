/**
 */
package org.graphdrawing.graphml.xmlns;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hyperedge Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         Complex type for the <hyperedge> element.
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getData <em>Data</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType()
 * @model extendedMetaData="name='hyperedge.type' kind='elementOnly'"
 * @generated
 */
public interface HyperedgeType extends EObject {
	/**
	 * Returns the value of the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         Description: Provides human-readable descriptions for the GraphML
	 *         element containing this <desc> as its first child.
	 *         Occurence: <key>, <graphml>, <graph>,
	 *         <node>, <port>, <edge>, <hyperedge>, and
	 *         <endpoint>.
	 *       
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Desc</em>' attribute.
	 * @see #setDesc(String)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType_Desc()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='desc' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDesc();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc</em>' attribute.
	 * @see #getDesc()
	 * @generated
	 */
	void setDesc(String value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' attribute list.
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType_Group()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:1'"
	 * @generated
	 */
	FeatureMap getGroup();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference list.
	 * The list contents are of type {@link org.graphdrawing.graphml.xmlns.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         Description: In GraphML there may be data-functions attached
	 *         to graphs, nodes, ports, edges, hyperedges and
	 *         endpoint and to the whole collection of
	 *         graphs described by the content of <graphml>.
	 *         These functions are declared by <key> elements
	 *         (children of <graphml>) and defined by <data>
	 *         elements.
	 *         Occurence: <graphml>, <graph>, <node>, <port>,
	 *         <edge>, <hyperedge>, and <endpoint>.
	 *       
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data</em>' containment reference list.
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType_Data()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='data' namespace='##targetNamespace' group='#group:1'"
	 * @generated
	 */
	EList<DataType> getData();

	/**
	 * Returns the value of the '<em><b>Endpoint</b></em>' containment reference list.
	 * The list contents are of type {@link org.graphdrawing.graphml.xmlns.EndpointType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         Description: The list of <endpoints> within a hyperedge
	 *         points to the nodes contained in this hyperedge.
	 *         Occurence: <hyperedge>.
	 *       
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Endpoint</em>' containment reference list.
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType_Endpoint()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='endpoint' namespace='##targetNamespace' group='#group:1'"
	 * @generated
	 */
	EList<EndpointType> getEndpoint();

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *         Description: Describes one graph in this document.
	 *         Occurence: <graphml>, <node>, <edge>, <hyperedge>.
	 *       
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(GraphType)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType_Graph()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='graph' namespace='##targetNamespace'"
	 * @generated
	 */
	GraphType getGraph();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(GraphType value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *           identifies this <hyperedge> .
	 *         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getHyperedgeType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NMTOKEN"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.HyperedgeType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // HyperedgeType