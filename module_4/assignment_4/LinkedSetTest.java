import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSetTest {

   @Test
   public void addTestStructuralTest() {
      LinkedSet<Integer> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<Integer>add(4);
      myLinkedSet.<Integer>add(1);
      myLinkedSet.<Integer>add(5);
      myLinkedSet.<Integer>add(3);
      myLinkedSet.<Integer>add(1);
      myLinkedSet.<Integer>add(2);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals(1, itr.next());
      Assert.assertEquals(2, itr.next());
      Assert.assertEquals(3, itr.next());
      Assert.assertEquals(4, itr.next());
      Assert.assertEquals(5, itr.next());
      Assert.assertEquals(null, myLinkedSet.front.prev);
      Assert.assertEquals(null, myLinkedSet.rear.next);
   }

   @Test
   public void addTest1Element() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("a");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
   }

   @Test
   public void addTest2Elements() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      
   }
   
   @Test
   public void addTest3Elements() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("c");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      
   }
   
   @Test
   public void addTest3ElementsOutOfOrder() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("c");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      
   }
   
   @Test
   public void addTest4Elements() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("d");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals("d", myLinkedSetIterator.next());
   }

   @Test
   public void addTest4ElementsOutOfOrder() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("d");
      myLinkedSet.<String>add("b");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals("d", myLinkedSetIterator.next());
   }

   @Test
   public void addTest4ElementsOutOfOrder2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("d");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("a");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals("d", myLinkedSetIterator.next());
   }

   @Test
   public void addTest5ElementsOutOfOrder1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("d");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("e");
      myLinkedSet.<String>add("c");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals("d", myLinkedSetIterator.next());
      Assert.assertEquals("e", myLinkedSetIterator.next());
   }

   @Test
   public void addTest5ElementsOutOfOrder2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("e");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("d");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals("d", myLinkedSetIterator.next());
      Assert.assertEquals("e", myLinkedSetIterator.next());
   }
   
   @Test
   public void addTestDuplicates() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals(1, myLinkedSet.size());
      Assert.assertFalse(myLinkedSet.<String>add("c"));
   }

   @Test
   public void addTestManyDuplicates() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("c");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals(1, myLinkedSet.size());
      Assert.assertFalse(myLinkedSet.<String>add("c"));
   }
   
   @Test
   public void addTestDuplicates2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("e");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("d");
      Iterator myLinkedSetIterator = myLinkedSet.iterator();
      Assert.assertEquals("a", myLinkedSetIterator.next());
      Assert.assertEquals("b", myLinkedSetIterator.next());
      Assert.assertEquals("c", myLinkedSetIterator.next());
      Assert.assertEquals("d", myLinkedSetIterator.next());
      Assert.assertEquals("e", myLinkedSetIterator.next());
      Assert.assertEquals(5, myLinkedSet.size());
   }

   /** A test that always fails. **/
   @Test public void testContains1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("e");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("d");
      Assert.assertTrue(myLinkedSet.contains("c"));
   }
   
   @Test public void testContains2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("c");
      myLinkedSet.<String>add("e");
      myLinkedSet.<String>add("b");
      myLinkedSet.<String>add("a");
      myLinkedSet.<String>add("d");
      Assert.assertFalse(myLinkedSet.contains("g"));
   }
   
   @Test public void testContains3() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      Assert.assertFalse(myLinkedSet.contains("g"));
   }
   
   @Test
   public void testRemoveSize1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      boolean wasRemoved = myLinkedSet.remove("a");
      Assert.assertTrue(wasRemoved);
      Assert.assertEquals(0, myLinkedSet.size());
   }
   
   @Test
   public void testRemoveBeginning() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      boolean wasRemoved = myLinkedSet.remove("a");
      Assert.assertTrue(wasRemoved);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals(2, myLinkedSet.size());
   }
   
   @Test
   public void testRemoveEnd() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      boolean wasRemoved = myLinkedSet.remove("c");
      Assert.assertTrue(wasRemoved);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals(2, myLinkedSet.size());
   }
   
   @Test
   public void testRemoveMiddle() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      boolean wasRemoved = myLinkedSet.remove("b");
      Assert.assertTrue(wasRemoved);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals(2, myLinkedSet.size());
   }
   
   @Test
   public void testRemoveFourElementsBeginning() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("d");
      boolean wasRemoved = myLinkedSet.remove("a");
      Assert.assertTrue(wasRemoved);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals("d", itr.next());
      Assert.assertEquals(3, myLinkedSet.size());
   }
   
   @Test
   public void testRemoveFourElementsBody() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("d");
      boolean wasRemoved = myLinkedSet.remove("b");
      Assert.assertTrue(wasRemoved);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals("d", itr.next());
      Assert.assertEquals(3, myLinkedSet.size());
   }
   
   @Test
   public void testRemoveFourElementsEnd() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("d");
      boolean wasRemoved = myLinkedSet.remove("d");
      Assert.assertTrue(wasRemoved);
      Iterator itr = myLinkedSet.iterator();
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals(3, myLinkedSet.size());
   }
   
   
   @Test
   public void testEqualsTypicalNotEqualNotSameSize() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.<String>add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      Set<String> mySecondLinkedSet = new LinkedSet<>();
      mySecondLinkedSet.add("a");
      mySecondLinkedSet.add("b");
      mySecondLinkedSet.add("c");
      mySecondLinkedSet.add("d");
      
      Assert.assertFalse(myLinkedSet.equals(mySecondLinkedSet));
   }
   
   @Test
   public void testComplementBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      Set<String> mySecondLinkedSet = new LinkedSet<>();
      
      Set<String> complementSet = myLinkedSet.<String>complement(mySecondLinkedSet);
      Assert.assertEquals(0, complementSet.size());
   }
   
   @Test
   public void testComplementTypical() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      Set<String> mySecondLinkedSet = new LinkedSet<>();
      mySecondLinkedSet.add("a");
      mySecondLinkedSet.add("b");
      mySecondLinkedSet.add("c");
      mySecondLinkedSet.add("d");
      
      Set<String> complementSet = myLinkedSet.<String>complement(mySecondLinkedSet);
      Assert.assertEquals(0, complementSet.size());
   }
   
   @Test
   public void testComplementTypical2() {
      Set<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      Set<String> mySecondLinkedSet = new LinkedSet<>();
      mySecondLinkedSet.add("a");
      mySecondLinkedSet.add("b");
      mySecondLinkedSet.add("c");
      mySecondLinkedSet.add("d");
      
      Set<String> complementSet = mySecondLinkedSet.<String>complement(myLinkedSet);
      Iterator<String> itr = complementSet.iterator();
      Assert.assertEquals(1, complementSet.size());
      Assert.assertEquals("d", itr.next());
   }
   
   @Test
   public void testComplementTypical3() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      Set<String> complementSet = myLinkedSet.<String>complement(parameterSet);
      Iterator<String> itr = complementSet.iterator();
      Assert.assertEquals(3, complementSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
   }
   
   @Test
   public void testComplementTypical4() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      parameterSet.add("c");
      Set<String> complementSet = myLinkedSet.<String>complement(parameterSet);
      Iterator<String> itr = complementSet.iterator();
      Assert.assertEquals(0, complementSet.size());
   }
   
   @Test
   public void testIntersectionTypical1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(2, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      
   }
   
   @Test
   public void testIntersectionTypical2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(0, interSet.size());
      
   }
   
   @Test
   public void testIntersectionTypical3() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(3, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      
   }
   
   @Test
   public void testIntersectionTypical4() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      Set<String> parameterSet = new LinkedSet<>();
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(0, interSet.size());
      
   }
   
   @Test
   public void testUnionTypical1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      Set<String> interSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(3, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      
   }
   
   @Test
   public void testUnionTypical2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("d");
      Set<String> interSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(4, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals("d", itr.next());
      
   }
   
   @Test
   public void testUnionBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      Set<String> parameterSet = new LinkedSet<>();
      Set<String> interSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(0, interSet.size());
      
   }
   
   @Test
   public void testUnionOneEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      Set<String> interSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(3, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
   }
   
   @Test
   public void testSetEqualsTypical1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertTrue(isEqual);      
   }
   
   @Test
   public void testSetEqualsTypical2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      Set<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("d");
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertFalse(isEqual);      
   }
   
   @Test
   public void testSetEqualsBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      Set<String> parameterSet = new LinkedSet<>();
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertTrue(isEqual);      
   }
   
   @Test
   public void testLinkedSetIntersectionTypical1() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(3, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      
   }
   
   @Test
   public void testLinkedSetIntersectionTypical2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(2, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      
   }
   
   @Test
   public void testLinkedSetIntersectionTypical3() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("d");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("e");
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(2, interSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
   }
   
   @Test
   public void testLinkedSetIntersectionOneEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(0, interSet.size());      
   }
   
   @Test
   public void testLinkedSetIntersectionBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      Set<String> interSet = myLinkedSet.<String>intersection(parameterSet);
      Iterator<String> itr = interSet.iterator();
      
      
      Assert.assertEquals(0, interSet.size());      
   }
   
   @Test
   public void testLinkedSetComplementTypical() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> mySecondLinkedSet = new LinkedSet<>();
      mySecondLinkedSet.add("a");
      mySecondLinkedSet.add("b");
      mySecondLinkedSet.add("c");
      mySecondLinkedSet.add("d");
      
      Set<String> complementSet = myLinkedSet.<String>complement(mySecondLinkedSet);
      Assert.assertEquals(0, complementSet.size());
   }
   
   @Test
   public void testLinkedSetComplementTypical2() {
      Set<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> mySecondLinkedSet = new LinkedSet<>();
      mySecondLinkedSet.add("a");
      mySecondLinkedSet.add("b");
      mySecondLinkedSet.add("c");
      mySecondLinkedSet.add("d");
      
      Set<String> complementSet = mySecondLinkedSet.<String>complement(myLinkedSet);
      Iterator<String> itr = complementSet.iterator();
      Assert.assertEquals(1, complementSet.size());
      Assert.assertEquals("d", itr.next());
   }
   
   @Test
   public void testLinkedSetComplementTypical3() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      Set<String> complementSet = myLinkedSet.<String>complement(parameterSet);
      Iterator<String> itr = complementSet.iterator();
      Assert.assertEquals(3, complementSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
   }
   
   @Test
   public void testLinkedSetComplementBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      LinkedSet<String> mySecondLinkedSet = new LinkedSet<>();
      
      Set<String> complementSet = myLinkedSet.<String>complement(mySecondLinkedSet);
      Assert.assertEquals(0, complementSet.size());
   }
   
   @Test
   public void testLinkedSetComplementOneEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      Set<String> complementSet = myLinkedSet.<String>complement(parameterSet);
      Iterator<String> itr = complementSet.iterator();
      Assert.assertEquals(0, complementSet.size());
   }
   
   @Test
   public void testLinkedSetUnionTypical() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(3, unionSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
    }
    
   @Test
   public void testLinkedSetUnionTypical2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      parameterSet.add("d");
      parameterSet.add("e");
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(5, unionSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals("d", itr.next());
      Assert.assertEquals("e", itr.next());
    }
    
   @Test
   public void testLinkedSetUnionOneEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(3, unionSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
    }
    
   @Test
   public void testLinkedSetUnionBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(0, unionSet.size());
    }
    
   @Test
   public void testLinkedSetUnionAllSame() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("c");
      parameterSet.add("c");
      parameterSet.add("c");
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(1, unionSet.size());
      Assert.assertEquals("c", itr.next());
    }
    
   @Test
   public void testLinkedSetUnionTypical3() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("c");
      parameterSet.add("d");
      parameterSet.add("e");
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(5, unionSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals("d", itr.next());
      Assert.assertEquals("e", itr.next());
      }
      
   @Test
   public void testLinkedSetUnionTypical4() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("d");
      parameterSet.add("e");
      
      Set<String> unionSet = myLinkedSet.<String>union(parameterSet);
      Iterator<String> itr = unionSet.iterator();
      Assert.assertEquals(5, unionSet.size());
      Assert.assertEquals("a", itr.next());
      Assert.assertEquals("b", itr.next());
      Assert.assertEquals("c", itr.next());
      Assert.assertEquals("d", itr.next());
      Assert.assertEquals("e", itr.next());
      }
      
   @Test
   public void testLinkedSetEqualsTypical() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertTrue(isEqual);
      }
      
   @Test
   public void testLinkedSetEqualsTypical2() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("d");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      parameterSet.add("c");
      
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertFalse(isEqual);
      }
      
   @Test
   public void testLinkedSetEqualsBothEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertTrue(isEqual);
      }
      
   @Test
   public void testLinkedSetEqualsDifferenSizes() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertFalse(isEqual);
      }
      
   @Test
   public void testLinkedSetEqualsOneEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      myLinkedSet.add("a");
      myLinkedSet.add("b");
      myLinkedSet.add("c");
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertFalse(isEqual);
      }
      
   @Test
   public void testLinkedSetEqualsOtherEmpty() {
      LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
      LinkedSet<String> parameterSet = new LinkedSet<>();
      parameterSet.add("a");
      parameterSet.add("b");
      
      boolean isEqual = myLinkedSet.<String>equals(parameterSet);
      Assert.assertFalse(isEqual);
      }
      
            
      @Test (expected = NoSuchElementException.class)
      public void testDescendingIteratorNextOutOfElements() {
         LinkedSet<String> myLinkedSet = new LinkedSet<>();
         myLinkedSet.add("a");
         myLinkedSet.add("b");
         myLinkedSet.add("c");
      
         Iterator<String> itr = myLinkedSet.descendingIterator();
         itr.next();
         itr.next();
         itr.next();
         itr.next();
      }
      
      @Test
      public void testDescendingIteratorNext() {
         LinkedSet<String> myLinkedSet = new LinkedSet<>();
         myLinkedSet.add("a");
         myLinkedSet.add("b");
         myLinkedSet.add("c");
      
         Iterator<String> itr = myLinkedSet.descendingIterator();
         Assert.assertEquals("c", itr.next());
         Assert.assertEquals("b", itr.next());
         Assert.assertEquals("a", itr.next());
      }
      
      @Test
      public void testDescendingIteratorNext2() {
         LinkedSet<String> myLinkedSet = new LinkedSet<>();
         myLinkedSet.add("a");
         myLinkedSet.add("b");
         myLinkedSet.add("c");
         myLinkedSet.add("d");
      
         Iterator<String> itr = myLinkedSet.descendingIterator();
         Assert.assertEquals("d", itr.next());
         Assert.assertEquals("c", itr.next());
         Assert.assertEquals("b", itr.next());
         Assert.assertEquals("a", itr.next());
      }
      
      @Test (expected = NoSuchElementException.class)
      public void testDescendingIteratorNoElements() {
         LinkedSet<String> myLinkedSet = new LinkedSet<>();
      
         Iterator<String> itr = myLinkedSet.descendingIterator();
         itr.next();
      }
}