package domain;
import domain.*;

<<<<<<< .merge_file_a10584
public class Cirkel extends Vorm{
=======
public class Cirkel extends Vorm {
>>>>>>> .merge_file_a14148
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

	public Punt getMiddelPunt() {
		if(middelPunt == null){throw new D}
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
		boolean probeer = false;
		try{
			Cirkel cirkel = (Cirkel)obj;
		}catch(Exception e){
			return false;
		}
		Cirkel cirkel = (Cirkel)obj;
		if(this.radius == cirkel.radius && this.middelPunt == cirkel.middelPunt){
			return true;
		}
		return false;
	}
	}
