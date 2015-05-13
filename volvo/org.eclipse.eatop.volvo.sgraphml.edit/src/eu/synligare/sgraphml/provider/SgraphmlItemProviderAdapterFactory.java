/**
 */
package eu.synligare.sgraphml.provider;

import eu.synligare.sgraphml.util.SgraphmlAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SgraphmlItemProviderAdapterFactory extends SgraphmlAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SgraphmlItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ArrowsType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrowsTypeItemProvider arrowsTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ArrowsType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createArrowsTypeAdapter() {
		if (arrowsTypeItemProvider == null) {
			arrowsTypeItemProvider = new ArrowsTypeItemProvider(this);
		}

		return arrowsTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.BaseEdgeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseEdgeTypeItemProvider baseEdgeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.BaseEdgeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBaseEdgeTypeAdapter() {
		if (baseEdgeTypeItemProvider == null) {
			baseEdgeTypeItemProvider = new BaseEdgeTypeItemProvider(this);
		}

		return baseEdgeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.BaseNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseNodeTypeItemProvider baseNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.BaseNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBaseNodeTypeAdapter() {
		if (baseNodeTypeItemProvider == null) {
			baseNodeTypeItemProvider = new BaseNodeTypeItemProvider(this);
		}

		return baseNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.DocumentRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootItemProvider documentRootItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.DocumentRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDocumentRootAdapter() {
		if (documentRootItemProvider == null) {
			documentRootItemProvider = new DocumentRootItemProvider(this);
		}

		return documentRootItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.EdgeLabelType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeLabelTypeItemProvider edgeLabelTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.EdgeLabelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEdgeLabelTypeAdapter() {
		if (edgeLabelTypeItemProvider == null) {
			edgeLabelTypeItemProvider = new EdgeLabelTypeItemProvider(this);
		}

		return edgeLabelTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.FillType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FillTypeItemProvider fillTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.FillType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFillTypeAdapter() {
		if (fillTypeItemProvider == null) {
			fillTypeItemProvider = new FillTypeItemProvider(this);
		}

		return fillTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.GeometryType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeometryTypeItemProvider geometryTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.GeometryType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGeometryTypeAdapter() {
		if (geometryTypeItemProvider == null) {
			geometryTypeItemProvider = new GeometryTypeItemProvider(this);
		}

		return geometryTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.GroupNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupNodeTypeItemProvider groupNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.GroupNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGroupNodeTypeAdapter() {
		if (groupNodeTypeItemProvider == null) {
			groupNodeTypeItemProvider = new GroupNodeTypeItemProvider(this);
		}

		return groupNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ImageIconType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageIconTypeItemProvider imageIconTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ImageIconType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImageIconTypeAdapter() {
		if (imageIconTypeItemProvider == null) {
			imageIconTypeItemProvider = new ImageIconTypeItemProvider(this);
		}

		return imageIconTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.LabelType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelTypeItemProvider labelTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.LabelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLabelTypeAdapter() {
		if (labelTypeItemProvider == null) {
			labelTypeItemProvider = new LabelTypeItemProvider(this);
		}

		return labelTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.LineStyleType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineStyleTypeItemProvider lineStyleTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.LineStyleType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLineStyleTypeAdapter() {
		if (lineStyleTypeItemProvider == null) {
			lineStyleTypeItemProvider = new LineStyleTypeItemProvider(this);
		}

		return lineStyleTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.NodeLabelType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeLabelTypeItemProvider nodeLabelTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.NodeLabelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeLabelTypeAdapter() {
		if (nodeLabelTypeItemProvider == null) {
			nodeLabelTypeItemProvider = new NodeLabelTypeItemProvider(this);
		}

		return nodeLabelTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.PathType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathTypeItemProvider pathTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.PathType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPathTypeAdapter() {
		if (pathTypeItemProvider == null) {
			pathTypeItemProvider = new PathTypeItemProvider(this);
		}

		return pathTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.PointType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointTypeItemProvider pointTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.PointType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPointTypeAdapter() {
		if (pointTypeItemProvider == null) {
			pointTypeItemProvider = new PointTypeItemProvider(this);
		}

		return pointTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.PolyLineEdgeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PolyLineEdgeTypeItemProvider polyLineEdgeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.PolyLineEdgeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPolyLineEdgeTypeAdapter() {
		if (polyLineEdgeTypeItemProvider == null) {
			polyLineEdgeTypeItemProvider = new PolyLineEdgeTypeItemProvider(this);
		}

		return polyLineEdgeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.PortNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortNodeTypeItemProvider portNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.PortNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPortNodeTypeAdapter() {
		if (portNodeTypeItemProvider == null) {
			portNodeTypeItemProvider = new PortNodeTypeItemProvider(this);
		}

		return portNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ResourceBlockType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceBlockTypeItemProvider resourceBlockTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ResourceBlockType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceBlockTypeAdapter() {
		if (resourceBlockTypeItemProvider == null) {
			resourceBlockTypeItemProvider = new ResourceBlockTypeItemProvider(this);
		}

		return resourceBlockTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ResourceType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceTypeItemProvider resourceTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ResourceType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceTypeAdapter() {
		if (resourceTypeItemProvider == null) {
			resourceTypeItemProvider = new ResourceTypeItemProvider(this);
		}

		return resourceTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ScaledIconType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaledIconTypeItemProvider scaledIconTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ScaledIconType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScaledIconTypeAdapter() {
		if (scaledIconTypeItemProvider == null) {
			scaledIconTypeItemProvider = new ScaledIconTypeItemProvider(this);
		}

		return scaledIconTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ShapeNodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeNodeTypeItemProvider shapeNodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ShapeNodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createShapeNodeTypeAdapter() {
		if (shapeNodeTypeItemProvider == null) {
			shapeNodeTypeItemProvider = new ShapeNodeTypeItemProvider(this);
		}

		return shapeNodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eu.synligare.sgraphml.ShapeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeTypeItemProvider shapeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link eu.synligare.sgraphml.ShapeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createShapeTypeAdapter() {
		if (shapeTypeItemProvider == null) {
			shapeTypeItemProvider = new ShapeTypeItemProvider(this);
		}

		return shapeTypeItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (arrowsTypeItemProvider != null) arrowsTypeItemProvider.dispose();
		if (baseEdgeTypeItemProvider != null) baseEdgeTypeItemProvider.dispose();
		if (baseNodeTypeItemProvider != null) baseNodeTypeItemProvider.dispose();
		if (documentRootItemProvider != null) documentRootItemProvider.dispose();
		if (edgeLabelTypeItemProvider != null) edgeLabelTypeItemProvider.dispose();
		if (fillTypeItemProvider != null) fillTypeItemProvider.dispose();
		if (geometryTypeItemProvider != null) geometryTypeItemProvider.dispose();
		if (groupNodeTypeItemProvider != null) groupNodeTypeItemProvider.dispose();
		if (imageIconTypeItemProvider != null) imageIconTypeItemProvider.dispose();
		if (labelTypeItemProvider != null) labelTypeItemProvider.dispose();
		if (lineStyleTypeItemProvider != null) lineStyleTypeItemProvider.dispose();
		if (nodeLabelTypeItemProvider != null) nodeLabelTypeItemProvider.dispose();
		if (pathTypeItemProvider != null) pathTypeItemProvider.dispose();
		if (pointTypeItemProvider != null) pointTypeItemProvider.dispose();
		if (polyLineEdgeTypeItemProvider != null) polyLineEdgeTypeItemProvider.dispose();
		if (portNodeTypeItemProvider != null) portNodeTypeItemProvider.dispose();
		if (resourceBlockTypeItemProvider != null) resourceBlockTypeItemProvider.dispose();
		if (resourceTypeItemProvider != null) resourceTypeItemProvider.dispose();
		if (scaledIconTypeItemProvider != null) scaledIconTypeItemProvider.dispose();
		if (shapeNodeTypeItemProvider != null) shapeNodeTypeItemProvider.dispose();
		if (shapeTypeItemProvider != null) shapeTypeItemProvider.dispose();
	}

}
