package ui;
import javax.swing.JOptionPane;
import domain.DomainException;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) throws Exception {
		
		Speler speler = addSpeler();
		
		Object[] spellen = {"HangMan", "Pictionary"};
		Object keuze = JOptionPane.showInputDialog(null,"Dag " + speler.getNaam() + ", welk spel wil je spelen?", "input", JOptionPane.INFORMATION_MESSAGE, null, spellen, null);
		
		if (keuze != null){
		if (keuze.equals("HangMan")) {
			HangManUI ui = new HangManUI(speler);
			ui.play();
		}
		if (keuze.equals("Pictionary")) {
			PictionaryUi ui = new PictionaryUi(speler);
			ui.showMenu();
		}
		
		JOptionPane.showMessageDialog(null, speler.getNaam() + " heeft als score: " + speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);	
		}
	}
	
	public static Speler addSpeler() {
		try {
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			Speler speler = new Speler(naam);
			return speler;
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			return addSpeler();
		}
	}
}
