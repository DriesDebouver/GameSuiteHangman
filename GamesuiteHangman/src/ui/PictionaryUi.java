package ui;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;
import domain.TekeningHangMan;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class PictionaryUi {
	
	private Speler speler;
	private Tekening tekening;

	public PictionaryUi(Speler speler) throws DomainException {
		super();
		this.speler = speler;
		tekening = new Tekening("tekening1");
	}
	
	public void showMenu() throws DomainException, UiException {
		TekeningHangMan hmt = null;
		Object[] shapes = {"Lijnstuk","Cirkel","Rechthoek","Driehoek","HangMan"};
		Object keuze = JOptionPane.showInputDialog(null,"Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		if (keuze.equals("Lijnstuk")) {
			askForLijnstuk();
		}
		if (keuze.equals("Cirkel")) {
			askForCirkel();
		}
		if (keuze.equals("Rechthoek")) {
			askForRechthoek();
		}
		if (keuze.equals("Driehoek")) {
			askForDriehoek();
		}
		if (keuze.equals("HangMan")) {
			try {
				hmt = new TekeningHangMan();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(hmt!=null) {
			tekening = hmt.getLijst();
		}
		GameHoofdScherm vieuw = new GameHoofdScherm(speler.getNaam() + " zijn/haar tekening", tekening);
		vieuw.setVisible(true);
		vieuw.teken();
	} 
	
	private void askForPunt() throws DomainException {
		try {
			Punt punt = askForPuntCoord("punt");
			JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForPunt();
		}
	}
	
	private void askForLijnstuk() {
		try {
			Punt beginpunt = askForPuntCoord("beginpunt lijnstuk");
			Punt eindpunt = askForPuntCoord("eindpunt lijnstuk");
			LijnStuk lijnstuk = new LijnStuk(beginpunt,eindpunt);
			JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk aangemaakt: " + lijnstuk.toString());
			tekening.voegToe(lijnstuk);
			return;
			//TODO: add lijnstuk to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			askForLijnstuk();
		}
	}
	
	private void askForCirkel() {
		try {
			Punt middelpunt = askForPuntCoord("middelpunt cirkel");
			int straal = askForInt("straal cirkel");
			Cirkel cirkel = new Cirkel(middelpunt, straal);
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
			tekening.voegToe(cirkel);
			//TODO: add lijnstuk to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			askForCirkel();
		}
	}
	
	private void askForRechthoek() throws DomainException {
		try {
			Punt linkerBovenHoek = askForPuntCoord("linkerbovenhoek");
			int breedte = askForInt("breedte van de rechthoek");
			int hoogte = askForInt("hoogte van de rechthoek");
			Rechthoek rechthoek = new Rechthoek(linkerBovenHoek, breedte, hoogte);
			JOptionPane.showMessageDialog(null, "U heeft een correct rechthoek aangemaakt: " + rechthoek.toString());
			tekening.voegToe(rechthoek);
			//TODO: add punt to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForRechthoek();
		}
	}
	
	private void askForDriehoek() throws DomainException {
		try {
			Punt hoekPunt1 = askForPuntCoord("eerste hoekpunt driehoek");
			Punt hoekPunt2 = askForPuntCoord("tweede hoekpunt driehoek");
			Punt hoekPunt3 = askForPuntCoord("derde hoekpunt driehoek");
			Driehoek driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
			JOptionPane.showMessageDialog(null, "U heeft een correct driehoek aangemaakt: " + driehoek.toString());
			tekening.voegToe(driehoek);
			//TODO: add driehoek to game/speler?
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForDriehoek();
		}
	}
	
	private Punt askForPuntCoord(String puntToAsk) throws DomainException {
		try {
			int xcoord = askForInt("x coordinaat van een " + puntToAsk);
			int ycoord = askForInt("y coordinaat van een " + puntToAsk);
			Punt punt = new Punt(xcoord, ycoord);
			return punt;
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			return askForPuntCoord(puntToAsk);
		}
	}
	
	private int askForInt(String intToAsk) throws DomainException {
		String number = JOptionPane.showInputDialog("Vul " + intToAsk + " in.");
		try {
			if (number == null || number.trim().isEmpty()) {
				throw new DomainException("Vul in!");
			}
			//Test if digit with regular expression:
			// -?     --> negative sign, could have none or one
			// \\d+   --> one or more digits
			if (!number.matches("^-?\\d+$")) {
				throw new DomainException("Geef een nummer.");
			}
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			return askForInt(intToAsk);
		}
		return Integer.parseInt(number);
	}

}