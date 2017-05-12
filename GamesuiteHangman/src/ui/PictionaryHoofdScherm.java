package ui;

import java.awt.BorderLayout;

import domain.Pictionary;

@SuppressWarnings("serial")
public class PictionaryHoofdScherm  extends GameHoofdScherm {

	public PictionaryHoofdScherm(Pictionary spel, PictionaryPaneel paneel) throws UiException {
		super("Pictionary - " + spel.getSpeler().getNaam(), spel.getTekening());
		
		paneel.setTekenVenster(getTekenvenster());
		this.add(paneel, BorderLayout.SOUTH);
	}

	public void start() {
		this.pack();
		this.setVisible(true);		
	}
	
	public void end() {
		this.setVisible(false);
	}
	
}
