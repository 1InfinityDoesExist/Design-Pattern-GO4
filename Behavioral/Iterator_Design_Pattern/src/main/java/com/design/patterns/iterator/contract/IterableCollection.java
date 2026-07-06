package com.design.patterns.iterator.contract;

public interface IterableCollection<T> {

	IIterator<T> createIterator();
}
