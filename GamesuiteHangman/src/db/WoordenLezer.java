package db;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {
	private ArrayList<String> lijst = new ArrayList<>();
	public WoordenLezer(){
		
	}
	public void lees() throws Exception{
		Scanner s;
		try{
			s = new Scanner(new File("hangman.txt"));
		}catch(Exception e){
			throw new DbException(e.getMessage());
		}
		String s1 = "";
		while(s.hasNextLine()){
			s1 = s.nextLine();
			
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
