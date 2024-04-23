import java.util.Vector;

import HeyCoach.SessionTest.GoldRush;
import HeyCoach.SessionTest.LevelTest.BoardFilling;
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
        GoldRush goldRush = new GoldRush();
        Vector<Integer> vector = new Vector<>();
        vector.add(3);
        vector.add(1);
        vector.add(6);
        vector.add(6);
        vector.add(3);
        vector.add(6);

        int[] num = new int[]{3,1,6,6,3,6};
        System.out.println(goldRush.goldRush(num));
    }
}
