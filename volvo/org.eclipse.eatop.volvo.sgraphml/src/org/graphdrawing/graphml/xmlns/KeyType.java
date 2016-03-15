/**
 */
package org.graphdrawing.graphml.xmlns;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         Complex type for the <key> element.
 *       
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getDefault <em>Default</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getAttrName <em>Attr Name</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getAttrType <em>Attr Type</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getFor <em>For</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getId <em>Id</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.KeyType#getSgraphmlType <em>Sgraphml Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType()
 * @model extendedMetaData="name='key.type' kind='elementOnly'"
 * @generated
 */
public interface KeyType extends EObject {
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
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_Desc()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='desc' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDesc();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getDesc <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desc</em>' attribute.
	 * @see #getDesc()
	 * @generated
	 */
	void setDesc(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
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
	 *         The (optional) <default> child of <key> gives
	 *         the default value for the corresponding function.
	 *         Occurence: <key>.
	 *       
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(DefaultType)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_Default()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='default' namespace='##targetNamespace'"
	 * @generated
	 */
	DefaultType getDefault();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(DefaultType value);

	/**
	 * Returns the value of the '<em><b>Attr Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attr Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr Name</em>' attribute.
	 * @see #setAttrName(String)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_AttrName()
	 * @model dataType="org.graphdrawing.graphml.xmlns.KeyNameType"
	 *        extendedMetaData="kind='attribute' name='attr.name'"
	 * @generated
	 */
	String getAttrName();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getAttrName <em>Attr Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attr Name</em>' attribute.
	 * @see #getAttrName()
	 * @generated
	 */
	void setAttrName(String value);

	/**
	 * Returns the value of the '<em><b>Attr Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.graphdrawing.graphml.xmlns.KeyTypeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attr Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr Type</em>' attribute.
	 * @see org.graphdrawing.graphml.xmlns.KeyTypeType
	 * @see #isSetAttrType()
	 * @see #unsetAttrType()
	 * @see #setAttrType(KeyTypeType)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_AttrType()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='attr.type'"
	 * @generated
	 */
	KeyTypeType getAttrType();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getAttrType <em>Attr Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attr Type</em>' attribute.
	 * @see org.graphdrawing.graphml.xmlns.KeyTypeType
	 * @see #isSetAttrType()
	 * @see #unsetAttrType()
	 * @see #getAttrType()
	 * @generated
	 */
	void setAttrType(KeyTypeType value);

	/**
	 * Unsets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getAttrType <em>Attr Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAttrType()
	 * @see #getAttrType()
	 * @see #setAttrType(KeyTypeType)
	 * @generated
	 */
	void unsetAttrType();

	/**
	 * Returns whether the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getAttrType <em>Attr Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Attr Type</em>' attribute is set.
	 * @see #unsetAttrType()
	 * @see #getAttrType()
	 * @see #setAttrType(KeyTypeType)
	 * @generated
	 */
	boolean isSetAttrType();

	/**
	 * Returns the value of the '<em><b>For</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * The literals are from the enumeration {@link org.graphdrawing.graphml.xmlns.KeyForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *           describes the domain of definition for
	 *           the corresponding graph attribute.
	 *         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>For</em>' attribute.
	 * @see org.graphdrawing.graphml.xmlns.KeyForType
	 * @see #isSetFor()
	 * @see #unsetFor()
	 * @see #setFor(KeyForType)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_For()
	 * @model default="all" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='for'"
	 * @generated
	 */
	KeyForType getFor();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getFor <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For</em>' attribute.
	 * @see org.graphdrawing.graphml.xmlns.KeyForType
	 * @see #isSetFor()
	 * @see #unsetFor()
	 * @see #getFor()
	 * @generated
	 */
	void setFor(KeyForType value);

	/**
	 * Unsets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getFor <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFor()
	 * @see #getFor()
	 * @see #setFor(KeyForType)
	 * @generated
	 */
	void unsetFor();

	/**
	 * Returns whether the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getFor <em>For</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>For</em>' attribute is set.
	 * @see #unsetFor()
	 * @see #getFor()
	 * @see #setFor(KeyForType)
	 * @generated
	 */
	boolean isSetFor();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * identifies this <key>.
	 *         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.NMTOKEN" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Sgraphml Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Custom yfiles specific attribute that allows to specify an additional data type.
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sgraphml Type</em>' attribute.
	 * @see #setSgraphmlType(String)
	 * @see org.graphdrawing.graphml.xmlns.XmlnsPackage#getKeyType_SgraphmlType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='sgraphml.type'"
	 * @generated
	 */
	String getSgraphmlType();

	/**
	 * Sets the value of the '{@link org.graphdrawing.graphml.xmlns.KeyType#getSgraphmlType <em>Sgraphml Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sgraphml Type</em>' attribute.
	 * @see #getSgraphmlType()
	 * @generated
	 */
	void setSgraphmlType(String value);

} // KeyType