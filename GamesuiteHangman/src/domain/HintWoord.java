package domain;

import java.util.ArrayList;

public class HintWoord {
	
	private String woord;
	private ArrayList<HintLetter> lettersWoord = new ArrayList<HintLetter>();
	private ArrayList<Character> reedsGeradenLetters = new ArrayList<Character>();
	private boolean isGeraden;

	public HintWoord(String woord) throws DomainException {
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

	public boolean raad(char c) {
		boolean allesGeraden = true;
		if (reedsGeradenLetters.contains(c)) {
			return false;
		} else {
			for (HintLetter letter: lettersWoord) {
				letter.raad(c);
				if (!letter.isGeraden()) {
					allesGeraden = false;
				}
			}
			if (allesGeraden) {
				this.isGeraden = false;
			}
			
		}
		return true;
	}
	
	public String toString() {
		String geradenWoord = "";
		for (HintLetter letter: lettersWoord) {
			geradenWoord += letter.toChar() + " ";
		}
		return geradenWoord.trim();
	}

}
