import java.util.List;
import java.util.Vector;

import HeyCoach.SessionTest.GoldRush;
import HeyCoach.SessionTest.LevelTest.BoardFilling;
import HeyCoach.SessionTest.LevelTest.RemoveKDigits;
import HeyCoach.SessionTest.LevelTest.Removeduplicates;
import Strings.GroupAnagrams;
import Strings.ValidPalindrome;

public class Tester {

    public static void main(String[] args) {
          String str = "bcabc";
          Removeduplicates removeduplicates = new Removeduplicates();
          System.out.println(removeduplicates.removeDuplicateLetters(str));
      }
}
