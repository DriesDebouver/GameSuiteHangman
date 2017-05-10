package domain;

public class LijnStuk extends Vorm {

	private Punt startPunt;
	private Punt eindPunt;
	
	public LijnStuk(Punt startPunt, Punt eindPunt) throws DomainException {
		super();
		if (startPunt == null) {
			throw new DomainException("Startpunt is null!");
		}
		this.startPunt = startPunt;
		if (eindPunt == null) {
			throw new DomainException("Eindpunt is null!");
		}
		this.eindPunt = eindPunt;
	}
	
	public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) throws DomainException {
		if (startPunt == eindPunt) {
			throw new DomainException("Startpunt is gelijk aan Eindpunt!");
		}
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
				if (lijnstuk.getStartPunt().equals(lijnstuk.getEindPunt())) {
					return true;
				}
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "";
	}
}