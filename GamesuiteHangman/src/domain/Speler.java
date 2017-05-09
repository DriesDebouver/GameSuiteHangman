package domain;

public class Speler {

	private String naam;
	private int score;
	
	public Speler(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Naam is leeg!");
		}
		this.naam = naam;
	}
	
	public String getNaam() {
		return naam;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score == 0) {
			throw new IllegalArgumentException("Score is nul!");
		}
		this.score = score;
	}
	
	public void addToScore(int score) {
		this.score = this.getScore() + score;
	}
	
	
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		Speler speler = (Speler) object;
		System.out.println(this.score);
		System.out.println(speler.getScore());
		if (this.naam.equals(speler.getNaam()) && this.score == speler.getScore()) {
			return true;
		}
		return false;
	}
	
	
	public String toString() {
		return "";
	}

}
