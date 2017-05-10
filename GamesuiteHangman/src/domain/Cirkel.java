package domain;
import domain.*;

public class Cirkel extends Vorm{

	private int radius;
	private Punt middelPunt;
	
	public Cirkel(Punt middelPunt, int radius) throws DomainException{
		this.setRadius(radius);
		this.setMiddelPunt(middelPunt);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws DomainException {
		if(radius <= 0){throw new DomainException("Radius moet positief zijn");}
		this.radius = radius;
	}

	public Punt getMiddelPunt()throws Exception {
		if(middelPunt == null){throw new DomainException("geen deftig middelpunt");}
		return middelPunt;
	}

	public void setMiddelPunt(Punt middelPunt) throws DomainException {
		if(middelPunt == null){
			throw new DomainException("Geen geldig middelpunt voor een cirkel");
		}
		this.middelPunt = middelPunt;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "middelpunt: " + this.middelPunt.toString() + "- straal:" + this.getRadius();
	}
	@Override
	public boolean equals(Object obj){
		// TODO Auto-generated method stub
		if(obj == null){return false;}
		Cirkel cirkel = (Cirkel)obj;
		if(this.radius == cirkel.radius && this.middelPunt == cirkel.middelPunt){
			return true;
		}
		return false;
	}
	}
