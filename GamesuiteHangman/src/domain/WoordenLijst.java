package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WoordenLijst {
	private List<String> woordenLijst = new ArrayList<String>();
	public WoordenLijst(){
		
	}
	public void voegToe(String s) throws DomainException{
		if(s == null || s.trim().isEmpty()){throw new DomainException("geen geldig woord");}
		if(woordenLijst.contains(s)){throw new DomainException("Woord staat er al in");}
		woordenLijst.add(s);
	}
	public int getAantalWoorden(){
		return woordenLijst.size();
	}
	public String getRandomWoord(){
		if(getAantalWoorden() == 0){return null;}
		Random rand = new Random();
		int  n = rand.nextInt(getAantalWoorden()) + 0;
		return woordenLijst.get(n);
	}
}
