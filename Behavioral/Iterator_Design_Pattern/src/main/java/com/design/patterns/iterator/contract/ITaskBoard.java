package com.design.patterns.iterator.contract;

public interface ITaskBoard<T> {

	ITicketIterator<T> openIterator();
}
