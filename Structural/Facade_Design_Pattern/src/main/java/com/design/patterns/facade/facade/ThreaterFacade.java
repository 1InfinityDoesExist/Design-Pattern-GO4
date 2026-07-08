package com.design.patterns.facade.facade;

import com.design.patterns.facade.complex.MoviePlayer;
import com.design.patterns.facade.complex.MusicPlayer;

public class ThreaterFacade {

	private MoviePlayer moviePlayer;
	private MusicPlayer musicPlayer;

	public ThreaterFacade(MoviePlayer moviePlayer, MusicPlayer musicPlayer) {
		this.moviePlayer = moviePlayer;
		this.musicPlayer = musicPlayer;
	}

	public void startMovie() {
		moviePlayer.on();
		musicPlayer.on();
		moviePlayer.increaseVolumn();
	}

	public void endMovide() {
		moviePlayer.off();
		musicPlayer.off();
	}
}
