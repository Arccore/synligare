/**
 * <copyright>
 *  
 * Copyright (c) 2014 Continental AG and others.
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 
 * which accompanies this distribution, and is
 * available at http://www.eclipse.org/org/documents/epl-v10.php
 *  
 * Contributors: 
 *     Continental AG - Initial API and implementation
 *  
 * </copyright>
 * 
 */
package org.eclipse.eatop.examples.graphicaleditor.emtd.features.prototypes;

import org.eclipse.eatop.eastadl21.Eastadl21Factory;
import org.eclipse.eatop.eastadl21.ErrorModelPrototype;
import org.eclipse.eatop.eastadl21.ErrorModelType;
import org.eclipse.eatop.examples.graphicaleditor.emtd.provider.EMTDImageProvider;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.sphinx.graphiti.workspace.ui.util.DiagramUtil;


public class CreateErrorModelPrototypeFeature extends
		AbstractCreateFeature 
		{
	private static final String TITLE = "Create Error Model Prototype ";

	private static final String USER_QUESTION = "Enter new Error Model Prototype name";

	public CreateErrorModelPrototypeFeature(IFeatureProvider fp) 
	{
		super(fp, "ErrorModelPrototype ",
				"Create Error Model Prototype");
	}

	@Override
	public String getCreateImageId() 
	{
		return EMTDImageProvider.ERROR_MODEL_PROTOTYPE;
		
	}

	@Override
	public boolean canCreate(ICreateContext context) 
	{
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) 
	{
		String newQualReqShirtName = ExampleUtil.askString(TITLE,
				USER_QUESTION, "");
		if (newQualReqShirtName == null
				|| newQualReqShirtName.trim().length() == 0) 
		{
			return EMPTY;
		}
		// create QualityRequirement
		ErrorModelPrototype newQualReq = Eastadl21Factory.eINSTANCE
				.createErrorModelPrototype();
		newQualReq.setShortName(newQualReqShirtName);
		Assert.isTrue(getDiagram().getLink().getBusinessObjects().get(0) instanceof ErrorModelType);
		ErrorModelType parentBO = (ErrorModelType) getDiagram()
				.getLink().getBusinessObjects().get(0);
		EReference referenceId = Eastadl21Factory.eINSTANCE.getEastadl21Package().getDesignFunctionType_Part();
		String fragment = EcoreUtil.getURI(newQualReq).fragment();
		if (DiagramUtil.getEObject(parentBO, fragment) != null) {
			// the object already exist (Drag & Drop)
		} else {
			DiagramUtil.addObjectToBOResource(parentBO, referenceId, newQualReq);
		}

		addGraphicalRepresentation(context, newQualReq);
		// activate direct editing after object creation
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		// return newly created business object(s)
		return new Object[] { newQualReq };
	}

	
}
