import java.util.List;
import java.util.ArrayList;
public class SelectorDriver {
   public static void main(String[] args) {
      List<Integer> arrList = new ArrayList<Integer>();
      arrList.add(4);
      arrList.add(3);
      arrList.add(1);
      
      System.out.println(Selector.min(arrList, Comparator<Integer>.compare()));
   }
}