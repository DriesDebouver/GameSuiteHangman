package domain;

public class Punt {

	private int x;
	private int y;
	
	public Punt(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object object) {
		//gegeven UML wilt object object, so casting
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
		System.out.println(returnString);
		return returnString;
	}

}
