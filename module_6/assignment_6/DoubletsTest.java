import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class DoubletsTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() throws FileNotFoundException {
       WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
       Assert.assertEquals(267751, doublets.getWordCount());
   }
   
   @Test
   public void testIsWord() throws FileNotFoundException {
       WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
       Assert.assertTrue(doublets.isWord("axels"));
   }
   
   @Test
   public void testGetHammingDistance1() throws FileNotFoundException {
       WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
       Assert.assertEquals(3, doublets.getHammingDistance("tiger", "tabor"));
   }
   
   @Test
   public void testGetHammingDistance2() throws FileNotFoundException {
       WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
       Assert.assertEquals(-1, doublets.getHammingDistance("tiger", "tigress"));
   }
   
   @Test
   public void testing() throws FileNotFoundException {
       WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
       System.out.println(doublets.getNeighbors("cat"));
   }
   
   @Test
   public void testing2() throws FileNotFoundException {
       WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
       System.out.println(doublets.getNeighbors("atok"));
   }
   
   //@Test
   //public void testing3() throws FileNotFoundException {
   //    WordLadderGame doublets = new Doublets(new FileInputStream(new File("sowpods.txt")));
   //    System.out.println(doublets.bfs("cat", "dog"));
   //}
}
