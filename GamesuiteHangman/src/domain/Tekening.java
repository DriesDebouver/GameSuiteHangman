package domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Tekening implements Drawable {

	private String naam;
	private ArrayList<Vorm> tekening = new ArrayList<Vorm>();
	
	public Tekening (String naam) throws DomainException { 
		this.setNaam(naam);
	}
	
	public ArrayList<Vorm> gettekening() {
		return tekening;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void setNaam(String naam) throws DomainException {
		if ( naam == null || naam.trim().isEmpty() ) 
		{
			throw new DomainException("Naam tekening mag niet leeg zijn!");
		}
		this.naam = naam;
	}
	
	public void voegToe(Vorm vorm) throws DomainException {
		if( vorm==null){
			throw new DomainException("Vorm is null!");
		}
		this.tekening.add(vorm);
	}
	
	Vorm getVorm(int index){
		return tekening.get(index);
	}
	
	public int getAantalVormen(){
		return tekening.size();
	}
	
	public void verwijder(Vorm vorm){
		for(Vorm vormThis: this.gettekening()){
			if(vormThis.equals(vorm)){
				tekening.remove(vormThis);
				break;
				
			}
		}
	}
	
	public boolean bevat(Vorm vorm){
		return tekening.contains(vorm);
	}
	
	public void teken(Graphics graphics){
		for(Vorm tekening: tekening){
			tekening.teken(graphics);
		}
	}
	
	public String toString(){
		String s = "Tekening met naam " + this.naam + " bestaat uit " + tekening.size() + " vormen:\n";
		String t = "";
		for(Vorm v : tekening){
			t = t + v.toString() + "\n";
		}
		return s + t;
	}
	
	public boolean equals(Object object){
		if(object == null){
			return false;}
		Tekening t1 = (Tekening)object;
		if(this.getAantalVormen() != t1.getAantalVormen()){
			return false;}
		for(Vorm vorm: t1.gettekening()){
			if(!tekening.contains(vorm)){
				return false;
			}
		}
		return true;
	}
	
}
