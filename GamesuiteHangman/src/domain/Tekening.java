package domain;

public class Tekening {

	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	
	
	public Tekening(String naam){ 
		super();
		this.naam = naam;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void voegToe(Vorm vorm){
		
	}
	
	public Vorm getVorm(int index){
		
	}
	
	public int getAantalVormen(){
	
	}
	
	public void verwijder(Vorm vorm){
		
	}
	
	public boolean bevat(Vorm vorm){
		
	}
	
	public String toString(){
		
	}
	
	public boolean equals(Object object){
		
	}
	
}
