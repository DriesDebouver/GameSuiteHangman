package ui;

import domain.DomainException;
import domain.Driehoek;
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
		//TODO Ipv domain exceptions laten gooien, deze opvangen en als error message ingeven en terug opnieuw methode oproepen voor nieuwe poging!!!
		Object[] shapes = {"Punt","Cirkel","Rechthoek","Driehoek"};
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
		if (keuze.equals("Driehoek")) {
			askForDriehoek();
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
		//TODO: add punt to game/speler?
	}
	
	private void askForDriehoek() throws DomainException {
		JOptionPane.showMessageDialog(null, "Geef coordinaten van eerste hoekpunt in.");
		Punt hoekPunt1 = askForPuntCoord();
		JOptionPane.showMessageDialog(null, "Geef coordinaten van tweede hoekpunt in.");
		Punt hoekPunt2 = askForPuntCoord();
		JOptionPane.showMessageDialog(null, "Geef coordinaten van derde hoekpunt in.");
		Punt hoekPunt3 = askForPuntCoord();
		Driehoek driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
		JOptionPane.showMessageDialog(null, "U heeft een correct driehoek aangemaakt: " + driehoek.toString());
		//TODO: add driehoek to game/speler?
	}
	
	private void checkParamInt(String coord) throws DomainException {
		if (coord == null || coord.trim().isEmpty()) {
			throw new DomainException("Geen (juiste) integer gegeven!");
		}
	}

}
