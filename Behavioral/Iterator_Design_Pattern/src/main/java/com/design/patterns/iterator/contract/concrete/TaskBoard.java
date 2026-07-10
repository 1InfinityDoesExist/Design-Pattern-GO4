package com.design.patterns.iterator.contract.concrete;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.iterator.contract.ITicketIterator;
import com.design.patterns.iterator.contract.ITaskBoard;

public class TaskBoard implements ITaskBoard<String> {
	private final List<String> tickets = new ArrayList<>();

	public void addTicket(String ticket) {
		tickets.add(ticket);
	}

	public String getTicketAt(int index) {
		return tickets.get(index);
	}

	public int getTicketCount() {
		return tickets.size();
	}

	@Override
	public ITicketIterator<String> openIterator() {
		return new TaskBoardIterator(this);
	}
}
