package domain;

import domain.DomainException;

public class Speler {

	private String naam;
	private int score;
	
	public Speler(String naam) throws DomainException {
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

	void setScore(int score) {
		if (score < 0) {
			throw new IllegalArgumentException("Score moet positief zijn!");
		}
		this.score = score;
	}
	
	public void addToScore(int score) throws DomainException {
		if ((this.score + score) <= 0) {
			throw new DomainException("Score is negatief!");
		}
		
		setScore(this.getScore() + score);
	}
	
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		Speler speler = (Speler) object;
		if (this.naam.equals(speler.getNaam()) && this.score == speler.getScore()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Naam: " + this.getNaam() + "\nScore: " + this.getScore();
	}

}
