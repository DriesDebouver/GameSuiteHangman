package domain;

import java.awt.Graphics;

public class LijnStuk extends Vorm {

	private Punt startPunt;
	private Punt eindPunt;
	
	private Omhullende omhullende;
	
	public LijnStuk(Punt startPunt, Punt eindPunt) throws DomainException {
		if (startPunt == null) {
			throw new DomainException("Startpunt is null!");
		}
		setStartEnEindPunt(startPunt, eindPunt);
		if (eindPunt == null) {
			throw new DomainException("Eindpunt is null!");
		}
		setStartEnEindPunt(startPunt, eindPunt);
		
		this.eindPunt = eindPunt;
		omhullende = this.getOmhullende();
	}
	
	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) throws DomainException {
		if (startPunt.equals(eindPunt)) {
			throw new DomainException("Startpunt is gelijk aan Eindpunt!");
		}
		this.startPunt = startPunt;
		this.eindPunt = eindPunt;
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {
		return eindPunt;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof LijnStuk) {
			LijnStuk lijnstuk = (LijnStuk) object;
				if (this.getStartPunt().equals(lijnstuk.getEindPunt()) &&
						this.getStartPunt().equals(lijnstuk.getEindPunt())) {
					return true;
				}
				if (this.getStartPunt().equals(lijnstuk.getStartPunt()) &&
						this.getEindPunt().equals(lijnstuk.getEindPunt())) {
					return true;
				}
		} 
		return false;
	}
	
	public String toString() {
		String returnString = "Lijn: startpunt: " + this.getStartPunt() + " - eindpunt: " + this.getEindPunt();
		returnString = returnString + "\n" + omhullende.toString();
		return returnString;
	}

	@Override
	public Omhullende getOmhullende() throws DomainException {
		int omhulBreedte = Math.abs(this.getEindPunt().getX() - this.getStartPunt().getX());
		int omhulHoogte = Math.abs(this.getEindPunt().getY() - this.getStartPunt().getY());
		int omhulX = Math.min(this.getEindPunt().getX(), this.getStartPunt().getX());
		int omhulY = Math.min(this.getEindPunt().getY(), this.getStartPunt().getY());
		omhullende = new Omhullende(new Punt(omhulX,omhulY), omhulBreedte, omhulHoogte);
		return new Omhullende(new Punt(omhulX,omhulY), omhulBreedte, omhulHoogte);
	}

	@Override
	public void teken(Graphics graphics) {
		if (this.isVisible()) {
			graphics.drawLine(this.getStartPunt().getX(), this.getStartPunt().getY(), this.eindPunt.getX(), this.eindPunt.getY());
		}
	}

}
