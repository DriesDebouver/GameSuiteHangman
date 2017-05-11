package domain;

import java.util.ArrayList;

public class HintWoord {
	
	private String woord;
	private ArrayList<HintLetter> lettersWoord = new ArrayList<HintLetter>();
	private ArrayList<Character> reedsGeradenLetters = new ArrayList<Character>();
	private boolean isGeraden;

	public HintWoord(String woord) throws DomainException {
		setWoord(woord);
		makeLettersWoord(woord);
		isGeraden = false;
	}

	private void makeLettersWoord(String woord) {
		char[] charletters = woord.toCharArray();
		for (char letter: charletters) {
			lettersWoord.add(new HintLetter(letter));
		}
	}

	public String getWoord() {
		return woord;
	}

	private void setWoord(String woord) throws DomainException {
		if (woord ==  null || woord.trim().isEmpty()) {
			throw new DomainException("Woord mag niet null of leeg zijn!");
		}
		this.woord = woord;
	}

	public boolean isGeraden() {
		boolean allesGeraden = true;
		for (HintLetter letter: lettersWoord) {
			if(!letter.isGeraden()) {
				allesGeraden = false;
			}
		}
		return allesGeraden;
	}

	public boolean raad(char c) {
		c = Character.toLowerCase(c);
		if (reedsGeradenLetters.contains(c) || this.isGeraden) {
			return false;
		}
		else {
			reedsGeradenLetters.add(c);
			boolean zitInWoord = false;
			for (HintLetter letter: lettersWoord) {
				if (letter.raad(c)) {
					zitInWoord = true;
				}
			}
			return zitInWoord;
		}
	}
	
	public String toString() {
		String geradenWoord = "";
		for (HintLetter letter: lettersWoord) {
			geradenWoord += letter.toChar() + " ";
		}
		return geradenWoord.trim();
	}

}
