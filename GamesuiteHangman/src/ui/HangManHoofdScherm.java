package ui;

import java.awt.BorderLayout;

import domain.HangMan;

public class HangManHoofdScherm extends GameHoofdScherm {

	private static final long serialVersionUID = 1L;
	
	public HangManHoofdScherm(HangMan spel, HangmanPaneel spelpaneel) throws UiException{
		super("Hangman - " + spel.getSpeler().getNaam(), spel.getTekening().getLijst());	
		
		spelpaneel.setTekenVenster(getTekenvenster());
		this.add(spelpaneel, BorderLayout.SOUTH);
	}
	
	public void start() {
		this.pack();
		this.setVisible(true);		
	}
	
	public void end() {
		this.setVisible(false);
	}
}
