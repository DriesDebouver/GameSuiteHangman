package domain;

public class Driehoek extends Vorm {
	
	private Punt hoekpunten[] = new Punt[3];
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) throws DomainException {
		super();
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}
	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) throws DomainException {
		if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
			throw new DomainException("hoekpunt mag niet null zijn.");
		}
		hoekpunten[0] = hoekPunt1;
		hoekpunten[1] = hoekPunt2;
		hoekpunten[2] = hoekPunt3;
		if ((hoekPunt2.getX() - hoekPunt1.getX())*(hoekPunt3.getY()-hoekPunt1.getY()) == (hoekPunt3.getX()-hoekPunt1.getX())*(hoekPunt2.getY()-hoekPunt1.getY())) {
			throw new DomainException("Hoekpunten liggen op 1 lijn.");
		}
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
				if (!hoekpuntenContains(punt)) {
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
		System.out.println(stringDriehoek);
		return stringDriehoek;
	}
	
	private boolean hoekpuntenContains(Punt punt) {
		for (Punt punt2: this.getHoekpunten()) {
			if(punt2.equals(punt)) {
				return true;
			}
		}
		return false;
	}

}
