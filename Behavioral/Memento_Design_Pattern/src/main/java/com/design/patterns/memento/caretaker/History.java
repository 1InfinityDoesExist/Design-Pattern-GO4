package com.design.patterns.memento.caretaker;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.memento.memento.DocumentMemento;

public class History {

	private List<DocumentMemento> mementos;

	public History() {
		this.mementos = new ArrayList<>();
	}

	public void addMemento(DocumentMemento documentMemento) {
		this.mementos.add(documentMemento);
	}

	public DocumentMemento getMemento(int index) {
		return this.mementos.get(index);
	}
}
