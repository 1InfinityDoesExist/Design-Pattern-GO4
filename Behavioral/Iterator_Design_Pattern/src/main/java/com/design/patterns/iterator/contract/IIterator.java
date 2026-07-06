package com.design.patterns.iterator.contract;

public interface IIterator<T> {

	boolean hasNext();

	T next();
}
