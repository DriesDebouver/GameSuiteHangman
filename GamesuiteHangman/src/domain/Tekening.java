package domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Tekening implements Drawable{

	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	private ArrayList<Vorm> tekening = new ArrayList<Vorm>();
	
	public Tekening(String naam)throws Exception{ 
		super();
		this.setNaam(naam);
	}
	
	public ArrayList<Vorm> gettekening(){
		return tekening;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void setNaam(String naam) throws Exception {
		if ( naam == null || naam.trim().isEmpty() ) 
		{
			throw new DomainException("Naam tekening mag niet leeg zijn!");
		}
		this.naam = naam;
	}
	
	public void voegToe(Vorm vorm) throws DomainException {
		if(! (vorm instanceof Vorm) || vorm==null){
			throw new DomainException("Geen geldige vorm");
		}
		this.tekening.add(vorm);
	}
	
	public Vorm getVorm(int index){
		return tekening.get(index);
	}
	
	public int getAantalVormen(){
	return tekening.size();
	}
	
	public void verwijder(Vorm vorm){
		for(Vorm vormThis: this.gettekening()){
			if(vormThis.equals(vorm)){
				System.out.println(vorm + " verwijdert.");
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
			System.out.println("size this tek: " + tekening.size() + ", obj size: " + t1.getAantalVormen());
			return false;}
		for(Vorm vorm: t1.gettekening()){
			if(!tekening.contains(vorm)){
				return false;
			}
		}
		return true;
	}
	
}
