package domain;

import java.util.ArrayList;

class HintWoord {
	
	private String woord;
	private ArrayList<HintLetter> lettersWoord = new ArrayList<HintLetter>();
	private ArrayList<Character> reedsGeradenLetters = new ArrayList<Character>();
	private boolean isGeraden;

	HintWoord(String woord) throws DomainException {
		super();
		setWoord(woord);
		makeLettersWoord(woord);
		isGeraden = false;
	}

	private void makeLettersWoord(String woord) {
		char[] charletters = woord.toCharArray();
		System.out.println(charletters);
		for (char letter: charletters) {
			lettersWoord.add(new HintLetter(letter));
		}
	}

	String getWoord() {
		return woord;
	}

	private void setWoord(String woord) throws DomainException {
		if (woord ==  null) {
			throw new DomainException("Woord mag niet null zijn");
		}
		this.woord = woord;
	}

	boolean isGeraden() {
		// TODO Auto-generated method stub
		return false;
	}

	boolean raad(char c) {
		for (HintLetter letter: lettersWoord) {
			letter.raad(c);
			if (!letter.isGeraden()) {
				this.isGeraden = false;
			}
		}
		return false;
	}
	
	public String toString() {
		String geradenWoord = "";
		for (HintLetter letter: lettersWoord) {
			geradenWoord += letter.toChar() + " ";
		}
		return geradenWoord.trim();
	}

}
