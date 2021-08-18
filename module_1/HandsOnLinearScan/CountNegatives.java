public class CountNegatives {
   public static int countNegatives(int a[]) {
      int negativeCount = 0;
      for (int num : a) {
         if (num < 0) {
            negativeCount++;
         }
      }
      return negativeCount;
   }
}
