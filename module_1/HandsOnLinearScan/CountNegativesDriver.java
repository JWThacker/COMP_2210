public class CountNegativesDriver {
   public static void main(String args[]) {
      int[] myArray = {1, 2, -3, 4, 10, -20, 20, -5};
      int countOfNegs = CountNegatives.countNegatives(myArray);
      System.out.println(countOfNegs);
   }
}
