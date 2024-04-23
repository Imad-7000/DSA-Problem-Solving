import java.util.List;
import java.util.Vector;

import HeyCoach.SessionTest.GoldRush;
import HeyCoach.SessionTest.LevelTest.BoardFilling;
import Strings.GroupAnagrams;
import Strings.ValidPalindrome;

public class Tester {

    public static void main(String[] args) {
         int[] nums = new int[]{5,5,10};
    //    System.out.println(Recursion.DP.KnapsackTemplate.PartitionEqualSum.canPartition(nums));
        // String s1 = "catsandog";
        // ArrayList<String> list = new ArrayList<>();
        // list.add("cats");
        // list.add("dog");
        // list.add("sand");
        // list.add("and");
        // list.add("cat");

        // System.out.println(Recursion.DP.WordBreak.wordBreak(s1, list));

        // int[] startTime = new int[]{1,2,3,3};
        // int[] endTime = new int[]{3,4,5,6};
        // int[] profit = new int[]{50,10,40,70};

      //  System.out.println(Recursion.DP.MaximumProfitJobScheduling.jobScheduling(startTime, endTime, profit));

        // String s1 = "abac";
        // String s2 = "cab";
        
        // String val = Recursion.DP.LCSTemplate.ShortestCommonSuperSequence.shortestCommonSupersequence(s1, s2);
        // System.out.println(val);
        //Recursion.DP.LCSTemplate.LCS.lcsMain(s1, s2);
        //System.out.println(Recursion.DP.LCSTemplate.LongestCommonSubstring.lcs(s1, s2));
        String[] str = new String[]{"atn","eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> li = groupAnagrams.groupAnagrams(str);

        for(int i = 0; i <li.size();i++){
          for(int j = 0; j < li.get(i).size(); j++){
            System.out.print(li.get(i).get(j) + "   ");
          }
          System.out.println();
        }
      }
}
