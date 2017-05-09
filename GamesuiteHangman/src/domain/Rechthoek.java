package domain;

public class Rechthoek  extends Vorm {
	
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;
	
	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
		super();
		this.linkerBovenhoek = linkerBovenhoek;
		this.breedte = breedte;
		this.hoogte = hoogte;
	}
	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}
	public void setLinkerBovenhoek(Punt linkerBovenhoek) {
		this.linkerBovenhoek = linkerBovenhoek;
	}
	public int getBreedte() {
		return breedte;
	}
	public void setBreedte(int breedte) {
		this.breedte = breedte;
	}
	public int getHoogte() {
		return hoogte;
	}
	public void setHoogte(int hoogte) {
		this.hoogte = hoogte;
	}
	@Override
	public boolean equals() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
