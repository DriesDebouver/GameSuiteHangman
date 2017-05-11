package domain;

import java.awt.Graphics;

public class Driehoek extends Vorm {
	
	private Punt hoekpunten[] = new Punt[3];
	private Omhullende omhullende;
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) throws DomainException {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
		omhullende = this.getOmhullende();
	}
	
	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) throws DomainException {
		if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
			throw new DomainException("hoekpunt mag niet null zijn!");
		}
		hoekpunten[0] = hoekPunt1;
		hoekpunten[1] = hoekPunt2;
		hoekpunten[2] = hoekPunt3;
	}
	
	public Punt[] getHoekpunten() {
		return hoekpunten;
	}
	
	public Punt getHoekPunt1() {
		return hoekpunten[0];
	}
	
	public Punt getHoekPunt2() {
		return hoekpunten[1];
	}
	
	public Punt getHoekPunt3() {
		return hoekpunten[2];
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) object;
			for (Punt punt: driehoek.getHoekpunten()) {
				boolean thisfound = false;
				for (Punt punt2: this.getHoekpunten()) {
					if (punt.equals(punt2)) {
						thisfound = true;
					}
				}
				if (!thisfound) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String stringDriehoek = "Driehoek: hoekpunt1: " + hoekpunten[0].toString() + " - hoekpunt2: " + hoekpunten[1].toString() + " - hoekpunt3: " + hoekpunten[2].toString();
		stringDriehoek = stringDriehoek + "\n" + omhullende.toString();
		return stringDriehoek;
	}
	
	@Override
	public Omhullende getOmhullende() throws DomainException {
		int maxX = Math.max(Math.max(this.getHoekPunt1().getX(), this.getHoekPunt2().getX()), this.getHoekPunt3().getX());
		int maxY = Math.max(Math.max(this.getHoekPunt1().getY(), this.getHoekPunt2().getY()), this.getHoekPunt3().getY());
		int minX = Math.min(Math.min(this.getHoekPunt1().getX(), this.getHoekPunt2().getX()), this.getHoekPunt3().getX());
		int minY = Math.min(Math.min(this.getHoekPunt1().getY(), this.getHoekPunt2().getY()), this.getHoekPunt3().getY());
		Punt omhulHoek = new Punt(minX,minY);
		int omhulBreedte = Math.abs(maxX - minX);
		int omhulHoogte = Math.abs(maxY - minY);
		omhullende = new Omhullende(omhulHoek, omhulBreedte, omhulHoogte);
		return new Omhullende(omhulHoek, omhulBreedte, omhulHoogte);
	}
	
	@Override
	public void teken(Graphics graphics) {	
		if (this.isVisible()) {
			int[]  xPunten = {this.hoekpunten[0].getX(), this.hoekpunten[1].getX(), this.hoekpunten[2].getX()};
			int[]  yPunten = {this.hoekpunten[0].getY(), this.hoekpunten[1].getY(), this.hoekpunten[2].getY()};
			graphics.drawPolygon(xPunten, yPunten, 3);
		}
	}

}
