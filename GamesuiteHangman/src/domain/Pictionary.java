package domain;

import db.PictionaryTekeningenDB;

public class Pictionary {
	
	private Speler speler;
	private boolean gameOver;
	private boolean gewonnen;
	private Tekening tekening;
	private HintWoord hintWoord;
	private int aantalPogingen;
	public static final int AANTAL_KANSEN = 10; 
	
	public int getAantalPogingen() {
		return aantalPogingen;
	}

	public Pictionary(Speler speler) throws Exception {
		this.setSpeler(speler);
		
		PictionaryTekeningenDB tekDB = PictionaryTekeningenDB.getDB();
		tekening = tekDB.getRandomTekening();
		gameOver = false;
		gewonnen = false;
		hintWoord = new HintWoord(tekening.getNaam());
		aantalPogingen = 0;
	}
	
	private void setSpeler(Speler speler) throws DomainException {
		if (speler == null) {
			throw new DomainException("Speler mag niet null zijn!");
		}
		this.speler = speler;
	}

	public Speler getSpeler() {
		return speler;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean isGewonnen() {
		return gewonnen;
	}

	public String getHint() {
		return hintWoord.toString();
	}

	public String getWoord() {
		return hintWoord.getWoord();
	}

	public Tekening getTekening() {
		return tekening;
	}

	//if game wins score++, gameover score-- until score 0
	public void raad(String woord) throws DomainException {
		if (aantalPogingen<=AANTAL_KANSEN) {
			if (hintWoord.getWoord().toLowerCase().equals(woord.toLowerCase())) {
				gewonnen = true;
				speler.addToScore(1);
			}
			aantalPogingen++;
		} else {
			gameOver = true;
		}
		if(gameOver) {
			try {
				speler.addToScore(-1);
			} catch (Exception e) {
				speler.setScore(0);
			}
		}
	}

}
