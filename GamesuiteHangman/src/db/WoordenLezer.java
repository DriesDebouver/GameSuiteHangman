package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import domain.DomainException;
import domain.dbException;

public class WoordenLezer {
	private ArrayList<String> lijst = new ArrayList<>();
	public WoordenLezer(){
		
	}
	public void lees() throws Exception{
		try{
		Scanner s = new Scanner(new File("hangman.txt"));
		}catch(Exception e){
			throw new dbException(e.getMessage());
		}
		Scanner s = new Scanner(new File("hangman.txt"));
		String s1 = "";
		while(s.hasNext()){
			s1 = s.next();
			if(!lijst.contains(s1)){
			lijst.add(s1);
			}
		}
		s.close();
	}
	public ArrayList<String> getdb(){
		return this.lijst;
	}
}
