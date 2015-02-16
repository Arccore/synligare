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
package org.eclipse.eatop.examples.graphicaleditor.bd.features.create;

import org.eclipse.core.runtime.Assert;
import org.eclipse.eatop.eastadl21.Eastadl21Factory;
import org.eclipse.eatop.eastadl21.FunctionTrigger;
import org.eclipse.eatop.eastadl21.Mode;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.sphinx.graphiti.workspace.ui.util.DiagramUtil;



public class CreateFunctionTriggerToModeFeature extends
		AbstractCreateConnectionFeature {

	public CreateFunctionTriggerToModeFeature(IFeatureProvider fp) {
		super(fp, "FunctionTrigger To Mode", "Create FunctionTriggerToMode");
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
        FunctionTrigger source = getFunctionTrigger(context.getSourceAnchor());
        Mode target = getMode(context.getTargetAnchor());
        if (source != null && target != null && source != target) {
            return true;
        }
        return false;
    }

	@Override
	public Connection create(ICreateConnectionContext context) {
        Connection newConnection = null;
 
        FunctionTrigger ft = getFunctionTrigger(context.getSourceAnchor()); //this is source
        Mode Mode = getMode(context.getTargetAnchor()); //this is target
        
        Assert.isNotNull(ft);
        Assert.isNotNull(Mode);
 
        if (ft != null && Mode != null) {

        	EReference referenceId = Eastadl21Factory.eINSTANCE.getEastadl21Package().getFunctionTrigger_Mode();
        	DiagramUtil.addReferenceToBOResource(ft, referenceId, (EObject) Mode);
        	
            AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
            newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
        }
       
        return newConnection;
    }

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {

        if (getFunctionTrigger(context.getSourceAnchor()) != null) {
            return true;
        }
        return false;
    
	}
	private FunctionTrigger getFunctionTrigger(Anchor anchor) {
        if (anchor != null) {
            Object object = getBusinessObjectForPictogramElement(anchor.getParent());
            if (object instanceof FunctionTrigger) {
                return (FunctionTrigger) object;
            }
        }
        return null;
    }  
    private Mode getMode(Anchor anchor) {
        if (anchor != null) {
            Object object = getBusinessObjectForPictogramElement(anchor.getParent());
            if (object instanceof Mode) {
                return (Mode) object;
            }
        }
        return null;
    }
}
