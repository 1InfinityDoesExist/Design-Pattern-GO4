package com.design.patterns.mediator.colleague.concrete;

import com.design.patterns.mediator.colleague.IDeliveryTruck;
import com.design.patterns.mediator.mediator.IDockCoordinator;

public class DeliveryTruck implements IDeliveryTruck {

	private final String truckId;
	private final IDockCoordinator coordinator;

	public DeliveryTruck(String truckId, IDockCoordinator coordinator) {
		this.truckId = truckId;
		this.coordinator = coordinator;
		coordinator.register(this);
	}

	@Override
	public void requestLoadingBay() {
		System.out.println(truckId + " -> Dock: requesting loading bay.");
		coordinator.requestLoadingBay(this);
	}

	@Override
	public void requestUnloadingBay() {
		System.out.println(truckId + " -> Dock: requesting unloading bay.");
		coordinator.requestUnloadingBay(this);
	}

	@Override
	public void notifyDockCoordinator(String msg) {
		System.out.println("Dock -> " + truckId + ": " + msg);
	}
}
