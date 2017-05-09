package ui;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
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
		Object[] shapes = {"Punt","Cirkel","Rechthoek"};
		Object keuze = JOptionPane.showInputDialog(null,"Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		if (keuze.equals("Punt")) {
			askForPunt();
		}
		if (keuze.equals("Cirkel")) {
			//TODO
		}
		if (keuze.equals("Rechthoek")) {
			askForRechthoek();
		}
	} 
	
	private void askForPunt() throws DomainException {
		Punt punt = askForPuntCoord();
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		//TODO: add punt to game/speler?
	}
	
	private Punt askForPuntCoord() throws DomainException {
		String xcoord = JOptionPane.showInputDialog("x coordinaat van een punt:");
		checkParamInt(xcoord);
		String ycoord = JOptionPane.showInputDialog("y coordinaat van een punt:");
		checkParamInt(ycoord);
		Punt punt = new Punt(Integer.parseInt(xcoord), Integer.parseInt(ycoord));
		return punt;
	}
	
	private void askForRechthoek() throws DomainException {
		JOptionPane.showMessageDialog(null, "Geef coordinaten van linkerbovenhoek punt in.");
		Punt linkerBovenHoek = askForPuntCoord();
		String breedte = JOptionPane.showInputDialog("Breedte van de rechthoek:");
		checkParamInt(breedte);
		String hoogte = JOptionPane.showInputDialog("Hoogte van de rechthoek:");
		checkParamInt(hoogte);
		Rechthoek rechthoek = new Rechthoek(linkerBovenHoek, Integer.parseInt(breedte), Integer.parseInt(hoogte));
		JOptionPane.showMessageDialog(null, "U heeft een correct rechthoek aangemaakt: " + rechthoek.toString());
		//TODO: add punt to game/speler?//TODO
	}
	
	private void checkParamInt(String coord) throws DomainException {
		if (coord == null || coord.trim().isEmpty()) {
			throw new DomainException("Geen (juiste) integer gegeven!");
		}
	}

}
