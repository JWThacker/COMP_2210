import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class BinarySearchTest {

   @Test (expected = NullPointerException.class)
   public void testFirstIndexOfNullException1() {
      Term[] terms = null;
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      
   }

   @Test (expected = NullPointerException.class)
   public void testFirstIndexOfNullException2() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      int i = BinarySearch.<Term>firstIndexOf(terms, null,
      Term.byPrefixOrder(2));
      
   }

   @Test (expected = NullPointerException.class)
   public void testFirstIndexOfNullException3() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("the wally walrus", 200),
      null);
      
   }

   /** A test that always fails. **/
   @Test public void testFirstIndexOf() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(5, i);
   }
   
   @Test public void testFirstIndexOfUnique() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(5, i);
   }
   
   @Test public void testFirstIndexOfDoesNotExist() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(-1, i);
   }
   
   @Test public void testFirstIndexOfMultiples() {
      Term[] terms = {new Term("atypical", 100), 
                      new Term("short stuff", 100),
                      new Term("short stuff", 200),
                      new Term("short stuff", 400),
                      new Term("short stuff", 600),
                      new Term("short stuff", 50),
                      new Term("zealot", 300)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("short stuff", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(1, i);
   }
   
   @Test (expected = NullPointerException.class)
   public void testLastIndexOfNullException1() {
      Term[] terms = null;
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      
   }
   
   @Test (expected = NullPointerException.class)
   public void testLastIndexOfNullException2() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      int i = BinarySearch.<Term>lastIndexOf(terms, null,
      Term.byPrefixOrder(2));
   }
   
   @Test (expected = NullPointerException.class)
   public void testLastIndexOfNullException3() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      null);
      
   }
   
   @Test public void testLastIndexOf() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(6, i);
   }
   
   @Test public void testLastIndexOfUnique() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(5, i);
   }
   
   @Test public void testLastIndexOfDoesNoExist() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(-1, i);
   }
   
   @Test public void testLastIndexOfMultiples() {
      Term[] terms = {new Term("atypical", 100), 
                      new Term("short stuff", 100),
                      new Term("short stuff", 200),
                      new Term("short stuff", 400),
                      new Term("short stuff", 600),
                      new Term("short stuff", 50),
                      new Term("zealot", 300)};
      Arrays.sort(terms, Term.byPrefixOrder(2));
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("short stuff", 200),
      Term.byPrefixOrder(2));
      Assert.assertEquals(5, i);
   }
    
   @Test public void testFirstIndexOfDescendingWeight() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("the wally walrus", 200),
      Term.byDescendingWeightOrder());
      Assert.assertEquals(2, i);
   }
   
   @Test public void testLastIndexOfDescendingWeight() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("the wally walrus", 200),
                      new Term("short the", 200),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50),
                      new Term("the wally walrus", 200)};
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      Term.byDescendingWeightOrder());
      Assert.assertEquals(4, i);
   }
   
   @Test public void testLastIndexOfDescendingWeightDNE() {
      Term[] terms = {new Term("short stuff", 100),
                      new Term("long tension", 400),
                      new Term("a new world", 600),
                      new Term("hot dog", 50)};
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("the wally walrus", 200),
      Term.byDescendingWeightOrder());
      Assert.assertEquals(-1, i);
   }
   
   @Test public void testLastIndexOfMultiplesWeight() {
      Term[] terms = {new Term("atypical", 100), 
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("zealot", 300)};
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      int i = BinarySearch.<Term>lastIndexOf(terms, new Term("short stuff", 200),
      Term.byDescendingWeightOrder());
      Assert.assertEquals(5, i);
   }
   
   @Test public void testFirstIndexOfMultiplesWeight() {
      Term[] terms = {new Term("atypical", 100), 
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("short stuff", 200),
                      new Term("zealot", 300)};
      Arrays.sort(terms, Term.byDescendingWeightOrder());
      int i = BinarySearch.<Term>firstIndexOf(terms, new Term("short stuff", 200),
      Term.byDescendingWeightOrder());
      Assert.assertEquals(1, i);
   }
}
