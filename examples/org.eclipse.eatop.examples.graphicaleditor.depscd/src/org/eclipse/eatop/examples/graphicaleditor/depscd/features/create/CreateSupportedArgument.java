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
package org.eclipse.eatop.examples.graphicaleditor.depscd.features.create;

import org.eclipse.eatop.eastadl21.Claim;
import org.eclipse.eatop.eastadl21.Eastadl21Factory;
import org.eclipse.eatop.eastadl21.Warrant;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.sphinx.graphiti.workspace.ui.util.DiagramUtil;


public class CreateSupportedArgument extends AbstractCreateConnectionFeature {
	public static int lock = 0;
	public CreateSupportedArgument(IFeatureProvider fp) {
		super(fp,"Claim To WarrantSupportedArgument", "Create SupportedArgument");
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		lock=1;
		// return true if both anchors belong to an EClass
        // and those EClasses are not identical
        Claim source = getClaim(context.getSourceAnchor());
        Warrant target = getWarrant(context.getTargetAnchor());
        if (source != null && target != null && source != target) {
            return true;
        }
        return false;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		 
        // get EClasses which should be connected
        Claim claim = getClaim(context.getSourceAnchor());
        Warrant warrant = getWarrant(context.getTargetAnchor());
        Assert.isNotNull(claim);
        Assert.isNotNull(warrant);
        
        if (claim != null && warrant != null) {
        	EReference referenceId = Eastadl21Factory.eINSTANCE.getEastadl21Package().getClaim_SupportedArgument();
        	DiagramUtil.addReferenceToBOResource(claim, referenceId, warrant);
        	
        	AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }
        lock = 0;
        return newConnection;
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		  // return true if start anchor belongs to a EClass
        if (getClaim(context.getSourceAnchor()) != null) {
            return true;
        }
        return false;
	}
	private Warrant getWarrant(Anchor targetAnchor) {
		if (targetAnchor != null) {
            Object object =
                getBusinessObjectForPictogramElement(targetAnchor.getParent());
            if (object instanceof Warrant) {
                return (Warrant) object;
            }
        }
        return null;
	}

	private Claim getClaim(Anchor sourceAnchor) {
		if (sourceAnchor != null) {
            Object object =
                getBusinessObjectForPictogramElement(sourceAnchor.getParent());
            if (object instanceof Claim) {
                return (Claim) object;
            }
        }
        return null;
	}
}