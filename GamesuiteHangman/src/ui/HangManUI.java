package ui;
import domain.Speler;
import javax.swing.JOptionPane;

import domain.DomainException;
import domain.HintWoord;

public class HangManUI {

	private Speler speler;
	private HintWoord hintWoord;
	
	public HangManUI (Speler speler) throws DomainException {
		if( speler == null ) {
			throw new IllegalArgumentException();
		}
		this.speler = speler;
		hintWoord = new HintWoord( "hangman" );
	}
	
	public void play() {
		int poging = 1;
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
		} while( !hintWoord.isGeraden() );
	}
}
