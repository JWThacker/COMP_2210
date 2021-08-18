import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;


public class TermTest {

   /** Test the byDescendingWeightOrder comparator with typical values. **/
   @Test public void testDescendingWeightTypical() {
      Term[] terms = {new Term("long", 100), new Term("short", 200),
                      new Term("The", 400)};
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      Assert.assertEquals("The" + "\t" + "400", terms[0].toString());
      Assert.assertEquals("short" + "\t" + "200", terms[1].toString());
      Assert.assertEquals("long" + "\t" + "100", terms[2].toString());
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testPrefixOrderIllegalArg() {
      Term[] terms = {new Term("short", 100), new Term("the", 200),
                      new Term("long", 400)};
      Arrays.sort(terms, Term.byPrefixOrder(-1));
   }
   
   /** Test the byPrefixOrder comparator with typical values. **/
   @Test public void testPrefixOrderTypical() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400)};
      Arrays.sort(terms, Term.byPrefixOrder(7));
      Assert.assertEquals("long tension" + "\t" + "400", terms[0].toString());
      Assert.assertEquals("short stuff" + "\t" + "100", terms[1].toString());
      Assert.assertEquals("short the" + "\t" + "200", terms[2].toString());
      Assert.assertEquals("the wally walrus" + "\t" + "200", terms[3].toString());
   }
   
   /** Test the byPrefixOrder comparator with typical values. **/
   @Test public void testNaturalOrderTypical() {
      Term[] terms = {new Term("test melt", 100),
                      new Term("short stuff", 200),
                      new Term("abra kadabra", 200),
                      new Term("short ruff", 400)};
      Arrays.sort(terms);
      Assert.assertEquals("abra kadabra" + "\t" + "200", terms[0].toString());
      Assert.assertEquals("short ruff" + "\t" + "400", terms[1].toString());
      Assert.assertEquals("short stuff" + "\t" + "200", terms[2].toString());
      Assert.assertEquals("test melt" + "\t" + "100", terms[3].toString());
   }
}
