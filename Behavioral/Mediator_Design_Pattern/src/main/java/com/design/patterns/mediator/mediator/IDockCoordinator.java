package com.design.patterns.mediator.mediator;

import com.design.patterns.mediator.colleague.IDeliveryTruck;

public interface IDockCoordinator {

	void register(IDeliveryTruck truck);

	void requestLoadingBay(IDeliveryTruck truck);

	void requestUnloadingBay(IDeliveryTruck truck);

}
