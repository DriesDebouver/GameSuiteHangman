package ui;

import domain.DomainException;
import domain.Punt;
import domain.Speler;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class PictionaryUi {
	
	private Speler speler;

	public PictionaryUi(Speler speler) {
		super();
		this.speler = speler;
	}
	
	public void showMenu() throws DomainException {
		askForPuntCoord();
		//TODO: Menu van maken
	}
	
	private void askForPuntCoord() throws DomainException {
		String xcoord = JOptionPane.showInputDialog("x coordinaat van een punt:");
		checkCoord(xcoord);
		String ycoord = JOptionPane.showInputDialog("y coordinaat van een punt:");
		checkCoord(ycoord);
		Punt punt = new Punt(Integer.parseInt(xcoord), Integer.parseInt(ycoord));
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		//TODO: add punt to game/speler?
	}
	
	private void checkCoord(String coord) throws DomainException {
		if (coord == null || coord.trim().isEmpty()) {
			throw new DomainException("Coordinaat niet juist!");
		}
	}

}
