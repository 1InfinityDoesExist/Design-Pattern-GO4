package com.design.patterns.facade;

import com.design.patterns.facade.complex.MoviePlayer;
import com.design.patterns.facade.complex.MusicPlayer;
import com.design.patterns.facade.facade.ThreaterFacade;

public class FacadeDesignPattern {

	public static void main(String[] args) {
		System.out.println("Facade Design Pattern");

		ThreaterFacade threaterFacade = new ThreaterFacade(new MoviePlayer(), new MusicPlayer());
		threaterFacade.startMovie();
		threaterFacade.endMovide();
	}
}
