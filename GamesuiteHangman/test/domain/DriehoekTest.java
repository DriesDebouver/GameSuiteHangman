package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DriehoekTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt verschillendVanPunt1 = new Punt(15, 20);
	private Punt punt2 = new Punt(20, 40);
	private Punt zelfdeAlsPunt2 = new Punt(20, 40);
	private Punt verschillendVanPunt2 = new Punt(40, 20);
	private Punt punt3 = new Punt(190, 30);
	private Punt zelfdeAlsPunt3 = new Punt(190, 30);
	private Punt verschillendVanPunt3 = new Punt(120, 100);

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

	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_hoekpunten_op_zelfde_X_lijn_liggen() throws DomainException  {
		Punt puntZelfdeXLijn = new Punt(punt1.getX(),punt1.getY()+1);
		Punt puntZelfdeXLijn2 = new Punt(punt1.getX(),punt1.getY()+2);
		new Driehoek(punt1, puntZelfdeXLijn, puntZelfdeXLijn2);
	}	

	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_hoekpunten_op_zelfde_Y_lijn_liggen() throws DomainException  {
		Punt puntZelfdeYLijn = new Punt(punt1.getX()+1,punt1.getY());
		Punt puntZelfdeYLijn2 = new Punt(punt1.getX()+2,punt1.getY());
		new Driehoek(punt1, puntZelfdeYLijn, puntZelfdeYLijn2);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_zelfde_punten_uit_volgorde_zijn() throws DomainException{
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek drieHoek2 = new Driehoek(punt3, punt2, punt1);
		System.out.println(drieHoek.toString());
		System.out.println(drieHoek2.toString());
		assertTrue(drieHoek.equals(drieHoek2));
	}	
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_twee_eerste_hoekpunten_hetzelfde_zijn() throws DomainException  {
		new Driehoek(punt1, punt1, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_twee_laatste_hoekpunten_hetzelfde_zijn() throws DomainException  {
		new Driehoek(punt1, punt2, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_alle_drie_hoekpunten_hetzelfde_zijn() throws DomainException  {
		new Driehoek(punt3, punt3, punt3);
	}

}
