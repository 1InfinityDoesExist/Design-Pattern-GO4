package com.design.patterns.mediator.colleague;

public interface IDeliveryTruck {

	void requestLoadingBay();

	void requestUnloadingBay();

	void notifyDockCoordinator(String msg);

}
