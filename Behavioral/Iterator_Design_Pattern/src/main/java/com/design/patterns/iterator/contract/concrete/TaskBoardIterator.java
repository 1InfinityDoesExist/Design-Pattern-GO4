package com.design.patterns.iterator.contract.concrete;

import com.design.patterns.iterator.contract.ITicketIterator;

public class TaskBoardIterator implements ITicketIterator<String> {
	private final TaskBoard board;
	private int cursor = 0;

	public TaskBoardIterator(TaskBoard board) {
		this.board = board;
	}

	@Override
	public boolean hasNext() {
		return cursor < board.getTicketCount();
	}

	@Override
	public String next() {
		return board.getTicketAt(cursor++);
	}
}
