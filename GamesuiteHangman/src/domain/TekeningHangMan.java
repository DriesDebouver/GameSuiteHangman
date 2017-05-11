package domain;

public class TekeningHangMan {
	
	private Tekening lijst;
	
	public TekeningHangMan() throws Exception{
		lijst = new Tekening("Hangman");
		afbeeldingHangMan();
	}
	
	public void afbeeldingHangMan() throws DomainException{
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
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

		lijst.voegToe(galgBodem);
		lijst.voegToe(galgStaaf);
		lijst.voegToe(hangbar);
		lijst.voegToe(koord);
		lijst.voegToe(hoofd);
		lijst.voegToe(oogLinks);
		lijst.voegToe(oogRechts);
		lijst.voegToe(neus);
		lijst.voegToe(mond);
		lijst.voegToe(lijf);
		lijst.voegToe(beenLinks);
		lijst.voegToe(beenRechts);
		lijst.voegToe(voetLinks);
		lijst.voegToe(voetRechts);
		lijst.voegToe(armLinks);
		lijst.voegToe(armRechts);
		lijst.voegToe(handLinks);
		lijst.voegToe(handRechts);	
		
		reset();
	}
	
	public void reset(){
		for(int i = 4;i< lijst.getAantalVormen();i++){
			lijst.gettekening().get(i).setVisible(false);
		}
	}
	
	public int getAantalOnzichtbaar(){
		int i = 0;
		for(Vorm v : this.getLijst().gettekening()){
			if(!v.isVisible()){i++;}
		}
		return i;
	}
	
	public void zetVolgendeOnzichtbaar() throws DomainException{
		for(Vorm v : this.getLijst().gettekening()){
			if(!v.isVisible()){
				v.setVisible(true);
				return;
			}
		}
		throw new DomainException("Alles is al zichtbaar!");
	}

	public Tekening getLijst() {
		return lijst;
	}

	public void voegToe(Vorm vorm) throws DomainException{
		if(vorm == null){throw new DomainException("Geen geldige vorm!");}
		lijst.voegToe(vorm);
	}
	
	public void verwijder(Vorm vorm)throws DomainException{
		if(!lijst.gettekening().contains(vorm)){throw new DomainException("Vorm zit er niet in!");}
		if(vorm == null){throw new DomainException("Geen geldige vorm!");}
		lijst.verwijder(vorm);
	}
	
}
