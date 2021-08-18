import org.junit.Assert;
import org.junit.Test;
import java.util.Collection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
public class SelectorTest {
   static Integer[] a = {2, 8, 7, 3, 4};
   static Collection<Integer> coll1 = Arrays.<Integer>asList(a);

   static Integer[] b = {5, 9, 1, 7, 3};
   static Collection<Integer> coll2 = Arrays.<Integer>asList(b);
   
   static Integer[] c = {8, 7, 6, 5, 4};
   static Collection<Integer> coll3 = Arrays.<Integer>asList(c);
   
   static Integer[] d = {8, 2, 8, 7, 3, 3, 4};
   static Collection<Integer> coll4 = Arrays.<Integer>asList(d);   
   
   private static class CompareIntegers implements Comparator<Integer> {
   
      @Override
      public int compare(Integer int1, Integer int2) {
         return int1.compareTo(int2);
      }
   }
   
   private static class CompareIntegersDescending implements Comparator<Integer> {
      @Override
      public int compare(Integer int1, Integer int2) {
         return -int1.compareTo(int2);
      }
   }

   private static CompareIntegers ascendingOrder = new CompareIntegers();
   private static CompareIntegersDescending descendingOrder = new CompareIntegersDescending();
   
   /**
    * Selector.min() tests.
    */
   @Test(expected = IllegalArgumentException.class)
   public void testMinIllegalArgumentOne() {
      Collection<Integer> invalColl = null;
      Selector.<Integer>min(invalColl, ascendingOrder);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testMinIllegalArgumentTwo() {
      Comparator<Integer> invalComp = null;
      Selector.<Integer>min(coll1, invalComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void testMinNoSuchElement() {
      List<Integer> arrList = new ArrayList<>();
      Selector.<Integer>min(arrList, ascendingOrder);
   }

   @Test
   public void testMinTypical1() {
      Integer expected = 2;
      Integer actual = Selector.<Integer>min(coll1, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMinTypical2() {
      Integer expected = 1;
      Integer actual = Selector.<Integer>min(coll2, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMinTypical3() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>min(coll3, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMinTypical4() {
      Integer expected = 2;
      Integer actual = Selector.<Integer>min(coll4, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMinTypical5() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>min(coll1, descendingOrder);
      Assert.assertEquals(expected, actual);
   }
   /**
    * Selector.max() tests.
    */
   @Test(expected = IllegalArgumentException.class)
   public void testMaxIllegalArgumentOne() {
      Collection<Integer> invalColl = null;
      Selector.<Integer>min(invalColl, ascendingOrder);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testMaxIllegalArgumentTwo() {
      Comparator<Integer> invalComp = null;
      Selector.<Integer>min(coll1, invalComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void testMaxNoSuchElement() {
      List<Integer> arrList = new ArrayList<>();
      Selector.<Integer>min(arrList, ascendingOrder);
   }
   
   @Test
   public void testMaxTypical1() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>max(coll1, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMaxTypical2() {
      Integer expected = 9;
      Integer actual = Selector.<Integer>max(coll2, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMaxTypical3() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>max(coll3, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMaxTypical4() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>max(coll4, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testMaxTypical5() {
      Integer expected = 2;
      Integer actual = Selector.<Integer>max(coll1, descendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   /**
   * Tests for the static unique method.
   */
   @Test
   public void testUniqueNormal1() {
      int expected = 5;
      int actual = Selector.<Integer>unique(coll1);
      Assert.assertEquals(expected, actual);
   }
   
   /**
   * Tests for the kmin method.
   */
   @Test(expected = IllegalArgumentException.class)
   public void testKminIllegalArgumentOne() {
      Collection<Integer> invalColl = null;
      Selector.<Integer>kmin(invalColl, 1, ascendingOrder);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testKminIllegalArgumentTwo() {
      Comparator<Integer> invalComp = null;
      Selector.<Integer>kmin(coll1, 2, invalComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void testKminNoSuchElement() {
      List<Integer> arrList = new ArrayList<>();
      Selector.<Integer>kmin(arrList, 2, ascendingOrder);
   }
   
   @Test
   public void testKminNormal1() {
      Integer expected = 2;
      Integer actual = Selector.<Integer>kmin(coll1, 1, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testKminNormal2() {
      Integer expected = 5;
      Integer actual = Selector.<Integer>kmin(coll2, 3, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testKminNormal3() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>kmin(coll3, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testKminNormal4() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>kmin(coll4, 3, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void testKminNormal5() {
      Integer expected = 7;
      Integer actual = Selector.<Integer>kmin(coll1, 2, descendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
  /**
  * Tests for the kmax method.
  */
   @Test(expected = IllegalArgumentException.class)
   public void testKmaxIllegalArgumentOne() {
      Collection<Integer> invalColl = null;
      Selector.<Integer>kmax(invalColl, 1, ascendingOrder);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testKmaxIllegalArgumentTwo() {
      Comparator<Integer> invalComp = null;
      Selector.<Integer>kmax(coll1, 2, invalComp);
   }

   @Test(expected = NoSuchElementException.class)
   public void testKmaxNoSuchElement() {
      List<Integer> arrList = new ArrayList<>();
      Selector.<Integer>kmax(arrList, 2, ascendingOrder);
   }
  
   @Test
   public void testKmaxNormal1() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>kmax(coll1, 1, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void testKmaxNormal2() {
      Integer expected = 5;
      Integer actual = Selector.<Integer>kmax(coll2, 3, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void testKmaxNormal3() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>kmax(coll3, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void testKmaxNormal4() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>kmax(coll4, 3, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testKmaxNormal5() {
      Integer expected = 3;
      Integer actual = Selector.<Integer>kmax(coll1, 2, descendingOrder);
      Assert.assertEquals(expected, actual);
   }
   /**
   * Tests for the Range method
   */
   @Test (expected = NoSuchElementException.class)
   public void testRangeNoSuch1() {
      Collection<Integer> actual = Selector.<Integer>range(coll1, 11, 20, ascendingOrder);
   }
   
   @Test (expected = NoSuchElementException.class)
   public void testRangeNoSuch2() {
      ArrayList<Integer> emptyArrList = new ArrayList<>();
      Collection<Integer> actual = Selector.<Integer>range(emptyArrList, 1, 10, ascendingOrder);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testIllegalArg1() {
      Comparator<Integer> invalComparator = null;
      Collection<Integer> actual = Selector.<Integer>range(coll1, 2, 5, invalComparator);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testIllegalArg2() {
      ArrayList<Integer> invalColl = null;
      Collection<Integer> actual = Selector.<Integer>range(invalColl, 2, 4, ascendingOrder);
   }
   
   @Test public void testRangeNormal1() {
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(2);
      expected.add(3);
      expected.add(4);
      Collection<Integer> actual = Selector.<Integer>range(coll1, 1, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testRangeNormal2() {
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(5);
      expected.add(3);
      Collection<Integer> actual = Selector.<Integer>range(coll2, 3, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testRangeNormal3() {
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(8);
      expected.add(7);
      expected.add(6);
      expected.add(5);
      expected.add(4);
      Collection<Integer> actual = Selector.<Integer>range(coll3, 4, 8, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void testRangeNormal4() {
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(7);
      expected.add(3);
      expected.add(3);
      expected.add(4);
      Collection<Integer> actual = Selector.<Integer>range(coll4, 3, 7, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test public void testRangeNormal5() {
      ArrayList<Integer> expected = new ArrayList<>();
      expected.add(5);
      expected.add(3);
      Collection<Integer> actual = Selector.<Integer>range(coll2, 5, 3, descendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   /**
   * Tests for the Selector.floor method.
   */
   
   @Test (expected = IllegalArgumentException.class)
   public void testFloorIllegalArg1() {
      Collection<Integer> invalidColl = null;
      Integer actual = Selector.<Integer>floor(invalidColl, 5, ascendingOrder);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testFlooIllegalArg2() {
      Comparator<Integer> invalidComparator = null;
      Integer actual = Selector.<Integer>floor(coll1, 5, invalidComparator);
   }
   
   @Test (expected = NoSuchElementException.class)
   public void testFloorNoSuch1() {
      Integer actual = Selector.<Integer>floor(coll1, -20, ascendingOrder);
   }
   
   @Test (expected = NoSuchElementException.class)
   public void testFloorNoSuch2(){
      ArrayList<Integer> emptyList = new ArrayList<>();
      Integer actual = Selector.<Integer>floor(emptyList, 2, ascendingOrder);
   }
   
   @Test
   public void testFloorTypical1() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>floor(coll1, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testFloorTypical2() {
      Integer expected = 1;
      Integer actual = Selector.<Integer>floor(coll2, 1, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testFloorTypical3() {
      Integer expected = 8;
      Integer actual = Selector.<Integer>floor(coll3, 9, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testFloorTypical4() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>floor(coll4, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testFloorTypical5() {
      Integer expected = 7;
      Integer actual = Selector.<Integer>floor(coll1, 5, descendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   /**
   * Selector.ceiling() tests.
   */
   
   @Test
   public void testCeilingTypical1() {
      Integer expected = 2;
      Integer actual = Selector.<Integer>ceiling(coll1, 1, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testCeilingTypical2() {
      Integer expected = 7;
      Integer actual = Selector.<Integer>ceiling(coll2, 7, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testCeilingTypical3() {
      Integer expected = 4;
      Integer actual = Selector.<Integer>ceiling(coll3, 0, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void testCeilingTypical4() {
      Integer expected = 7;
      Integer actual = Selector.<Integer>ceiling(coll4, 5, ascendingOrder);
      Assert.assertEquals(expected, actual);
   }
   
}
