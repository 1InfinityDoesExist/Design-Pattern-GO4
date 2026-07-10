package com.design.patterns.mediator.mediator.concrete;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.mediator.colleague.IDeliveryTruck;
import com.design.patterns.mediator.mediator.IDockCoordinator;

public class WarehouseDockCoordinator implements IDockCoordinator {

	private final List<IDeliveryTruck> trucks = new ArrayList<>();

	@Override
	public void register(IDeliveryTruck truck) {
		trucks.add(truck);
	}

	@Override
	public void requestLoadingBay(IDeliveryTruck truck) {
		truck.notifyDockCoordinator("Loading bay assigned.");
		notifyOtherTrucks(truck, "Hold position: another truck is loading.");
	}

	@Override
	public void requestUnloadingBay(IDeliveryTruck truck) {
		truck.notifyDockCoordinator("Unloading bay assigned.");
		notifyOtherTrucks(truck, "Stay clear of the dock: another truck is unloading.");
	}

	private void notifyOtherTrucks(IDeliveryTruck requester, String msg) {
		trucks.stream()
				.filter(other -> other != requester)
				.forEach(other -> other.notifyDockCoordinator(msg));
	}

}
