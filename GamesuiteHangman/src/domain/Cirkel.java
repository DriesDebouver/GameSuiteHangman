package domain;
import java.awt.Graphics;

public class Cirkel extends Vorm{

	private int radius;
	private Punt middelPunt;
	private Omhullende omhullende;
	
	public Cirkel(Punt middelPunt, int radius) throws DomainException{
		this.setRadius(radius);
		this.setMiddelPunt(middelPunt);
		this.omhullende = this.getOmhullende();
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws DomainException {
		if(radius <= 0){throw new DomainException("Radius moet positief zijn!");}
		this.radius = radius;
	}

	public Punt getMiddelPunt()throws Exception {
		return middelPunt;
	}

	public void setMiddelPunt(Punt middelPunt) throws DomainException {
		if(middelPunt == null){
			throw new DomainException("Geen geldig middelpunt voor een cirkel!");
		}
		this.middelPunt = middelPunt;
	}
	
	@Override
	public String toString() {
		String returnString = "Cirkel: middelpunt: " + this.middelPunt.toString() + " - straal: " + this.getRadius();
		returnString += "\n" + omhullende;
		return returnString;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Cirkel)){return false;}
		Cirkel cirkel = (Cirkel)obj;
		if(this.radius == cirkel.radius && this.middelPunt == cirkel.middelPunt){
			return true;
		}
		return false;
	}

	@Override
	public Omhullende getOmhullende() throws DomainException {
		int diagonaal = this.getRadius() *2;
		Punt punt = new Punt(this.middelPunt.getX() - this.getRadius(), this.middelPunt.getY() - this.getRadius());
		omhullende = new Omhullende(punt, diagonaal, diagonaal);
		return new Omhullende(punt, diagonaal, diagonaal);
	}

	@Override
	public void teken(Graphics graphics) {
		if (this.isVisible()) {
			try {
				graphics.drawOval(this.getOmhullende().getPositieLinksBoven().getX(), this.getOmhullende().getPositieLinksBoven().getY(), radius*2, radius*2);
			} catch (DomainException e) {
				e.printStackTrace();
			}
		}
	}
}
