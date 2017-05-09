package domain;

public class Rechthoek extends Vorm {
	
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;
	
	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) throws DomainException {
		super();
		this.setLinkerBovenhoek(linkerBovenhoek);
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
	}
	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}
	public void setLinkerBovenhoek(Punt linkerBovenhoek) throws DomainException {
		if (linkerBovenhoek == null) {
			throw new DomainException("linkerBovenhoek mag niet null zijn.");
		}
		this.linkerBovenhoek = linkerBovenhoek;
	}
	public int getBreedte() {
		return breedte;
	}
	public void setBreedte(int breedte) throws DomainException {
		if (breedte<=0) {
			throw new DomainException("Breedte moet groter dan 0 zijn.");
		}
		this.breedte = breedte;
	}
	public int getHoogte() {
		return hoogte;
	}
	public void setHoogte(int hoogte) throws DomainException {
		if (hoogte<=0) {
			throw new DomainException("Hoogte moet groter dan 0 zijn.");
		}
		this.hoogte = hoogte;
	}
	@Override
	public boolean equals(Object object) {
		if (object instanceof Rechthoek) {
			Rechthoek rechthoek = (Rechthoek) object;
			if ((rechthoek.getBreedte() == this.getBreedte()) &&
					(rechthoek.getHoogte() ==  this.getHoogte()) &&
					(rechthoek.getLinkerBovenhoek().equals(this.getLinkerBovenhoek()))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		String stringRechthoek = "Rechthoek: positie: " + this.getLinkerBovenhoek().toString() + " - breedte: " + this.getBreedte() + " - hoogte: " + this.getHoogte();
		return stringRechthoek;
	}

}
