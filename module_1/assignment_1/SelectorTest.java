import org.junit.Assert;
import org.junit.Test;


public class SelectorTest {

   /** A test that always fails. **/
   @Test(expected = IllegalArgumentException.class)
   public void test_min_nullArr() {
      int[] arr = null;
      int minArr = Selector.min(arr);
      
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_min_length0() {
      int[] arr = {};
      int minArr = Selector.min(arr);
   }
   
   @Test
   public void test_min_typical1() {
      int[] a= {2, 8, 7, 3, 4};
      int expected = 2;
      int actual = Selector.min(a);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min_typical2() {
      int[] a= {5, 9, 1, 7, 3};
      int expected = 1;
      int actual = Selector.min(a);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min_allSame() {
      int[] a = {0, 0, 0};
      int expected = 0;
      int actual = Selector.min(a);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min_allSameButOne() {
      int[] a = {0, 0, 1};
      int expected = 0;
      int actual = Selector.min(a);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_max_nullArr() {
      int[] arr = null;
      int maxArr = Selector.max(arr);
      
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_max_length0() {
      int[] arr = {};
      int maxArr = Selector.max(arr);
   }
   
   @Test
   public void test_max_typical1() {
      int[] arr = {2, 8 , 7, 3, 4};
      int expected = 8;
      int actual = Selector.max(arr);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_max_typical2() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int expected = 8;
      int actual = Selector.max(arr);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmin_illegalArg1() {
      int[] arr = {};
      int kMin = Selector.kmin(arr, 3);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmin_illegalArg2() {
      int[] arr = null;
      int kMin = Selector.kmin(arr, 3);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void test_kmin_arrayTooShort() {
      int[] arr = {1, 3, 2};
      int actual = Selector.kmin(arr, 4);
   }
   
   @Test
   public void test_kmin_typical1() {
      int[] arr = {2, 8, 7, 3, 4};
      int expected = 2;
      int actual = Selector.kmin(arr, 1);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_kmin_typical2() {
      int[] arr = {5, 9, 1, 7, 3};
      int expected = 5;
      int actual = Selector.kmin(arr, 3);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_kmin_typical3() {
      int[] arr = {8, 7, 6, 5, 4};
      int expected = 8;
      int actual = Selector.kmin(arr, 5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_kmin_typical4() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int expected = 4;
      int actual = Selector.kmin(arr, 3);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmin_allSame() {
      int[] arr = {1, 1, 1, 1, 1, 1};
      int actual = Selector.kmin(arr, 3);
   }
   
   @Test
   public void test_kmin_exactlyK() {
      int[] arr = {1, 1, 3, 4, 1, 1};
      int expected = 4;
      int actual = Selector.kmin(arr, 3);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmax_illegalArg1() {
      int[] arr = {};
      int kMax = Selector.kmax(arr, 3);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmax_illegalArg2() {
      int[] arr = null;
      int kMax = Selector.kmax(arr, 3);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmax_arrayTooShort() {
      int[] arr = {1, 3, 2};
      int actual = Selector.kmax(arr, 4);
   }
   
   @Test
   public void test_kmax_typical1() {
      int[] arr = {2, 8, 7, 3, 4};
      int expected = 8;
      int actual = Selector.kmax(arr, 1);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_kmax_typical2() {
      int[] arr = {5, 9, 1, 7, 3};
      int expected = 5;
      int actual = Selector.kmax(arr, 3);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_kmax_typical3() {
      int[] arr = {8, 7, 6, 5, 4};
      int expected = 4;
      int actual = Selector.kmax(arr, 5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_kmax_typical4() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int expected = 4;
      int actual = Selector.kmax(arr, 3);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_kmax_allSame() {
      int[] arr = {1, 1, 1, 1, 1, 1};
      int actual = Selector.kmax(arr, 3);
   }
   
   @Test
   public void test_kax_exactlyK() {
      int[] arr = {1, 1, 3, 4, 1, 1};
      int expected = 1;
      int actual = Selector.kmax(arr, 3);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_range_illegalArg1() {
      int[] arr = null;
      int[] kMax = Selector.range(arr, 1, 5);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_range_illegalArg2() {
      int [] arr = {};
      int[] range = Selector.range(arr, 1, 5);
   }
   
   @Test
   public void test_range_typical1() {
      int[] arr = {2, 8, 7, 3, 4};
      int[] expected = {2, 3, 4};
      int[] actual = Selector.range(arr, 1, 5);
      for (int i = 0; i < expected.length; i++) {
         Assert.assertEquals(expected[i], actual[i]);
      }
   }
   
   @Test
   public void test_range_typical2() {
      int[] arr = {5, 9, 1, 7, 3};
      int[] expected = {5, 3};
      int[] actual = Selector.range(arr, 3, 5);
      for (int i = 0; i < expected.length; i++) {
         Assert.assertEquals(expected[i], actual[i]);
      }
   }
   
   @Test
   public void test_range_typical3() {
      int[] arr = {8, 7, 6, 5, 4};
      int[] expected = {8, 7, 6, 5, 4};
      int[] actual = Selector.range(arr, 4, 8);
      for (int i = 0; i < expected.length; i++) {
         Assert.assertEquals(expected[i], actual[i]);
      }
   }
   
   @Test
   public void test_range_typical4() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int[] expected = {7, 3, 3, 4};
      int[] actual = Selector.range(arr, 3, 7);
      for (int i = 0; i < expected.length; i++) {
         Assert.assertEquals(expected[i], actual[i]);
      }
   }
   
   @Test
   public void test_range_noValues() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int expected = 0;
      int actual = Selector.range(arr, 10, 100).length;
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_ceiling_typical1() {
      int[] arr = {2, 8, 7, 3, 4};
      int expected = 2;
      int actual = Selector.ceiling(arr, 1);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_ceiling_typical2() {
      int[] arr = {5, 9, 1, 7, 3};
      int expected  = 7;
      int actual = Selector.ceiling(arr, 7);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_ceiling_typical3() {
      int[] arr = {8, 7, 6, 5, 4};
      int expected = 4;
      int actual = Selector.ceiling(arr, 0);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_ceiling_typical4() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int expected = 7;
      int actual = Selector.ceiling(arr, 5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_ceiling_allSameIllegal() {
      int[] arr = {3, 3, 3, 3};
      int actual = Selector.ceiling(arr, 5);
   }
   
   @Test
   public void test_ceiling_allSame() {
      int[] arr = {3, 3, 3, 3};
      int expected = 3;
      int actual = Selector.ceiling(arr, 2);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_floor_typical1() {
      int[] arr = {2, 8, 7, 3, 4};
      int expected = 4;
      int actual = Selector.floor(arr, 6);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_floor_typical2() {
      int[] arr = {5, 9, 1, 7, 3};
      int expected = 1;
      int actual = Selector.floor(arr, 1);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_floor_typical3() {
      int[] arr = {8, 7, 6, 5, 4};
      int expected = 8;
      int actual = Selector.floor(arr, 9);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_floor_typical4() {
      int[] arr = {8, 2, 8, 7, 3, 3, 4};
      int expected = 4;
      int actual = Selector.floor(arr, 5);
      Assert.assertEquals(expected, actual);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void test_floor_allSameIllegal() {
      int[] arr = {3, 3, 3, 3};
      int expected = 3;
      int actual = Selector.floor(arr, 1);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_floor_allSame() {
      int[] arr = {3, 3, 3, 3};
      int expected = 3;
      int actual = Selector.floor(arr, 4);
      Assert.assertEquals(expected, actual);
   }
}