package ui;

import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
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
		Object[] shapes = {"Punt","Lijnstuk","Cirkel","Rechthoek","Driehoek"};
		Object keuze = JOptionPane.showInputDialog(null,"Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		if (keuze.equals("Punt")) {
			askForPunt();
		}
		if (keuze.equals("Lijnstuk")) {
			askForLijnstuk();
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
		try {
			Punt punt = askForPuntCoord();
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
			//TODO: add punt to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForPunt();
		}
	}
	
	private void askForLijnstuk() {
		try {
			JOptionPane.showMessageDialog(null, "Geef coordinaten van beginpunt in.");
			Punt beginpunt = askForPuntCoord();
			JOptionPane.showMessageDialog(null, "Geef coordinaten van eindpunt in.");
			Punt eindpunt = askForPuntCoord();
			LijnStuk lijnstuk = new LijnStuk(beginpunt,eindpunt);
			JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk aangemaakt: " + lijnstuk.toString());
			//TODO: add lijnstuk to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			askForLijnstuk();
		}
	}
	
	private void askForRechthoek() throws DomainException {
		try {
			JOptionPane.showMessageDialog(null, "Geef coordinaten van linkerbovenhoek punt in.");
			Punt linkerBovenHoek = askForPuntCoord();
			String breedte = JOptionPane.showInputDialog("Breedte van de rechthoek:");
			checkParamInt(breedte);
			String hoogte = JOptionPane.showInputDialog("Hoogte van de rechthoek:");
			checkParamInt(hoogte);
			Rechthoek rechthoek = new Rechthoek(linkerBovenHoek, Integer.parseInt(breedte), Integer.parseInt(hoogte));
			JOptionPane.showMessageDialog(null, "U heeft een correct rechthoek aangemaakt: " + rechthoek.toString());
			//TODO: add punt to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForRechthoek();
		}
	}
	
	private void askForDriehoek() throws DomainException {
		try {
			JOptionPane.showMessageDialog(null, "Geef coordinaten van eerste hoekpunt in.");
			Punt hoekPunt1 = askForPuntCoord();
			JOptionPane.showMessageDialog(null, "Geef coordinaten van tweede hoekpunt in.");
			Punt hoekPunt2 = askForPuntCoord();
			JOptionPane.showMessageDialog(null, "Geef coordinaten van derde hoekpunt in.");
			Punt hoekPunt3 = askForPuntCoord();
			Driehoek driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
			JOptionPane.showMessageDialog(null, "U heeft een correct driehoek aangemaakt: " + driehoek.toString());
			//TODO: add driehoek to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForDriehoek();
		}
	}
	
	private void checkParamInt(String coord) throws DomainException {
		if (coord == null || coord.trim().isEmpty()) {
			throw new DomainException("Vul alles in.");
		}
		//Test if digit with regular expression:
		// -?     --> negative sign, could have none or one
		// \\d+   --> one or more digits
		if (!coord.matches("^?\\d+$")) {
			throw new DomainException("Geef positieve nummers.");
		}
	}
	
	private Punt askForPuntCoord() throws DomainException {
		try {
			String xcoord = JOptionPane.showInputDialog("x coordinaat van een punt:");
			checkParamInt(xcoord);
			String ycoord = JOptionPane.showInputDialog("y coordinaat van een punt:");
			checkParamInt(ycoord);
			Punt punt = new Punt(Integer.parseInt(xcoord), Integer.parseInt(ycoord));
			return punt;
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			return askForPuntCoord();
		}
	}

}