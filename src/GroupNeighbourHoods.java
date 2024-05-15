/*
 * 
 * 
 * 
 * Continuous Neighborhoods
 * 
 * 
You're the architect of Harmony Hills, a quaint utopia where neighbors strive for peaceful coexistence.
 Each resident is represented by a number (in nums) reflecting their desired level of social interaction (the larger the number, the more social).
  Your goal? Build vibrant communities within this diverse population by grouping residents into "continuous" neighborhoods where everyone feels comfortable.

You're given an array nums representing the social preferences of Harmony Hills residents (positive integers between 1 and 10^9).
A "continuous" neighborhood is a group of residents where the difference in desired social interaction between any two residents is at most 2 
(i.e., |resident1 preference - resident2 preference| <= 2). Your mission is to find the total number of possible continuous neighborhoods 
you can create within Harmony Hills. Remember, the more harmonious neighborhoods, the happier the residents!

Input/Output Format:
Input:
An array nums containing the social preferences of residents separated by spaces or commas.

Output:
Return a single integer representing the total number of possible continuous neighborhoods in Harmony Hills.

Examples:
Input:
5 4 2 4 (Resident preferences in Harmony Hills)
Output:
8 (As in the original example, there are 8 possible neighborhoods catering to everyone's social needs.)

Input:
1 2 3 (Another peaceful community)
Output:
6 (Similar to the first example, 6 neighborhoods can be formed to ensure everyone feels comfortable.)
Constraints:
1 <= n <= 10^5 (Number of residents in Harmony Hills)
1 <= nums[i] <= 10^9 (Individual resident's social preference)
 */

import java.util.Arrays;
import java.util.HashMap;

public class GroupNeighbourHoods {
    static long[][] memo;
    public static void main(String[] args) {
        
        int[] nums=  new int[]{5,4,2,4};
        System.out.println(neighbourHoods(nums));
    }
    public static long neighbourHoods(int[] nums){
        memo = new long[nums.length + 1][nums.length + 1];
        for(int i = 0 ; i < memo.length; i++)
            for(int j = 0; j < memo[i].length ; j++)
                memo[i][j] = -1;
       // Arrays.sort(nums);
        return neighborhood(nums, 0, nums.length - 1);
    }

    public static long neighborhood(int[] nums, int i , int j){
        if(i == j)
            return 0;
        if(i > j)
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];

        long ans  = Long.MIN_VALUE;

        for(int k = i; k < j; k++){
            long tempans = neighborhood(nums, i, k) + neighborhood(nums, k + 1, j);
            if(Math.abs(nums[i] - nums[k]) <= 2)
                tempans +=1;
            if(Math.abs(nums[k + 1] - nums[j]) <=2)
                tempans +=1;
            ans = Math.max(ans,tempans);
        }
        
       
        return memo[i][j] = ans;
    }

    public static int findJudge(int n, int[][] trust) { 
        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i = 0;  i < trust.length; i++){
          hash.put(trust[i][0],trust[i][1]);
        }

        int mayor = trust[0][1];
        for(int i = 0 ; i <= n; i++){
          if(i == mayor)
              return -1;
          if(hash.get(i) != mayor)
              return -1;
        }
        return mayor;
     }
}
