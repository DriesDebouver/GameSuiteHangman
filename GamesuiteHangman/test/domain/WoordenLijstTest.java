package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import db.WoordenLezer;

public class WoordenLijstTest {
	
	private WoordenLijst woordenlijstLeeg;
	private WoordenLijst woordenlijstMetEenGeldigWoord;
	private WoordenLijst woordenlijstMetGeldigeWoorden;
	private ArrayList<String> geldigeWoorden;

	@Before
	public void setUp() throws Exception {
		geldigeWoorden = new ArrayList<String>();
		geldigeWoorden.add("test");
		geldigeWoorden.add("game");
		geldigeWoorden.add("hangman");
		
		woordenlijstLeeg = new WoordenLijst();
		
		woordenlijstMetEenGeldigWoord = new WoordenLijst();
		woordenlijstMetEenGeldigWoord.voegToe(geldigeWoorden.get(0));
		
		woordenlijstMetGeldigeWoorden = new WoordenLijst();
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(0));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(1));
		woordenlijstMetGeldigeWoorden.voegToe(geldigeWoorden.get(2));
		
	}

	@Test
	public void WoordenLijst_moet_een_Woordenlijst_maken_zonder_woorden() throws Exception {
		WoordenLijst woordenlijstLeeg = new WoordenLijst();
		assertEquals(0,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test
	public void voegToe_moet_een_woord_toevoegen() throws DomainException {
		woordenlijstLeeg.voegToe(geldigeWoorden.get(0));
		
		assertEquals(1,woordenlijstLeeg.getAantalWoorden());
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_null() throws DomainException {
		woordenlijstLeeg.voegToe(null);
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_leeg() throws DomainException {
		woordenlijstLeeg.voegToe("");
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_gegeven_woord_reeds_in_lijst() throws DomainException {
		String woordAlInLijst = geldigeWoorden.get(2);

		woordenlijstMetGeldigeWoorden.voegToe(woordAlInLijst);
	}
	@Test
	public void random_woord_krijgen() throws Exception{
		WoordenLijst wl1 = new WoordenLijst();
		wl1.voegToe("muis");
		assertTrue("muis" == wl1.getRandomWoord());
	}
	@Test
	public void moet_null_terugkrijgen() throws Exception{
		WoordenLijst wl1 = new WoordenLijst();
		assertTrue(null == wl1.getRandomWoord());
	}
	@Test
	public void iets() throws Exception{
		WoordenLezer db = new WoordenLezer();
		db.lees();
	}


}