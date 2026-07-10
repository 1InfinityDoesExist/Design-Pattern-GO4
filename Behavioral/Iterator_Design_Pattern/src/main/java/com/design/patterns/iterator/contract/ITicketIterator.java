package com.design.patterns.iterator.contract;

public interface ITicketIterator<T> {

	boolean hasNext();

	T next();
}
