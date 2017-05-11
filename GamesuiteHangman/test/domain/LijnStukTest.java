package domain;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LijnStukTest {
	private Punt punt1;
	private Punt zelfdeAlsPunt1;
	private Punt punt2;
	private Punt zelfdeAlsPunt2;

	@Before
	public void setUp() throws DomainException {
		punt1 = new Punt(10, 20);
		zelfdeAlsPunt1 = new Punt(10, 20);
		punt2 = new Punt(190, 30);
		zelfdeAlsPunt2 = new Punt(190, 30);
	}
	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() throws DomainException {
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

		assertEquals(punt1, lijnstuk.getStartPunt());
		assertEquals(punt2, lijnstuk.getEindPunt());
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null() throws DomainException  {
		new LijnStuk(null, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null() throws DomainException  {
		new LijnStuk(punt1, null);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn() throws DomainException{
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_begin_en_eindpunt_niet_gelijk_zijn() throws DomainException{
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		assertFalse(lijnStuk.getStartPunt().equals(lijnStuk.getEindPunt()));
	}
	
	@Test
	public void getOmhullende_moet_juiste_omhullende_teruggeven() throws DomainException{
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);
		Omhullende doelOmhullende = new Omhullende(punt1, punt2.getX()-punt1.getX(), punt2.getY()-punt1.getY());
		assertTrue(lijnstuk.getOmhullende().equals(doelOmhullende));
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_gelijk_is_aan_eindpunt() throws DomainException {
		punt1 = punt2;
		new LijnStuk(punt1, punt2);
	}
	
	@Test 
	public void equals_testen_door_zelfde_lijnstuk_te_vergelijken() throws DomainException {
		LijnStuk lijnstuk1 = new LijnStuk(punt1, punt2);
		LijnStuk lijnstuk2 = new LijnStuk(punt1, punt2);
		assertTrue(lijnstuk1.equals(lijnstuk2));
	}
	@Test 
	public void equals_testen_door_zelfde_lijnstuk_met_punten_omgedraaid_te_vergelijken() throws DomainException {
		LijnStuk lijnstuk1 = new LijnStuk(punt1, punt2);
		LijnStuk lijnstuk2 = new LijnStuk(punt2, punt1);
		assertTrue(lijnstuk1.equals(lijnstuk2));
	}
	@Test 
	public void equals_testen_door_verschillende_lijnstukken_te_vergelijken() throws DomainException {
		LijnStuk lijnstuk1 = new LijnStuk(punt1, punt2);
		LijnStuk lijnstuk2 = new LijnStuk(new Punt(5,6), new Punt(10, 10));
		assertFalse(lijnstuk1.equals(lijnstuk2));
	}
	@Test
	public void getString_moet_twee_eindpunten_string_bevatten() throws DomainException {
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);
		String lijnstukString = lijnstuk.toString();
		
		assertThat(lijnstukString, containsString(punt1.toString()));
		assertThat(lijnstukString, containsString(punt2.toString()));
	}
}
	
