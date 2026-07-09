package com.design.patterns.iterator.contract.concrets;

import com.design.patterns.iterator.contract.IIterator;

public class PlaylistIterator implements IIterator<String> {
	private final Playlist playlist;
	private int index = 0;

	public PlaylistIterator(Playlist playlist) {
		this.playlist = playlist;
	}

	@Override
	public boolean hasNext() {
		return index < playlist.getSize();
	}

	@Override
	public String next() {
		return playlist.getSongAt(index++);
	}
}
