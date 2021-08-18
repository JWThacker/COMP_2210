import org.junit.Assert;
import org.junit.Test;


public class MinOfThreeTest {

   /** Typical cases for min1**/
   @Test
   public void test_min1_typical() {
      int a = 1;
      int b = 2; 
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }


   /** Boundary Cases fpr min1**/
   @Test
   public void test_min1_MAX_VALUE() {
      int a = Integer.MAX_VALUE;
      int b = Integer.MAX_VALUE;
      int c = Integer.MAX_VALUE;
      int expected = Integer.MAX_VALUE;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_min1_MIN_VALUE() {
      int a = Integer.MAX_VALUE;
      int b = Integer.MIN_VALUE;
      int c = Integer.MAX_VALUE;
      int expected = Integer.MIN_VALUE;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }


   /** Special cases for min1. **/
   @Test
   public void test_min1_000() {
      int a = 0;
      int b = 0;
      int c = 0;
      int expected = 0;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min1_001() {
      int a = 1;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min1_010() {
      int a = 1;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min1_011() {
      int a = 1;
      int b = 2;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min1_100() {
      int a = 2;
      int b = 1;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min1_101() {
      int a = 2;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min1_110() {
      int a = 2;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   /** Typical cases for min2**/
   @Test
   public void test_min2_typical() {
      int a = 1;
      int b = 2; 
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }


   /** Boundary Cases fpr min2**/
   @Test
   public void test_min2_MAX_VALUE() {
      int a = Integer.MAX_VALUE;
      int b = Integer.MAX_VALUE;
      int c = Integer.MAX_VALUE;
      int expected = Integer.MAX_VALUE;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_min2_MIN_VALUE() {
      int a = Integer.MAX_VALUE;
      int b = Integer.MIN_VALUE;
      int c = Integer.MAX_VALUE;
      int expected = Integer.MIN_VALUE;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }


   /** Special cases for min2. **/
   @Test
   public void test_min2_000() {
      int a = 0;
      int b = 0;
      int c = 0;
      int expected = 0;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min2_001() {
      int a = 1;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min2_010() {
      int a = 1;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min2_011() {
      int a = 1;
      int b = 2;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min2_100() {
      int a = 2;
      int b = 1;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min2_101() {
      int a = 2;
      int b = 1;
      int c = 2;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void test_min2_110() {
      int a = 2;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      Assert.assertEquals(expected, actual);
   }
}
