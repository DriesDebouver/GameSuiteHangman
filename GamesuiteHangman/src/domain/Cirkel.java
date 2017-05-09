import domain.DomainException;
import domain.*
public class Cirkel extends Vorm{
	private int radius
	private punt middelPunt;
	public Cirkel(int radius, punt middelpunt){
		
	}
	public void setRadius(int radius){
		if(radius <= 0){
			throw new DomainException("De radius mag niet kleiner of gelijk zijn aan nul");
		}
		this.radius = radius;
	}
	public int getRadius(){
		return this.radius;
	}
	public void setmiddelPunt(punt middelPunt){
		this.middelPunt = middelPunt;
	}
	public punt getMiddelPunt(){
		return this.middelPunt;
	}
}
