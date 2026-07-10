package com.design.patterns.command;

import com.design.patterns.command.controller.IActuatorCommand;
import com.design.patterns.command.controller.concretes.DisengageActuatorCommand;
import com.design.patterns.command.controller.concretes.EngageActuatorCommand;
import com.design.patterns.command.controller.concretes.GripPayloadCommand;
import com.design.patterns.command.controller.concretes.MoveJointCommand;
import com.design.patterns.command.invoker.TaskQueue;
import com.design.patterns.command.receiver.concretes.GripperActuator;
import com.design.patterns.command.receiver.concretes.JointActuator;

public class CommandDesignPattern {

	public static void main(String[] args) {
		System.out.println("Command Design Pattern");

		JointActuator joint = new JointActuator();
		GripperActuator gripper = new GripperActuator();

		IActuatorCommand engageJoint = new EngageActuatorCommand(joint);
		IActuatorCommand gripPayload = new GripPayloadCommand(gripper);
		IActuatorCommand moveJoint = new MoveJointCommand(joint);
		IActuatorCommand disengageJoint = new DisengageActuatorCommand(joint);

		TaskQueue taskQueue = new TaskQueue();

		taskQueue.assignTask(engageJoint);
		taskQueue.dispatchTask();

		taskQueue.assignTask(gripPayload);
		taskQueue.dispatchTask();

		taskQueue.assignTask(moveJoint);
		taskQueue.dispatchTask();

		taskQueue.assignTask(disengageJoint);
		taskQueue.dispatchTask();
	}
}
