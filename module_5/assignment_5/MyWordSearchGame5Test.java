import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

public class MyWordSearchGame5Test {

   @Test (expected = IllegalArgumentException.class)
   public void testIsValidWordIllegalArgument() {
      MyWordSearchGame5 myGame = new MyWordSearchGame5();
      myGame.loadLexicon("words_small.txt");
      boolean isValidWord = myGame.isValidWord(null);
   }
   
   @Test (expected = IllegalStateException.class)
   public void testIsValidWordIllegalState() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       boolean isValidWord = myGame.isValidWord("aback");
   }

   /** Testing isValidWord - typical. **/
   @Test public void testIsValidWord() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words_small.txt");
       boolean isValidWord = myGame.isValidWord("aback");
       Assert.assertEquals(true, isValidWord);
       isValidWord = myGame.isValidWord("zygote");
       Assert.assertEquals(true, isValidWord);
   }

   @Test public void testIsValidWord2() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words_small.txt");
       boolean isValidWord = myGame.isValidWord("zzz");
       Assert.assertFalse(isValidWord);
   }

   @Test public void testIsValidWordLarge() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("CSW12.txt");
       boolean isValidWord = myGame.isValidWord("unlearnednesses");
       Assert.assertTrue(isValidWord);
   }

   @Test (expected = IllegalArgumentException.class)
   public void testIsValidPrefixIllegalArgument() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words_small.txt");
       boolean isValidPrefix = myGame.isValidPrefix(null);
   }

   @Test (expected = IllegalStateException.class)
   public void testIsValidPrefixIllegalState() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       boolean isValidPrefix = myGame.isValidPrefix("zy");
   }
   
   /** A test that always fails. **/
   @Test public void testIsValidPrefixTypical() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words_small.txt");
       boolean isValidPrefix = myGame.isValidPrefix("zy");
       Assert.assertTrue(isValidPrefix);
   }
   
   /** A test that always fails. **/
   @Test public void testIsValidPrefix2() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words_small.txt");
       boolean isValidPrefix = myGame.isValidPrefix("abq");
       Assert.assertFalse(isValidPrefix);
   }
   
   @Test public void testIsValidPrefixLarge() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("CSW12.txt");
       boolean isValidPrefix = myGame.isValidPrefix("unlearn");
       Assert.assertTrue(isValidPrefix);
   }

   @Test
   public void testAllScorableWords1x1TIGER() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(new String[]{"TIGER"});
       myGame.loadLexicon("words_small.txt");
       List<Integer> isThere = myGame.isOnBoard("TIGER");
       Assert.assertEquals(0, isThere.get(0).intValue());
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testSetBoardNotSquare() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(new String[]{"TIGER", "CHILE", "WOOHOO"});
   }

   @Test (expected = IllegalArgumentException.class)
   public void testSetBoardArrIsNull() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(null);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testSetBoardArrNoElements() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(new String[]{});
   }
   
   @Test
   public void testSetBoardTypical() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(new String[]{"TIGER", "ALEHOP", "CATFISH", "pedro"});
       Assert.assertEquals("TIGER ALEHOP CATFISH PEDRO", myGame.getBoard());
   }

   @Test
   public void testAllScorableWords2x2CATFISH() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(new String[]{"CAT", "X", "XXXX", "FISH"});
       myGame.loadLexicon("words_small.txt");
       List<Integer> isThere = myGame.isOnBoard("CATFISH");
       Assert.assertEquals(0, isThere.get(0).intValue());
       Assert.assertEquals(3, isThere.get(1).intValue());
       System.out.println(isThere);
       isThere = myGame.isOnBoard("TIGER");
       Assert.assertTrue(isThere.isEmpty());
       Assert.assertEquals("CAT X XXXX FISH", myGame.getBoard());
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testisOnBoardIllegalArg() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       List<Integer> isThere = myGame.isOnBoard(null);
   }
   
   @Test (expected = IllegalStateException.class)
   public void testisOnBoardIllegalState() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       List<Integer> isThere = myGame.isOnBoard("TIGER");
   }
   
   @Test
   public void testIsOnBoardTypical1() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words_small.txt");
       List<Integer> isThere = myGame.isOnBoard("LENT");
       Assert.assertEquals(5, isThere.get(0).intValue());
       Assert.assertEquals(6, isThere.get(1).intValue());
       Assert.assertEquals(9, isThere.get(2).intValue());
       Assert.assertEquals(14, isThere.get(3).intValue());
       isThere = myGame.isOnBoard("PEACE");
       Assert.assertEquals(7, isThere.get(0).intValue());
       Assert.assertEquals(6, isThere.get(1).intValue());
       Assert.assertEquals(3, isThere.get(2).intValue());
       Assert.assertEquals(2, isThere.get(3).intValue());
       Assert.assertEquals(1, isThere.get(4).intValue());
       isThere = myGame.isOnBoard("APES");
       Assert.assertTrue(isThere.isEmpty());
   }

   @Test
   public void testGetAllScorableWordsTypical() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words.txt");
       SortedSet<String> mySet = myGame.getAllScorableWords(6);
       Iterator<String> itr = mySet.iterator();
       String currentValue = "";
       String[] myValues = {"ALEPOT", "BENTHAL", "PELEAN", "TOECAP"};
       int i = 0;
       while(itr.hasNext()) {
           currentValue = itr.next();
           Assert.assertEquals(myValues[i], currentValue);
           i++;
       }
   }
   
   @Test (expected = IllegalStateException.class)
   public void testGetAllScorableWordsIllegalState() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       SortedSet<String> mySet = myGame.getAllScorableWords(6);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testGetAllScorableWordsIllegalArgument() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       SortedSet<String> mySet = myGame.getAllScorableWords(-1);
   }
   
   @Test
   public void testAllScorableWords1x1TIGERWordsMedium() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.setBoard(new String[]{"TIGER"});
       myGame.loadLexicon("words_medium.txt");
       SortedSet<String> isThere = myGame.getAllScorableWords(3);
       Iterator<String> itr = isThere.iterator();
       String[] values = {"TIGER"};
       String currentValue = "";
       int i = 0;
       while (itr.hasNext()) {
           currentValue = itr.next();
           Assert.assertEquals(values[i], currentValue); i++;
       }
   }
   
   @Test
   public void testGetScoreForWords() {
       MyWordSearchGame5 myGame = new MyWordSearchGame5();
       myGame.loadLexicon("words.txt");
       SortedSet<String> mySet = myGame.getAllScorableWords(6);
       Iterator<String> itr = mySet.iterator();
       String currentValue = "";
       String[] myValues = {"ALEPOT", "BENTHAL", "PELEAN", "TOECAP"};
       int score = myGame.getScoreForWords(mySet, 6);
       Assert.assertEquals(5, score);
   }
}
