package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {
	
	private int xCoordinaat;
	private int yCoordinaat;
	private Punt punt;
	private Cirkel cirkel;
	
	@Before
	public void setUp()throws Exception{
		xCoordinaat = 5;
		yCoordinaat = 10;
		punt = new Punt(xCoordinaat, yCoordinaat);
	}
	@Test
	public void cirkel_met_geldige_raidus_en_middelpunt()throws Exception{
		cirkel = new Cirkel(punt,5);
	}
	@Test
	public void gooit_exception_met_middelpunt_null()throws Exception{
		punt = null;
		cirkel = new Cirkel(punt,5);
	}

}
