package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {

	private static PictionaryUi ui;
	
	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
	
		ui = new PictionaryUi(speler);
	
		ui.showMenu();
		
	}

}
