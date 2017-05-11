package domain;

public class Punt {

	private int x;
	private int y;
	
	public Punt(int x, int y) throws DomainException {
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) throws DomainException {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) throws DomainException {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object object) {
		Punt punt;
		Boolean returnBoolean = false;
		if (object instanceof Punt) {
			punt = (Punt) object;
			if ((punt.getX() == this.getX()) && (punt.getY() == this.getY())) {
				returnBoolean = true;
			} else {
				returnBoolean = false;
			}
		} else {
			returnBoolean = false;
		}
		return returnBoolean;
	}
	
	@Override
	public String toString() {
		String returnString = "(" + this.getX() + ", " + this.getY() + ")";
		return returnString;
	}

}
