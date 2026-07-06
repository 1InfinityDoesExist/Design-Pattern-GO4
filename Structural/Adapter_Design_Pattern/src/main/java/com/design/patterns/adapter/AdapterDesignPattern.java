package com.design.patterns.adapter;

import com.design.patterns.adapter.adaptee.LegacyPrinter;
import com.design.patterns.adapter.adapter.PrinterAdapter;
import com.design.patterns.adapter.target.Printer;

public class AdapterDesignPattern {

	public static void main(String[] args) {
		System.out.println("Adapter Design Pattern");

		Printer printer = new PrinterAdapter(new LegacyPrinter());
		printer.print();
	}
}
