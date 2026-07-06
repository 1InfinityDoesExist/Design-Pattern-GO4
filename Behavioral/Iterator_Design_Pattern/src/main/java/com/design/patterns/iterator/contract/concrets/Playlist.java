package com.design.patterns.iterator.contract.concrets;

import java.util.ArrayList;
import java.util.List;

import com.design.patterns.iterator.contract.IIterator;
import com.design.patterns.iterator.contract.IterableCollection;

public class Playlist implements IterableCollection<String> {
	private final List<String> songs = new ArrayList<>();

	public void addSong(String song) {
		songs.add(song);
	}

	public String getSongAt(int index) {
		return songs.get(index);
	}

	public int getSize() {
		return songs.size();
	}

	@Override
	public IIterator<String> createIterator() {
		return new PlaylistIterator(this);
	}
}