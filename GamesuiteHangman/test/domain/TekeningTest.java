package domain;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TekeningTest {
	private Vorm gebouw;
	private Vorm dak;
	private Vorm deur;
	private Vorm raam;
	private Vorm deurknop;
	private Vorm raambalk1;
	private Vorm raambalk2;
	private Vorm schouwNietInTekening;
	
	@Before
	public void setUp() throws Exception {
		gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
		dak = new Driehoek(new Punt(100, 200), new Punt(300, 200), new Punt(200, 100));
		deur = new Rechthoek(new Punt(130, 280), 50,100);
		raam = new Rechthoek(new Punt(210, 220), 80, 60);
		deurknop = new Cirkel(new Punt(170, 320), 2);
		raambalk1 = new LijnStuk(new Punt(210, 250), new Punt(290, 250));
		raambalk2 = new LijnStuk(new Punt(250, 220), new Punt(250, 280));
		schouwNietInTekening = new Rechthoek(new Punt(150, 150), 20,40);
	}

	@Test
	public void Tekening_moet_een_tekening_aanmaken_met_een_geldige_naam_en_0_vormen()throws Exception{
		Tekening huis = new Tekening("huis");
		assertEquals("huis", huis.getNaam());
		assertEquals(0, huis.getAantalVormen());
	}

	@Test (expected = DomainException.class)
	public void Tekening_moet_exception_gooien_als_naam_null()throws Exception {
		new Tekening(null);
	}

	@Test (expected = DomainException.class)
	public void Tekening_moet_exception_gooien_als_naam_leeg()throws Exception {
		new Tekening("");
	}
	
	@Test (expected = DomainException.class)
	public void voegToe_moet_exception_gooien_als_vorm_null()throws Exception {
		Tekening huis = createHuisZonderShouw();
		huis.voegToe(null);
	}
	
	@Test
	public void getVorm_moet_vorm_op_een_index_locatie_terugggeven()throws Exception{
		Tekening huis = new Tekening("huis");
		huis.voegToe(dak);

		assertEquals(huis.getAantalVormen(), 1);
		assertEquals(dak,huis.getVorm(0));
	}

	@Test 
	public void getAantalVormen_moet_aantal_vormen_teruggeven()throws Exception {
		Tekening huis = createHuisZonderShouw();
		assertEquals(7, huis.getAantalVormen());
	}

	@Test
	public void bevat_geeft_true_als_gegeven_vorm_deel_uitmaakt_van_de_tekening()throws Exception{
		Tekening huis = createHuisZonderShouw();
		assertTrue(huis.bevat(deur));
	}

	@Test
	public void bevat_geeft_false__als_gegeven_vorm_geen_deel_uitmaakt_van_de_tekening()throws Exception{
		Tekening huis = createHuisZonderShouw();
		assertFalse(huis.bevat(schouwNietInTekening));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null()throws Exception{
		Tekening huis = createHuisZonderShouw();
		assertFalse(huis.equals(null));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_verschillend_aantal_vormen()throws Exception{
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouw = createHuisMetSchouw();
		assertFalse(huis.equals(huisMetSchouw));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_ander_vorm()throws Exception{
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
		assertFalse(huis.equals(huisMetSchouwZonderDeur));
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_parameter_tekening_is_met_zelfde_aantal_vormen_andere_volgorde()throws Exception{
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouwZonderDeur = createHuisMetSchouwZonderDeur();
		huisMetSchouwZonderDeur.verwijder(schouwNietInTekening);
		huisMetSchouwZonderDeur.voegToe(deur);
		assertTrue(huis.equals(huisMetSchouwZonderDeur));
	}
	
	@Test
	public void equals_moet_true_teruggeven_alsparameter_tekening_is_met_zelfde_aantal_vormen_zelfde_volgorde()throws Exception{
		Tekening huis = createHuisZonderShouw();
		Tekening huisMetSchouw = createHuisMetSchouw();
		huisMetSchouw.verwijder(schouwNietInTekening);
		assertTrue(huis.equals(huisMetSchouw));
	}
	
	@Test
	public void toString_moet_strings_van_alle_vormen_in_tekening_aantalvormen_en_naam_bevatten()throws Exception{
		Tekening huis = createHuisZonderShouw();
		String huisString = huis.toString();
		
		for(Vorm vorm:  huis.gettekening()) {
			assertThat(huisString, containsString(vorm.toString()));
		}

		assertThat(huisString, containsString(Integer.toString(huis.getAantalVormen())));
		assertThat(huisString, containsString(huis.getNaam()));
	}


	public Tekening createHuisMetSchouw()throws Exception {
		Tekening huisMetSchouw = new Tekening("huisMetSchouw");
		huisMetSchouw.voegToe(gebouw);
		huisMetSchouw.voegToe(dak);
		huisMetSchouw.voegToe(deur);
		huisMetSchouw.voegToe(raam);
		huisMetSchouw.voegToe(deurknop);
		huisMetSchouw.voegToe(raambalk1);
		huisMetSchouw.voegToe(raambalk2);
		huisMetSchouw.voegToe(schouwNietInTekening);
		return huisMetSchouw;
	}

	public Tekening createHuisZonderShouw()throws Exception {
		Tekening huis = new Tekening("huis");
		huis.voegToe(gebouw);
		huis.voegToe(dak);
		huis.voegToe(deur);
		huis.voegToe(raam);
		huis.voegToe(deurknop);
		huis.voegToe(raambalk1);
		huis.voegToe(raambalk2);
		return huis;
	}

	public Tekening createHuisMetSchouwZonderDeur()throws Exception {
		Tekening huisMetSchouwZonderDeur = new Tekening("huisMetSchouwZonderDeur");
		huisMetSchouwZonderDeur.voegToe(gebouw);
		huisMetSchouwZonderDeur.voegToe(dak);
		huisMetSchouwZonderDeur.voegToe(raam);
		huisMetSchouwZonderDeur.voegToe(deurknop);
		huisMetSchouwZonderDeur.voegToe(raambalk1);
		huisMetSchouwZonderDeur.voegToe(raambalk2);
		huisMetSchouwZonderDeur.voegToe(schouwNietInTekening);
		return huisMetSchouwZonderDeur;
	}

}
