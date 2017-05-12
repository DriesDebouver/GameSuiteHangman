package ui;

import domain.Pictionary;
import domain.Speler;
import domain.Tekening;

public class PictionaryUi {
	
	private Speler speler;
	public PictionaryUi(Speler speler) throws Exception {
		super();
		this.speler = speler;
		new Tekening("tekening1");
	}
	
	public void play() throws Exception {
		Pictionary spel = new Pictionary(speler);
		PictionaryPaneel paneel = new PictionaryPaneel(spel);
		PictionaryHoofdScherm scherm = new PictionaryHoofdScherm(spel, paneel);
		scherm.start();
	}

}