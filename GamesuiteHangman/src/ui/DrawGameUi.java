package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;

public class DrawGameUi {
	
	private Speler speler;
	private Tekening tekening;

	public DrawGameUi(Speler speler) throws Exception {
		super();
		this.speler = speler;
		tekening = new Tekening("tekening1");
	}
	
	public void showMenu() throws Exception {
		Object[] shapes = {"Lijnstuk","Cirkel","Rechthoek","Driehoek"};
		Object keuze = JOptionPane.showInputDialog(null,"Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		if (keuze != null) {
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
			GameHoofdScherm view = new GameHoofdScherm("© " +speler.getNaam() + " zijn/haar tekening", tekening);
			view.setVisible(true);
			view.teken();
			showMenu();
		} else {
			Launcher.startPlaying(speler);
		}
	} 
	
	private void askForLijnstuk() throws Exception {
		try {
			Punt beginpunt = askForPuntCoord("beginpunt lijnstuk");
			Punt eindpunt = askForPuntCoord("eindpunt lijnstuk");
			if (beginpunt==null || eindpunt==null) {
				showMenu();
			}
			LijnStuk lijnstuk = new LijnStuk(beginpunt,eindpunt);
			JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk aangemaakt: " + lijnstuk.toString());
			tekening.voegToe(lijnstuk);
			return;
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			askForLijnstuk();
		}
	}
	
	private void askForCirkel() throws Exception {
		try {
			Punt middelpunt = askForPuntCoord("middelpunt cirkel");
			int straal = askForInt("straal cirkel");
			if (middelpunt==null) {
				showMenu();
			}
			Cirkel cirkel = new Cirkel(middelpunt, straal);
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel.toString());
			tekening.voegToe(cirkel);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			askForCirkel();
		}
	}
	
	private void askForRechthoek() throws Exception {
		try {
			Punt linkerBovenHoek = askForPuntCoord("linkerbovenhoek");
			if (linkerBovenHoek == null) {
				showMenu();
			}
			int breedte = askForInt("breedte van de rechthoek");
			int hoogte = askForInt("hoogte van de rechthoek");
			Rechthoek rechthoek = new Rechthoek(linkerBovenHoek, breedte, hoogte);
			JOptionPane.showMessageDialog(null, "U heeft een correct rechthoek aangemaakt: " + rechthoek.toString());
			tekening.voegToe(rechthoek);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForRechthoek();
		}
	}
	
	private void askForDriehoek() throws Exception {
		try {
			Punt hoekPunt1 = askForPuntCoord("eerste hoekpunt driehoek");
			Punt hoekPunt2 = askForPuntCoord("tweede hoekpunt driehoek");
			Punt hoekPunt3 = askForPuntCoord("derde hoekpunt driehoek");
			Driehoek driehoek = new Driehoek(hoekPunt1, hoekPunt2, hoekPunt3);
			JOptionPane.showMessageDialog(null, "U heeft een correct driehoek aangemaakt: " + driehoek.toString());
			tekening.voegToe(driehoek);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
			askForDriehoek();
		}
	}
	
	private Punt askForPuntCoord(String puntToAsk) throws Exception {
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
	
	private int askForInt(String intToAsk) throws Exception {
		String number = JOptionPane.showInputDialog("Vul " + intToAsk + " in.");
		try {
			if (number == null) {
				showMenu();
			}
			if (number.trim().isEmpty()) {
				throw new DomainException("Vul in!");
			}
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
