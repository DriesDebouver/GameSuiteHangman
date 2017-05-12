package domain;

public class HangMan {
	
	private Speler speler;
	private WoordenLijst woordenlijst;
	private TekeningHangMan tekening;
	private boolean gameOver;
	private boolean gewonnen;
	private HintWoord hintWoord;
	private int aantalPogingen;
	private static final int AANTAL_KANSEN = 13; 
	
	public HangMan(Speler speler, WoordenLijst woordenlijst) throws Exception {
		this.setSpeler(speler);
		this.setWoordenlijst(woordenlijst);
		tekening = new TekeningHangMan();
		gameOver = false;
		gewonnen = false;
		hintWoord = new HintWoord(woordenlijst.getRandomWoord());
		System.out.println(hintWoord.getWoord());
		aantalPogingen = 0;
	}
	
	private void setSpeler(Speler speler) throws DomainException {
		if (speler == null) {
			throw new DomainException("Speler mag niet null zijn!");
		}
		this.speler = speler;
	}
	
	private void setWoordenlijst(WoordenLijst wl) throws DomainException {
		if(wl == null) {
			throw new DomainException("Woordenlijst mag niet null zijn!");
		}
		this.woordenlijst = wl;
	}

	public Speler getSpeler() {
		return speler;
	}
	
	public WoordenLijst getWoordenLijst() {
		return woordenlijst;
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

	public TekeningHangMan getTekening() {
		return tekening;
	}

	public String getWoord() {
		return hintWoord.getWoord();
	}

	//if game wins score++, gameover score-- until score 0
	public void raad(char letter) throws DomainException {
		if (aantalPogingen<=AANTAL_KANSEN) {
			if (!hintWoord.raad(letter)) {
				aantalPogingen++;
				tekening.zetVolgendeOnzichtbaar();
			}
		} else {
			gameOver = true;
		}
		if(hintWoord.isGeraden()) {
			gewonnen = true;
			speler.addToScore(1);
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
