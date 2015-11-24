/**
 */
package org.graphdrawing.graphml.xmlns.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.graphdrawing.graphml.xmlns.DefaultType;
import org.graphdrawing.graphml.xmlns.KeyForType;
import org.graphdrawing.graphml.xmlns.KeyType;
import org.graphdrawing.graphml.xmlns.KeyTypeType;
import org.graphdrawing.graphml.xmlns.XmlnsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getDesc <em>Desc</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getAttrName <em>Attr Name</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getAttrType <em>Attr Type</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getFor <em>For</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.graphdrawing.graphml.xmlns.impl.KeyTypeImpl#getSgraphmlType <em>Sgraphml Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyTypeImpl extends MinimalEObjectImpl.Container implements KeyType {
	/**
	 * The default value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected static final String DESC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDesc() <em>Desc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesc()
	 * @generated
	 * @ordered
	 */
	protected String desc = DESC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected DefaultType default_;

	/**
	 * The default value of the '{@link #getAttrName() <em>Attr Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttrName() <em>Attr Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrName()
	 * @generated
	 * @ordered
	 */
	protected String attrName = ATTR_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttrType() <em>Attr Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrType()
	 * @generated
	 * @ordered
	 */
	protected static final KeyTypeType ATTR_TYPE_EDEFAULT = KeyTypeType.BOOLEAN;

	/**
	 * The cached value of the '{@link #getAttrType() <em>Attr Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttrType()
	 * @generated
	 * @ordered
	 */
	protected KeyTypeType attrType = ATTR_TYPE_EDEFAULT;

	/**
	 * This is true if the Attr Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean attrTypeESet;

	/**
	 * The default value of the '{@link #getFor() <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFor()
	 * @generated
	 * @ordered
	 */
	protected static final KeyForType FOR_EDEFAULT = KeyForType.ALL;

	/**
	 * The cached value of the '{@link #getFor() <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFor()
	 * @generated
	 * @ordered
	 */
	protected KeyForType for_ = FOR_EDEFAULT;

	/**
	 * This is true if the For attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean forESet;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSgraphmlType() <em>Sgraphml Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSgraphmlType()
	 * @generated
	 * @ordered
	 */
	protected static final String SGRAPHML_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSgraphmlType() <em>Sgraphml Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSgraphmlType()
	 * @generated
	 * @ordered
	 */
	protected String sgraphmlType = SGRAPHML_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmlnsPackage.Literals.KEY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesc(String newDesc) {
		String oldDesc = desc;
		desc = newDesc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__DESC, oldDesc, desc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultType getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefault(DefaultType newDefault, NotificationChain msgs) {
		DefaultType oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__DEFAULT, oldDefault, newDefault);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(DefaultType newDefault) {
		if (newDefault != default_) {
			NotificationChain msgs = null;
			if (default_ != null)
				msgs = ((InternalEObject)default_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmlnsPackage.KEY_TYPE__DEFAULT, null, msgs);
			if (newDefault != null)
				msgs = ((InternalEObject)newDefault).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmlnsPackage.KEY_TYPE__DEFAULT, null, msgs);
			msgs = basicSetDefault(newDefault, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__DEFAULT, newDefault, newDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttrName() {
		return attrName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrName(String newAttrName) {
		String oldAttrName = attrName;
		attrName = newAttrName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__ATTR_NAME, oldAttrName, attrName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyTypeType getAttrType() {
		return attrType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrType(KeyTypeType newAttrType) {
		KeyTypeType oldAttrType = attrType;
		attrType = newAttrType == null ? ATTR_TYPE_EDEFAULT : newAttrType;
		boolean oldAttrTypeESet = attrTypeESet;
		attrTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__ATTR_TYPE, oldAttrType, attrType, !oldAttrTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAttrType() {
		KeyTypeType oldAttrType = attrType;
		boolean oldAttrTypeESet = attrTypeESet;
		attrType = ATTR_TYPE_EDEFAULT;
		attrTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XmlnsPackage.KEY_TYPE__ATTR_TYPE, oldAttrType, ATTR_TYPE_EDEFAULT, oldAttrTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAttrType() {
		return attrTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KeyForType getFor() {
		return for_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFor(KeyForType newFor) {
		KeyForType oldFor = for_;
		for_ = newFor == null ? FOR_EDEFAULT : newFor;
		boolean oldForESet = forESet;
		forESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__FOR, oldFor, for_, !oldForESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFor() {
		KeyForType oldFor = for_;
		boolean oldForESet = forESet;
		for_ = FOR_EDEFAULT;
		forESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, XmlnsPackage.KEY_TYPE__FOR, oldFor, FOR_EDEFAULT, oldForESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFor() {
		return forESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSgraphmlType() {
		return sgraphmlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSgraphmlType(String newSgraphmlType) {
		String oldSgraphmlType = sgraphmlType;
		sgraphmlType = newSgraphmlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmlnsPackage.KEY_TYPE__SGRAPHML_TYPE, oldSgraphmlType, sgraphmlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmlnsPackage.KEY_TYPE__DEFAULT:
				return basicSetDefault(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmlnsPackage.KEY_TYPE__DESC:
				return getDesc();
			case XmlnsPackage.KEY_TYPE__DEFAULT:
				return getDefault();
			case XmlnsPackage.KEY_TYPE__ATTR_NAME:
				return getAttrName();
			case XmlnsPackage.KEY_TYPE__ATTR_TYPE:
				return getAttrType();
			case XmlnsPackage.KEY_TYPE__FOR:
				return getFor();
			case XmlnsPackage.KEY_TYPE__ID:
				return getId();
			case XmlnsPackage.KEY_TYPE__SGRAPHML_TYPE:
				return getSgraphmlType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XmlnsPackage.KEY_TYPE__DESC:
				setDesc((String)newValue);
				return;
			case XmlnsPackage.KEY_TYPE__DEFAULT:
				setDefault((DefaultType)newValue);
				return;
			case XmlnsPackage.KEY_TYPE__ATTR_NAME:
				setAttrName((String)newValue);
				return;
			case XmlnsPackage.KEY_TYPE__ATTR_TYPE:
				setAttrType((KeyTypeType)newValue);
				return;
			case XmlnsPackage.KEY_TYPE__FOR:
				setFor((KeyForType)newValue);
				return;
			case XmlnsPackage.KEY_TYPE__ID:
				setId((String)newValue);
				return;
			case XmlnsPackage.KEY_TYPE__SGRAPHML_TYPE:
				setSgraphmlType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XmlnsPackage.KEY_TYPE__DESC:
				setDesc(DESC_EDEFAULT);
				return;
			case XmlnsPackage.KEY_TYPE__DEFAULT:
				setDefault((DefaultType)null);
				return;
			case XmlnsPackage.KEY_TYPE__ATTR_NAME:
				setAttrName(ATTR_NAME_EDEFAULT);
				return;
			case XmlnsPackage.KEY_TYPE__ATTR_TYPE:
				unsetAttrType();
				return;
			case XmlnsPackage.KEY_TYPE__FOR:
				unsetFor();
				return;
			case XmlnsPackage.KEY_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case XmlnsPackage.KEY_TYPE__SGRAPHML_TYPE:
				setSgraphmlType(SGRAPHML_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XmlnsPackage.KEY_TYPE__DESC:
				return DESC_EDEFAULT == null ? desc != null : !DESC_EDEFAULT.equals(desc);
			case XmlnsPackage.KEY_TYPE__DEFAULT:
				return default_ != null;
			case XmlnsPackage.KEY_TYPE__ATTR_NAME:
				return ATTR_NAME_EDEFAULT == null ? attrName != null : !ATTR_NAME_EDEFAULT.equals(attrName);
			case XmlnsPackage.KEY_TYPE__ATTR_TYPE:
				return isSetAttrType();
			case XmlnsPackage.KEY_TYPE__FOR:
				return isSetFor();
			case XmlnsPackage.KEY_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case XmlnsPackage.KEY_TYPE__SGRAPHML_TYPE:
				return SGRAPHML_TYPE_EDEFAULT == null ? sgraphmlType != null : !SGRAPHML_TYPE_EDEFAULT.equals(sgraphmlType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (desc: ");
		result.append(desc);
		result.append(", attrName: ");
		result.append(attrName);
		result.append(", attrType: ");
		if (attrTypeESet) result.append(attrType); else result.append("<unset>");
		result.append(", for: ");
		if (forESet) result.append(for_); else result.append("<unset>");
		result.append(", id: ");
		result.append(id);
		result.append(", sgraphmlType: ");
		result.append(sgraphmlType);
		result.append(')');
		return result.toString();
	}

} //KeyTypeImpl