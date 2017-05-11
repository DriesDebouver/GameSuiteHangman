package domain;

public class HintLetter {
	
	private char hintLetter;
	private boolean isGeraden;

	public HintLetter(char hintLetter) {
		super();
		setHintLetter(hintLetter);
		setGeraden(false);
	}

	private void setGeraden(boolean isGeraden) {
		this.isGeraden = isGeraden;
	}

	private void setHintLetter(char hintLetter) {
		this.hintLetter = hintLetter;
	}

	public char getHintLetter() {
		return this.hintLetter;
	}

	public boolean isGeraden() {
		return this.isGeraden;
	}

	public boolean raad(char c) {
		if (Character.toLowerCase(c) == Character.toLowerCase(this.hintLetter) && !isGeraden) {
			this.setGeraden(true);
			this.setHintLetter(c);
			return true;
		}
		return false;
	}

	public Object toChar() {
		if (isGeraden) {
			return this.hintLetter;
		} else {
			return ('_');		
		}
	}
	
}
