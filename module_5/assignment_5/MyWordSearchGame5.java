import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.SortedSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

public class MyWordSearchGame5 implements WordSearchGame {
    // Fields
    private TreeSet<String> lexicon;
    private boolean isFound;
    private String[] board;
    private int boardDim;
    private int boardTwoDim;
    private boolean[] visited;
    private StringBuilder wordSoFar;
    private List<Integer> path;
    private TreeSet<String> wordLengthLexicon;
    private String filePath;
    

    /**
    * Constructor for this class
    */
    public MyWordSearchGame5() {
        this.lexicon = new TreeSet<>();
        this.board = new String[]{"E", "E", "C", "A", "A", "L", "E", "P",
                      "H", "N", "B", "O", "Q", "T", "T", "Y"};
        this.boardDim = board.length;
        this.boardTwoDim = (int) Math.sqrt(this.boardDim);
        this.visited = new boolean[boardDim];
        this.wordSoFar = new StringBuilder();
        this.wordLengthLexicon = new TreeSet<>(byWordLength());
        this.isFound = false;
    }
    
    /**
     * Loads the lexicon into a data structure for later use. 
     * 
     * @param fileName A string containing the name of the file to be opened.
     * @throws IllegalArgumentException if fileName is null
     * @throws IllegalArgumentException if fileName cannot be opened.
     */   
     public void loadLexicon(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.filePath = filePath;
            File infile = new File(filePath);
            Scanner scan = new Scanner(infile);
            while (scan.hasNext()) {
                String str = scan.next();
                str = str.toUpperCase();
                this.lexicon.add(str);
                this.wordLengthLexicon.add(str);
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }
        
    
    /**
     * Determines if the given word is in the lexicon.
     * 
     * @param wordToCheck The word to validate
     * @return true if wordToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public boolean isValidWord(String wordToCheck) {
        if (lexicon.isEmpty()) {
           throw new IllegalStateException();
        }
        
        if (wordToCheck == null) {
            throw new IllegalArgumentException();
        }
        
        return this.lexicon.contains(wordToCheck.toUpperCase());        
    }
    
    /**
     * Determines if there is at least one word in the lexicon with the 
     * given prefix.
     * 
     * @param prefixToCheck The prefix to validate
     * @return true if prefixToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if prefixToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public boolean isValidPrefix(String prefixToCheck) {
       if (prefixToCheck == null) {
          throw new IllegalArgumentException();
       }
       
       if (lexicon.isEmpty()) {
           throw new IllegalStateException();
       }
    
       String ceilingWord = this.lexicon.ceiling(prefixToCheck.toUpperCase());
           
       return ceilingWord.startsWith(prefixToCheck.toUpperCase());
    }
    
    /**
     * Determines if the given word is in on the game board. If so, it returns
     * the path that makes up the word.
     * @param wordToCheck The word to validate
     * @return java.util.List containing java.lang.Integer objects with  the path
     *     that makes up the word on the game board. If word is not on the game
     *     board, return an empty list. Positions on the board are numbered from zero
     *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
     *     board, the upper left position is numbered 0 and the lower right position
     *     is numbered N^2 - 1.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public List<Integer> isOnBoard(String wordToCheck) {
        if (wordToCheck == null) {
            throw new IllegalArgumentException();
        }
        
        if (this.lexicon.isEmpty()) {
            throw new IllegalStateException();
        }
    
        this.isFound = false;
        this.allPointsUnvisited();
        this.path = new ArrayList<>();
        this.wordSoFar = new StringBuilder();
        String characterOnBoard = "";
        outerloop:
        for (int i = 0; i < this.boardTwoDim; i++) {
            for (int j = 0; j < this.boardTwoDim; j++) {
                characterOnBoard = this.board[offset(i, j)];
                if (wordToCheck.startsWith(characterOnBoard)) {
                    if (dfsOneWord(i, j, wordToCheck, this.wordSoFar, this.path)) break outerloop;
                }
            }
        }        
        return this.path;
    }
    
    /**
     * Computes the cummulative score for the scorable words in the given set.
     * To be scorable, a word must (1) have at least the minimum number of characters,
     * (2) be in the lexicon, and (3) be on the board. Each scorable word is
     * awarded one point for the minimum number of characters, and one point for
     * each character beyond the minimum number.
     *
     * @param words The set of words that are to be scored.
     * @param minimumWordLength The minimum number of characters required per word
     * @return the cummulative score of all scorable words in the set
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
        if (minimumWordLength < 1) {
            throw new IllegalArgumentException();
        }
        
        if (this.lexicon.isEmpty()) {
            throw new IllegalStateException();
        }
    
        List<String> wordsToScore = new ArrayList<>();
    
        for (String element : words) {
            if (this.isOnBoard(element).size() > 0) {
                wordsToScore.add(element);
            }
        }  
        Iterator<String> itr = wordsToScore.iterator();
        String currentVar = "";
        int runningScore = 0;
        
        while (itr.hasNext()) {
            currentVar = itr.next();
            runningScore += this.getScore(currentVar, minimumWordLength);
        }
        return runningScore;
    }
    
    /**
     * Retrieves all scorable words on the game board, according to the stated game
     * rules.
     *
     * @param minimumWordLength The minimum allowed length (i.e., number of
     *     characters) for any word found on the board.
     * @return java.util.SortedSet which contains all the words of minimum length
     *     found on the game board and in the lexicon.
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public SortedSet<String> getAllScorableWords(int minimumWordLength) {
        if (minimumWordLength < 1) {
            throw new IllegalArgumentException();
        }
        
        if (this.lexicon.isEmpty()) {
            throw new IllegalStateException();
        }
        SortedSet<String> wordSetToReturn = new TreeSet<>();
        String lowerString = generateLowerString(minimumWordLength);
        String lowerBound = this.wordLengthLexicon.ceiling(lowerString);
        SortedSet<String> subset = this.wordLengthLexicon.tailSet(lowerBound);
        Iterator<String> itrWL = subset.iterator();
        String currentVar = "";
        while (itrWL.hasNext()) {
            currentVar = itrWL.next().toUpperCase();
            this.isOnBoard(currentVar);
            if (this.isFound) {
                wordSetToReturn.add(currentVar);
            }
        }
        return wordSetToReturn;
    }
    
    /**
     * Stores the incoming array of Strings in a data structure that will make
     * it convenient to find words.
     *
     * @param letterArray This array of length N^2 stores the contents of the
     *     game board in row-major order. Thus, index 0 stores the contents of board
     *     position (0,0) and index length-1 stores the contents of board position
     *     (N-1,N-1). Note that the board must be square and that the strings inside
     *     may be longer than one character.
     * @throws IllegalArgumentException if letterArray is null, or is  not
     *     square.
     */
    public void setBoard(String[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        
        if (!this.isPerfectSquare((double) arr.length)) {
            throw new IllegalArgumentException();
        }
        
        boolean[] newBooleanBoard = new boolean[arr.length];
        String[] tempBoard = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempBoard[i] = arr[i].toUpperCase();
        }
        this.board = Arrays.copyOf(tempBoard, arr.length);
        this.visited = Arrays.copyOf(newBooleanBoard, arr.length);
        this.boardDim = board.length;
        this.boardTwoDim = (int) Math.sqrt(this.boardDim);
    }
    
    /**
     * Creates a String representation of the board, suitable for printing to
     *   standard out. Note that this method can always be called since
     *   implementing classes should have a default board.
     */
    public String getBoard() {
        String result = "";
        for (int i = 0; i < this.board.length; i++) {
            result += this.board[i] + " ";
        }
        return result.trim();
    }
    
    public boolean[] getVisited() {
        return this.visited;
    }
    
    /**
    * This method implements depth-first-search recursively by searching
    *    for a given word on a word boggle board.
    *
    * @param i - the x-poisition on the board.
    * @param j - the y-position on the board.
    * @param wordToCheck - the word to look for on the boggle board.
    * @param wordSoFar - the currently word that is constructed at
    *    current position on the board.
    * @param path - the path along the board traversed to construct the word
    * @boolean true/false - whether or not the word was found on the boggle board.
    */
    private boolean dfsOneWord(int i, int j, String wordToCheck,
                               StringBuilder wordSoFar, List<Integer> path) {
                               
        // Is the x-position on the board?
        if (i >= this.boardTwoDim || i < 0) {
            return false;
        }
        
        // Is the y-position on the board?
        if (j >= this.boardTwoDim || j < 0) {
            return false;
        }
        
        // Have we visited this location before?
        if (this.visited[offset(i, j)]) {
            return false;
        }
        
        // Is the word built up to this point a prefix to the word
        //    we're looking for
        if (!wordToCheck.startsWith(this.wordSoFar.toString())) {
            return false;
        }
        
        // Mark the position on the board as visited
        this.visited[offset(i, j)] = true;
        
        // add the contents of the current position word built up so far
        this.wordSoFar.append(this.board[offset(i, j)]);
        
        // Add the current position to the path
        this.path.add(offset(i, j));
                
        // If the word is now found, return true and indicate that the word is found
        if (this.wordSoFar.toString().compareTo(wordToCheck) == 0) {
            this.isFound = true;
            return true;
        }
        
        // Check if the neighbor above
        if (dfsOneWord(i - 1, j, wordToCheck, this.wordSoFar, this.path)) {
           return true;
        }
        
        // Check the neighbor diagonally upwards and to the right
        if (dfsOneWord(i - 1, j + 1, wordToCheck, this.wordSoFar, this.path)) {
            return true;
        }
        
        // Check the neighbor to the right
        if (dfsOneWord(i, j + 1, wordToCheck, this.wordSoFar, this.path)) {
            return true;
        }
        
        // Check the neighbor diagonally down and to the right
        if (dfsOneWord(i + 1, j + 1, wordToCheck, this.wordSoFar, this.path)) {
            return true;
         }
         
        // Check the neighbord directly down
        if (dfsOneWord(i + 1, j, wordToCheck, this.wordSoFar, this.path)) {
            return true;
        }
        
        // Check the neighbor diagonally down and to the left
        if (dfsOneWord(i + 1, j - 1, wordToCheck, this.wordSoFar, this.path)) {
            return true;
        }
        
        // Check the neighbor to the left
        if (dfsOneWord(i, j - 1, wordToCheck, this.wordSoFar, this.path)) {
            return true;
        }
        
        // Check the neighbord diagonally up and to the left
        if (dfsOneWord(i - 1, j - 1, wordToCheck, this.wordSoFar, this.path)) {
            return true;
        }
        
        // The word is not found, so mark this position on not visited.
        this.visited[offset(i, j)] = false;
        
        // Remove it's position from the path
        this.path.remove(this.path.size() - 1);
        
        // Calculate the difference in the character length before and after
        //    the previous character was added
        int lengthBefore = this.wordSoFar.length() - this.board[offset(i, j)].length();
        int lengthNow = this.wordSoFar.length();
        
        // Remove the previous added characters from our word under construction
        if (this.wordSoFar.length() > 0) {
            this.wordSoFar.delete(lengthBefore, lengthNow);
        }
        return false;
    }
    
    /**
    * This method determines if the input is a perfect square
    *
    * @param x - the value in question
    * @return true/false - whether or not x is a perfect square or not
    */
    private boolean isPerfectSquare(double x) {
        double sq = Math.sqrt(x);
        return (sq - Math.floor(sq) == 0);
    }
    
    /**
    * This method calculates the index of an element in 2D matrix/array in a
    *    flattened (1D) array
    * @param i - the row index
    * @param j - the column index
    * @return the flattened index
    */
    private int offset(int i, int j) {
        return i * this.boardTwoDim + j;
    }
    
    /**
    * Marks all the points on the boggle board as unvisited. This
    *    is a service method for the depth-first-search method
    */
    private void allPointsUnvisited() {
        for (int i = 0; i < boardDim; i++) {
            visited[i] = false;
        }
    }
    
    /**
    * This method generates a lower bound for a string of a
    *    particular length using the comparator in this class
    *
    * @param length - the length of the string to generate a
    *    lower bound for
    */
    private static String generateLowerString(int length) {
        String result = "";
        for (int i = 0; i < length - 1; i++) {
            result += "Z";
        }
        return result;
    }
    
    /**
    * This method calculates the score for words on the boggle board
    *
    * @param wordIn - the word to calculate a score for
    * @param minimumLengthIn - the minimum length of the word according
    *    to the rules of boggle
    * @return the score of the word given the minimum length
    */
    private static int getScore(String wordIn, int minimumLengthIn) {
        if (wordIn.length() < minimumLengthIn) {
            return 0;
        }
        
        return 1 + (wordIn.length() - minimumLengthIn);
    }
   
   /**
   * This method returns a comparator<String> used to order the strings
   *    in a red-black tree
   */
   public static Comparator<String> byWordLength() {
      return new ComparatorWordLength(); 
   }
    
   /**
   * This is a comparator that orders strings by (1) their length and then (2) their
   *    lexographic order
   */
   private static class ComparatorWordLength implements Comparator<String> {
      @Override
      public int compare(String string1, String string2) {
            int thisLength = string1.length();
            int thatLength = string2.length();
            if (thisLength > thatLength) {
                return 1;
            } else if (thisLength < thatLength) {
                return -1;
            } else {
                return string1.compareTo(string2);
            }
      }
   }
}
