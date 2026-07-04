package com.design.patterns.memento;

import com.design.patterns.memento.caretaker.History;
import com.design.patterns.memento.originator.Document;

public class MementoDesignPattern {

	public static void main(String[] args) {
		System.out.println("Memento Design Pattern");
		Document document = new Document("Initial content\n");
		History history = new History();

		document.write("Additional content\n");
		history.addMemento(document.createMemento());

		document.write("More content\n");
		history.addMemento(document.createMemento());

		document.restoreFromMemento(history.getMemento(0));

		System.out.println(document.getContent());

	}
}
