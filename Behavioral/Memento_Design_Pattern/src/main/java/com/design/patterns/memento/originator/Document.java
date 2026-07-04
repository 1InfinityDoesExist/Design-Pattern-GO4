package com.design.patterns.memento.originator;

import com.design.patterns.memento.memento.DocumentMemento;

public class Document {

	private String content;

	public Document(String content) {
		this.content = content;
	}

	public void write(String text) {
		this.content += text;
	}

	public String getContent() {
		return this.content;
	}

	public DocumentMemento createMemento() {
		return new DocumentMemento(this.content);
	}

	public void restoreFromMemento(DocumentMemento documentMemento) {
		this.content = documentMemento.getSavedContent();
	}

}
