package domain;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RechthoekTest {

	private Punt linkerBovenhoek;
	private int breedte, hoogte;
	private Rechthoek rechthoek;

	@Before
	public void setUp() throws DomainException {
		linkerBovenhoek = new Punt(200, 200);
		breedte = 20;
		hoogte = 40;
		rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
	}

	@Test
	public void Rechthoek_moet_rechthoek_aanmaken_met_gegeven_linkerbovenhoek_breedte_en_hoogte() throws DomainException {
		Rechthoek rechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
		assertEquals(linkerBovenhoek, rechthoek.getLinkerBovenhoek());
		assertEquals(hoogte, rechthoek.getHoogte());
		assertEquals(breedte, rechthoek.getBreedte());
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_linkerbovenhoek_null() throws DomainException  {
		new Rechthoek(null, breedte, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_breedte_kleiner_dan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, -1, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_hoogte_kleiner_dan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, breedte, -1);
		
	}

	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_breedte_gelijk_aan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, 0, hoogte);
	}
	
	@Test (expected = DomainException.class)
	public void Rechthoek_Moet_exception_gooien_als_hoogte_gelijk_aan_dan_0() throws DomainException  {
		new Rechthoek(linkerBovenhoek, breedte, 0);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_linkerbovenhoek_breedte_hoogte_gelijk_zijn() throws DomainException{
		Rechthoek zelfdeRechthoek = new Rechthoek(linkerBovenhoek,breedte, hoogte);
		assertTrue(rechthoek.equals(zelfdeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_linkerbovenhoek_verschilt() throws DomainException{
		Punt andereLinkerBovenhoek = new Punt(100,100);
		Rechthoek verschillendeRechthoek = new Rechthoek(andereLinkerBovenhoek, breedte, hoogte);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_breedte_verschilt() throws DomainException{
		Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, breedte + 10, hoogte);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoogte_verschilt() throws DomainException{
		Rechthoek verschillendeRechthoek = new Rechthoek(linkerBovenhoek, breedte, hoogte + 10);
		assertFalse(rechthoek.equals(verschillendeRechthoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(rechthoek.equals(null));
	}
	
	@Test
	public void getOmhullende_moet_juiste_omhullende_teruggeven() throws DomainException{
		Omhullende doelOmhullende = new Omhullende(linkerBovenhoek, breedte, hoogte);
		assertTrue(rechthoek.getOmhullende().equals(doelOmhullende));
	}
	
	@Test
	public void toString_moet_strings_van_linkerbovenhoek_breedte_en_hoogte_bevatten()throws Exception{
		String rechthoekString = rechthoek.toString();
		
		assertThat(rechthoekString, containsString(rechthoek.getLinkerBovenhoek().toString()));
		assertThat(rechthoekString, containsString(Integer.toString(rechthoek.getBreedte())));
		assertThat(rechthoekString, containsString(Integer.toString(rechthoek.getHoogte())));
		assertThat(rechthoekString, containsString(rechthoek.getOmhullende().toString()));
	}
}
