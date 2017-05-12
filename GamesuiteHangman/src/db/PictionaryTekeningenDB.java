package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;

//Singleton DB
public class PictionaryTekeningenDB {

	private static volatile PictionaryTekeningenDB instance = null;
	private static HashMap<String, Tekening> tekeningen =  new HashMap<String, Tekening>();
	
	
	public static PictionaryTekeningenDB getDB() throws DomainException {
		if (instance == null) {
			synchronized(PictionaryTekeningenDB.class) {
				if (instance == null) {
					instance = new PictionaryTekeningenDB();
					addSomeTekeningen();
				}
			}
		}
		return instance;
	}
	
	private static void addSomeTekeningen() throws DomainException {
		String woordTekening1 = "Circle";
		Tekening tekening1 = new Tekening(woordTekening1);
		tekening1.voegToe(new Cirkel(new Punt(200, 200), 50));
		tekeningen.put(woordTekening1, tekening1);
		//Some starter values in DB
		String woordTekening2 = "Square";
		Tekening tekening2 = new Tekening(woordTekening2);
		tekening2.voegToe(new Rechthoek(new Punt(200, 200), 100, 100));
		tekeningen.put(woordTekening2, tekening2);
		String woordTekening3 = "Denneboom";
		Tekening tekening3 = new Tekening(woordTekening3);
		tekening3.voegToe(new Driehoek(new Punt(200, 20), new Punt(100, 300), new Punt(300,300)));
		tekening3.voegToe(new LijnStuk(new Punt(200,300), new Punt(200, 370)));
		tekeningen.put(woordTekening3, tekening3);
	}
	
	public void addTekening(Tekening tek) {
		tekeningen.put(tek.getNaam(),tek);
	}
	
	public void addTekening(String tekWoord, Tekening tek) {
		tekeningen.put(tekWoord,tek);
	}
	
	public Tekening getTekening(String tekWoord) {
		return tekeningen.get(tekWoord);
	}
	
	public Tekening getRandomTekening() {
		List<String> keysAsArray = new ArrayList<String>(tekeningen.keySet());
		Random r = new Random();
		return tekeningen.get(keysAsArray.get(r.nextInt((keysAsArray.size()))));
	}
	
	public HashMap<String, Tekening> getTekenings() {
		return tekeningen;
	}
}
