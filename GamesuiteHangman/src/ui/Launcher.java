package ui;
import javax.swing.JOptionPane;
import domain.DomainException;
import domain.Speler;

public class Launcher {

private static PictionaryUi ui;
	
	public static void main(String[] args) throws DomainException {
		
		Speler speler = addSpeler();
		
		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, speler.getNaam() + " heeft als score: " + speler.getScore(), speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

		ui = new PictionaryUi(speler);
		ui.showMenu();
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
