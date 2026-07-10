package com.design.patterns.mediator;

import com.design.patterns.mediator.colleague.IDeliveryTruck;
import com.design.patterns.mediator.colleague.concrete.DeliveryTruck;
import com.design.patterns.mediator.mediator.IDockCoordinator;
import com.design.patterns.mediator.mediator.concrete.WarehouseDockCoordinator;

public class WarehouseDockDesignPattern {

	public static void main(String[] args) {
		System.out.println("Mediator Design Pattern");

		IDockCoordinator dockCoordinator = new WarehouseDockCoordinator();

		IDeliveryTruck truckOne = new DeliveryTruck("Truck-14", dockCoordinator);
		IDeliveryTruck truckTwo = new DeliveryTruck("Truck-29", dockCoordinator);

		truckOne.requestLoadingBay();
		truckTwo.requestUnloadingBay();
	}
}
