package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PuntTest.class, SpelerTest.class, CirkelTest.class,
				DriehoekTest.class, RechthoekTest.class, LijnStukTest.class,
				OmhullendeTest.class, TekeningTest.class, WoordenLijstTest.class,
				HangManTest.class, HintLetterTest.class, HintWoordTest.class,
				TekeningHangManTest.class})
public class AllTests {

}
