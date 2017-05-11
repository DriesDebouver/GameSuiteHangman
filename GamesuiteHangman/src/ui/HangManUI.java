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
		
		//Old code
		/** int poging = 0;
		boolean pogingJuist = false;
		
		do {
			String input = JOptionPane.showInputDialog(
				null,
				( poging > 1 ? ( pogingJuist ? "Super, doe zo voort!\n\n" : "Helaas, volgende keer beter!\n\n" ) : "" ) +
				"Rarara, welk woord zoeken we\n\n" + hintWoord.toString() + "\n\nGeef een letter:",
				"Hangman - " + speler.getNaam(),
				JOptionPane.INFORMATION_MESSAGE
			);
			if( !input.trim().isEmpty() && input.length() == 1 ) {
				pogingJuist = hintWoord.raad( input.charAt( 0 ) );
				poging++;
			}
		} while( !hintWoord.isGeraden() ); */
	}
}
