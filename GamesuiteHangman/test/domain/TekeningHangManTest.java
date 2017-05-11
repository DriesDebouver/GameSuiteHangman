package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TekeningHangManTest {
	public TekeningHangMan thm;
	@Before
	public void setUp() throws Exception{
		thm = new TekeningHangMan();
		thm.reset();
	}

	@Test
	public void maak_afbeelding_hangman() throws Exception{
		assertTrue(thm.getLijst().getAantalVormen() == 18);
		thm.reset();
	}
	@Test
	public void maak_afbeelding_test_onzichtbaar(){
		int i = thm.getAantalOnzichtbaar();
		assertEquals(i, 14);
		thm.reset();
	}
	@Test
	public void test_zet_volgende_onzichtbaar() throws DomainException{
		int i =  18-thm.getAantalOnzichtbaar();
		thm.zetVolgendeOnzichtbaar();
		int i2 = 18-thm.getAantalOnzichtbaar();
		i++;
		assertEquals(i,i2);
		thm.reset();
	}
	@Test (expected = DomainException.class)
	public void gooit_exception_zet_volgende_onzichtbaar() throws DomainException{
		int a = thm.getAantalOnzichtbaar() + 1;
		for(int i=0; i< a;i++){
			thm.zetVolgendeOnzichtbaar();
		}
		thm.reset();
		
	}
	@Test
	public void test_reset() throws DomainException{
		int i = thm.getAantalOnzichtbaar(); 
		thm.zetVolgendeOnzichtbaar(); 
		thm.zetVolgendeOnzichtbaar();
		thm.reset();
		int o = thm.getAantalOnzichtbaar();
		assertEquals(i, o);
	}
	@Test
	public void voegToe_voegt_succesvol_een_geldige_vorm_toe() throws DomainException{
		Vorm v = new Cirkel(new Punt(5,5), 846465);
		thm.voegToe(v);
		
		assertTrue(thm.getLijst().bevat(v));
	}
	@Test
	public void verwijder_verwijdert_succesvol_een_toegevoegde_vorm_toe() throws DomainException{
		Vorm v = new Cirkel(new Punt(5,5), 846465);
		thm.voegToe(v);
		thm.verwijder(v);
		assertFalse(thm.getLijst().bevat(v));
		
	}
	@Test (expected = DomainException.class)
	public void gooit_exception_voeg_toe() throws DomainException{
		thm.voegToe(null);
	}
	@Test (expected = DomainException.class)
	public void gooit_exception_verwijder() throws DomainException{
		thm.verwijder(null);
	}
	@Test (expected = DomainException.class)
	public void gooit_exception_vorm_niet_aanwezig() throws DomainException{
		Vorm v = new Cirkel(new Punt(5,5), 846465);
		thm.verwijder(v);
	}
}