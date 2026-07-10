package com.design.patterns.command.invoker;

import com.design.patterns.command.controller.IActuatorCommand;

public class TaskQueue {
	private IActuatorCommand pendingTask;

	public void assignTask(IActuatorCommand task) {
		this.pendingTask = task;
	}

	public void dispatchTask() {
		if (pendingTask != null) {
			pendingTask.run();
		} else {
			System.out.println("No task assigned");
		}
	}
}
