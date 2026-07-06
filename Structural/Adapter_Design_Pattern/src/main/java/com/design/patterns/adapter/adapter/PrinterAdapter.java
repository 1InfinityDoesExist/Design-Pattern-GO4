package com.design.patterns.adapter.adapter;

import com.design.patterns.adapter.adaptee.LegacyPrinter;
import com.design.patterns.adapter.target.Printer;

public class PrinterAdapter implements Printer {

	private final LegacyPrinter legacyPrinter;

	public PrinterAdapter(LegacyPrinter legacyPrinter) {
		this.legacyPrinter = legacyPrinter;
	}

	@Override
	public void print() {
		legacyPrinter.printDocument();
	}
}
