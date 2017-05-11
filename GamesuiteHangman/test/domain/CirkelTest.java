package domain;

import static org.hamcrest.CoreMatchers.containsString;
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
	@Test (expected = DomainException.class)
	public void gooit_exception_met_middelpunt_null()throws Exception{
		punt = null;
		cirkel = new Cirkel(punt,5);
	}
	@Test (expected = DomainException.class)
	public void gooit_exception_cirkel_negatieva_straal() throws Exception{
		Punt p1 = new Punt(1, 1);
		new Cirkel(p1, -5);
	}
	@Test (expected = DomainException.class)
	public void gooit_exception_cirkel_0_straal() throws Exception{
		Punt p2 = new Punt(2,2);
		new Cirkel(p2,0);
	}
	@Test
	public void equals_gelijke_cirkels() throws Exception{
		Punt p3 = new Punt(1, 1);
		Cirkel c2 = new Cirkel(p3, 5);
		Cirkel c3 = new Cirkel(p3, 5);
		assertTrue(c2.equals(c3));
	}
	@Test
	public void equals_tweede_cirkel_null_false() throws Exception{
		Punt p4 = new Punt(1, 1);
		Cirkel c4 = new Cirkel(p4, 5);
		assertFalse(c4.equals(null));
	}
	@Test
	public void equals_ander_middelpunt_false() throws Exception{
		Punt p5 = new Punt(5, 1);
		Punt p6 = new Punt(1, 1);
		Cirkel c5 = new Cirkel(p5, 5);
		Cirkel c6 = new Cirkel(p6, 5);
		assertFalse(c5.equals(c6));
		
	}
	@Test
	public void equals_ander_straal_false() throws Exception{
		Punt p7 = new Punt(1, 1);
		Cirkel c7 = new Cirkel(p7, 5);
		Cirkel c8 = new Cirkel(p7, 8);
		assertFalse(c7.equals(c8));
	}
	@Test
	public void getOmhullende_moet_juiste_omhullende_teruggeven() throws DomainException{
		cirkel = new Cirkel(punt,5);
		Omhullende doelOmhullende = new Omhullende(new Punt(0, 5), 10, 10);
		assertTrue(cirkel.getOmhullende().equals(doelOmhullende));
	}
	@Test
	public void toString_moet_strings_van_middelpunt_radius_en_omhullende_bevatten()throws Exception{
		cirkel = new Cirkel(punt,5);
		String cirkelString = cirkel.toString();
		
		assertThat(cirkelString, containsString(cirkel.getMiddelPunt().toString()));
		assertThat(cirkelString, containsString(Integer.toString(cirkel.getRadius())));
		assertThat(cirkelString, containsString(cirkel.getOmhullende().toString()));
	}

}
