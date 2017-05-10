package domain;

import java.util.ArrayList;

public class Tekening {

	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	private ArrayList<Vorm> Tekening = new ArrayList<Vorm>();
	
	public Tekening(String naam)throws Exception{ 
		super();
		this.setNaam(naam);
	}
	
	public ArrayList<Vorm> getTekening(){
		
		return Tekening;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void setNaam(String naam) throws Exception {
		if ( naam == null || naam.trim().isEmpty() ) 
		{
			throw new DomainException("Naam mag niet leeg zijn!");
		}
		this.naam = naam;
	}
	
	public void voegToe(Vorm vorm) throws Exception{
		if(vorm==null){
			throw new DomainException("Geen geldige vorm");
		}
		this.Tekening.add(vorm);
	}
	
	public Vorm getVorm(int index){
		return Tekening.get(index);
	}
	
	public int getAantalVormen(){
	return Tekening.size();
	}
	
	public void verwijder(Vorm vorm){
		for(Vorm v: Tekening){
			if(v == vorm){
				Tekening.remove(v);
			}
		}
	}
	
	public boolean bevat(Vorm vorm){
		return Tekening.contains(vorm);
	}
	
	public String toString(){
		String s = "Tekening met naam" + this.naam + "bestaat uit" + Tekening.size() + "vormen:\n";
		String t = "";
		for(Vorm v : Tekening){
			t = v.toString() + "\n";
		}
		return s + t;
	}
	
	public boolean equals(Object object){
		if(object == null){return false;}
		Tekening t1 = (Tekening)object;
		if(this.naam == t1.getNaam() && this.Tekening == t1.getTekening()){
			return true;
		}
		return false;
	}
	
}
