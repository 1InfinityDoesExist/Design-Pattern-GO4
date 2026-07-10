package com.design.patterns.iterator;

import com.design.patterns.iterator.contract.ITicketIterator;
import com.design.patterns.iterator.contract.concrete.TaskBoard;

public class TaskBoardDesignPattern {

	public static void main(String[] args) {
		System.out.println("Iterator Design Pattern");

		TaskBoard board = new TaskBoard();
		board.addTicket("P0: Fix payment gateway timeout");
		board.addTicket("P1: Add dark mode toggle");
		board.addTicket("P2: Refactor logging module");

		ITicketIterator<String> iterator = board.openIterator();

		System.out.println("Tickets in priority order:");
		while (iterator.hasNext()) {
			System.out.println(" 🎫 " + iterator.next());
		}
	}
}
