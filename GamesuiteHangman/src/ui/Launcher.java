package ui;
import javax.swing.JOptionPane;
import domain.DomainException;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) throws Exception {
		
		Speler speler = addSpeler();
		
		startPlaying(speler);
	}
	
	public static Speler addSpeler() {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		if (naam != null) {
			try {
				Speler speler = new Speler(naam);
				return speler;
			} catch (DomainException e) {
				JOptionPane.showMessageDialog(null,e.getMessage());
				return addSpeler();
			}
		} else {
			System.exit(0);
			return null;
		}
	}
	
	public static void startPlaying(Speler speler) throws Exception {
		Object[] spellen = {"HangMan", "Pictionary", "DrawShapes"};
		Object keuze = JOptionPane.showInputDialog(null,"Dag " + speler.getNaam() + ", welk spel wil je spelen?", "input", JOptionPane.INFORMATION_MESSAGE, null, spellen, null);
		
		if (keuze != null) {
			if (keuze.equals("HangMan")) {
				new HangManUI(speler);
			}
			if (keuze.equals("Pictionary")) {
				PictionaryUi ui = new PictionaryUi(speler);
				ui.play();
			}
			if (keuze.equals("DrawShapes")) {
				DrawGameUi ui = new DrawGameUi(speler);
				ui.showMenu();
			}
		} else {
			System.exit(0);
		}
	}
}
