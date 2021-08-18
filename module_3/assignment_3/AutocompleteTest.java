import org.junit.Assert;
import org.junit.Test;


public class AutocompleteTest {

   @Test (expected = NullPointerException.class)
   public void testAutocompleteNullPointerException1() {
       Autocomplete autocompl = new Autocomplete(null);
   }

   @Test (expected = NullPointerException.class)
   public void testAutocompleteNullPointerException2() {
      Term[] terms = {new Term("the", 23135851162l),
                      new Term("of", 1315194277l),
                      new Term("and", 12997637966l),
                      new Term("to", 12136980858l),
                      new Term("a", 9081174698l),
                      new Term("in", 8469404971l),
                      new Term("for", 5933321709l),
                      new Term("is", 4705743816l),
                      new Term("on", 3750423199l),
                      new Term("that", 3400031103l)};
                      
       Autocomplete autocompl = new Autocomplete(terms);
       Term[] myMatches = autocompl.allMatches(null);
       
   }

   /** Tests for typical values of Term - Test 1 **/
   @Test public void testAutocompleteTypical1() {
      Term[] terms = {new Term("the", 23135851162l),
                      new Term("of", 1315194277l),
                      new Term("and", 12997637966l),
                      new Term("to", 12136980858l),
                      new Term("a", 9081174698l),
                      new Term("in", 8469404971l),
                      new Term("for", 5933321709l),
                      new Term("is", 4705743816l),
                      new Term("on", 3750423199l),
                      new Term("that", 3400031103l)};
                      
       Autocomplete autocompl = new Autocomplete(terms);
       Term[] myMatches = autocompl.allMatches("t");
       
       Assert.assertEquals("the" + "\t" + 23135851162l, myMatches[0].toString());
       Assert.assertEquals("to" + "\t" + 12136980858l, myMatches[1].toString());
       Assert.assertEquals("that" + "\t" + 3400031103l, myMatches[2].toString());
       
       Assert.assertEquals(3, myMatches.length);
   }
   
   /** Tests for typical values of Term - Test 1 **/
   @Test public void testAutocompleteTypical2() {
      Term[] terms = {new Term("the", 23135851162l),
                      new Term("of", 1315194277l),
                      new Term("and", 12997637966l),
                      new Term("to", 12136980858l),
                      new Term("a", 9081174698l),
                      new Term("in", 8469404971l),
                      new Term("for", 5933321709l),
                      new Term("is", 4705743816l),
                      new Term("on", 3750423199l),
                      new Term("that", 3400031103l)};
                      
       Autocomplete autocompl = new Autocomplete(terms);
       Term[] myMatches = autocompl.allMatches("th");
       
       Assert.assertEquals("the" + "\t" + 23135851162l, myMatches[0].toString());
       Assert.assertEquals("that" + "\t" + 3400031103l, myMatches[1].toString());
       
       Assert.assertEquals(2, myMatches.length);
   }
   
   /** Tests for typical values of Term - Test 1 **/
   @Test public void testAutocompleteTypical3() {
      Term[] terms = {new Term("in", 8469404971l),
                      new Term("of", 1315194277l),
                      new Term("and", 12997637966l),
                      new Term("to", 12136980858l),
                      new Term("a", 9081174698l),
                      new Term("the", 23135851162l),
                      new Term("for", 5933321709l),
                      new Term("is", 4705743816l),
                      new Term("on", 3750423199l),
                      new Term("that", 3400031103l)};
                      
       Autocomplete autocompl = new Autocomplete(terms);
       Term[] myMatches = autocompl.allMatches("th");
       
       Assert.assertEquals("the" + "\t" + 23135851162l, myMatches[0].toString());
       Assert.assertEquals("that" + "\t" + 3400031103l, myMatches[1].toString());
       
       Assert.assertEquals(2, myMatches.length);
   }
}
