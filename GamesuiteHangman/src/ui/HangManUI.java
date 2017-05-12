package ui;
import domain.Speler;
import domain.WoordenLijst;
import domain.DomainException;
import domain.HangMan;

public class HangManUI {

	private Speler speler;
	
	public HangManUI (Speler speler) throws Exception {
		if( speler == null ) {
			throw new DomainException("Speler mag niet null zijn.");
		}
		this.speler = speler;
		WoordenLijst wl = new WoordenLijst();
		wl.ini();
		play(wl);
	}
	
	public void play( WoordenLijst wl ) throws Exception {
		
		HangMan spel = new HangMan(speler, wl);
		spel.getTekening().reset();
		HangmanPaneel paneel = new HangmanPaneel(spel);
		HangManHoofdScherm scherm = new HangManHoofdScherm(spel, paneel);
		scherm.start();
	}
}
