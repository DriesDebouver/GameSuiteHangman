package domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Before;
import org.junit.Test;

public class DriehoekTest{
	
	private Punt punt1;
	private Punt zelfdeAlsPunt1;
	private Punt verschillendVanPunt1;
	private Punt punt2;
	private Punt zelfdeAlsPunt2;
	private Punt verschillendVanPunt2;
	private Punt punt3;
	private Punt zelfdeAlsPunt3;
	private Punt verschillendVanPunt3;
	
	@Before
	public void setUp() throws DomainException {
		punt1 = new Punt(10, 20);
		zelfdeAlsPunt1 = new Punt(10, 20);
		verschillendVanPunt1 = new Punt(15, 20);
		punt2 = new Punt(20, 40);
		zelfdeAlsPunt2 = new Punt(20, 40);
		verschillendVanPunt2 = new Punt(40, 20);
		punt3 = new Punt(190, 30);
		zelfdeAlsPunt3 = new Punt(190, 30);
		verschillendVanPunt3 = new Punt(120, 100);
	}

	
	@Test
	public void Driehoek_moet_DrieHoek_aanmaken_met_gegeven_hoekpunten() throws DomainException {
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);

		assertEquals(punt1, drieHoek.getHoekPunt1());
		assertEquals(punt2, drieHoek.getHoekPunt2());
		assertEquals(punt3, drieHoek.getHoekPunt3());
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt1_null() throws DomainException  {
		new Driehoek(null, punt2, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt2_null() throws DomainException  {
		new Driehoek(punt1, null, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_hoekpunt3_null() throws DomainException  {
		new Driehoek(punt1, punt2, null);
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt1_verschillend() throws DomainException{
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(verschillendVanPunt1, zelfdeAlsPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt2_verschillend() throws DomainException{
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, verschillendVanPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt3_verschillend() throws DomainException{
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, zelfdeAlsPunt2, verschillendVanPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null() throws DomainException{
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		assertFalse(drieHoek.equals(null));
	}
	
	@Test
	public void getOmhullende_moet_juiste_omhullende_teruggeven() throws DomainException{
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Omhullende doelOmhullende = new Omhullende(punt1, 180, 20);
		assertTrue(drieHoek.getOmhullende().equals(doelOmhullende));
	}
	
	@Test
	public void getString_moet_hoekpunten_string_en_omhullende_string_bevatten() throws DomainException {
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		String drieHoekString = drieHoek.toString();
		
		assertThat(drieHoekString, containsString(punt1.toString()));
		assertThat(drieHoekString, containsString(punt2.toString()));
		assertThat(drieHoekString, containsString(punt3.toString()));
	
		assertThat(drieHoekString, containsString(drieHoek.getOmhullende().toString()));
	}

}
