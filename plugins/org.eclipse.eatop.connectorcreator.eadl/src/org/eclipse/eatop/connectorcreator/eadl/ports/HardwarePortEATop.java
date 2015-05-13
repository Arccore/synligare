package org.eclipse.eatop.connectorcreator.eadl.ports;

import org.eclipse.eatop.connectorcreator.ports.PortPrototypeInterface;
import org.eclipse.eatop.eastadl21.HardwarePort;


public class HardwarePortEATop implements PortPrototypeInterface {
	private HardwarePort port;

	public HardwarePortEATop(HardwarePort port) {
		this.port = port;
	}

	@Override
	public String getName() {
		return port.getShortName();
	}

	@Override
	public Object getObject() {
		return port;
	}

	@Override
	public PortDirection getPortDirection() {
		return PortDirection.PIN;
	}
}