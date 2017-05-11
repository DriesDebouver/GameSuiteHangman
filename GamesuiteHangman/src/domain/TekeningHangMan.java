package domain;

import java.util.ArrayList;
import java.util.List;

public class TekeningHangMan {
	private String naam;
	private ArrayList<Vorm> lijst = new ArrayList<Vorm>();
	
	public TekeningHangMan() throws DomainException{
		afbeeldingHangMan();
	}
	public void afbeeldingHangMan() throws DomainException{
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));// altijd zichtbaar
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);//…
		Vorm neus = new Cirkel(new Punt(280,128), 2);
		Vorm mond = new LijnStuk(new Punt(270,138),new Punt(290,138));
		Vorm lijf = new LijnStuk(new Punt(280,150),new Punt(280,250));
		Vorm beenLinks = new LijnStuk(new Punt(280,250),new Punt(240,310));
		Vorm beenRechts = new LijnStuk(new Punt(280,250),new Punt(320,310));
		Vorm voetLinks = new Cirkel(new Punt(240,310), 5);
		Vorm voetRechts = new Cirkel(new Punt(320,310), 5);
		Vorm armLinks = new LijnStuk(new Punt(280,200),new Punt(230,170));
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);

		voegToe(galgBodem);
		voegToe(galgStaaf);
		voegToe(hangbar);
		voegToe(koord);
		voegToe(hoofd);
		voegToe(oogLinks);
		voegToe(oogRechts);
		voegToe(neus);
		voegToe(mond);
		voegToe(lijf);
		voegToe(beenLinks);
		voegToe(beenRechts);
		voegToe(armLinks);
		voegToe(armRechts);
		voegToe(handLinks);
		voegToe(handRechts);	
		
	}
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) throws DomainException {
		if(naam == null || naam.trim().isEmpty()){throw new DomainException("Geen geldige naam");}
		this.naam = naam;
	}

	public List<Vorm> getLijst() {
		return lijst;
	}

	public void voegToe(Vorm vorm) throws DomainException{
		if(vorm == null){throw new DomainException("Geen geldige vorm");}
		lijst.add(vorm);
	}
	public void verwijder(Vorm vorm)throws DomainException{
		if(vorm == null){throw new DomainException("Geen geldige vorm");}
		for(Vorm vormThis: lijst){
			if(vormThis.equals(vorm)){
				lijst.remove(vormThis);
				break;
				
			}
		}
	}
	
}
