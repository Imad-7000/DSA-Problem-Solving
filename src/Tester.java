import java.util.ArrayList;

import Recursion.*;
import Strings.*;
public class Tester {

    public static void main(String[] args) {
    //     int[] nums = new int[]{5,5};
    //    System.out.println(Recursion.DP.KnapsackTemplate.PartitionEqualSum.canPartition(nums));
        // String s1 = "catsandog";
        // ArrayList<String> list = new ArrayList<>();
        // list.add("cats");
        // list.add("dog");
        // list.add("sand");
        // list.add("and");
        // list.add("cat");

        // System.out.println(Recursion.DP.WordBreak.wordBreak(s1, list));

        int[] startTime = new int[]{1,2,3,3};
        int[] endTime = new int[]{3,4,5,6};
        int[] profit = new int[]{50,10,40,70};

        System.out.println(Recursion.DP.MaximumProfitJobScheduling.jobScheduling(startTime, endTime, profit));
    }
}
