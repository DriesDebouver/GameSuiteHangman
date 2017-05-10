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
		hoekpunten[1] = hoekPunt1;
		hoekpunten[2] = hoekPunt2;
		hoekpunten[3] = hoekPunt3;
	}
	public Punt[] getHoekpunten() {
		return hoekpunten;
	}
	public Punt getHoekPunt1() {
		return hoekpunten[1];
	}
	public Punt getHoekPunt2() {
		return hoekpunten[2];
	}
	public Punt getHoekPunt3() {
		return hoekpunten[3];
	}
	
	@Override
	public boolean equals(Object object) {
		if (object instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) object;
			boolean allFound = false;
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
		String stringDriehoek = "Driehoek: hoekpunt1: " + hoekpunten[1].toString() + " - hoekpunt2: " + hoekpunten[2].toString() + " - hoekpunt3: " + hoekpunten[3].toString();
		System.out.println(stringDriehoek);
		return stringDriehoek;
	}

}