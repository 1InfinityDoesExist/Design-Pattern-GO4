package com.design.patterns.iterator;

import com.design.patterns.iterator.contract.IIterator;
import com.design.patterns.iterator.contract.concrets.Playlist;

public class IteratorDesignPattern {

	public static void main(String[] args) {
		System.out.println("Iterator Design Pattern");

		Playlist playlist = new Playlist();
		playlist.addSong("Shape of You");
		playlist.addSong("Bohemian Rhapsody");
		playlist.addSong("Blinding Lights");

		IIterator<String> iterator = playlist.createIterator();

		System.out.println("Now Playing:");
		while (iterator.hasNext()) {
			System.out.println(" 🎵 " + iterator.next());
		}
	}
}
