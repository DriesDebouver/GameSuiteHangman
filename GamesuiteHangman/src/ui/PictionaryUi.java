package ui;

import domain.Punt;
import domain.Speler;
import javax.swing.JOptionPane;

public class PictionaryUi {
	
	private Speler speler;

	public PictionaryUi(Speler speler) {
		super();
		this.speler = speler;
	}
	
	public void showMenu() {
		getPunt();
		//TODO: Menu van maken
	}
	
	private void getPunt() {
		String xcoord = JOptionPane.showInputDialog("x coordinaat van een punt:");
		String ycoord = JOptionPane.showInputDialog("y coordinaat van een punt:");
		Punt punt = new Punt(Integer.parseInt(xcoord), Integer.parseInt(ycoord));
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		//TODO: add punt to game/speler?
	}

}
