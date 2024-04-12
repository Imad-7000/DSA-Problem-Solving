/*
 *
 * 1235. Maximum Profit in Job Scheduling
 * 
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
 *  
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs
 in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104
 */

package Recursion.DP;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitJobScheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
     
        //Memo table 
        int[] memo = new int[startTime.length + 1];
        for(int i = 0 ; i <  memo.length; i++)
            memo[i] = -1;

        //Storing values in a 2D array with each internal array containing start,end,profit
        int[][] list = new int[startTime.length][3];
        for(int i = 0 ; i  < startTime.length; i++){
           int[] arr = new int[3];
           arr[0] = startTime[i];
           arr[1] = endTime[i];
           arr[2] = profit[i];
           list[i] = arr;
        }

        //Custom Sort to sort the internal arrays based on end time
        JobComparator jobComparator = new JobComparator();
        Arrays.sort(list, jobComparator);
        return maxProfit(list, list.length - 1,memo);
    }

    //Recursive code to solve
    public static int maxProfit(int[][] arr, int n,int[] memo){
        //if n is out of bounds, return 0;
        if(n < 0)
            return 0;
        //if n was visited before, its max must be in memo
        if(memo[n] != -1)
            return memo[n];

        //We have two cases; either we pick or skip
        //if we pick, we need to find the next task that can be performed.
        //the helper func nexMinJob helps in finding which is the next array whose endTime is less or equal to current start Time
        int pick = arr[n][2];
        int nextBest = nextMinJob(arr, n);

        //If -1, then no such job, else recursively call for the next best profit
        if(nextBest != -1)
            pick += maxProfit(arr, nextBest,memo);
        //In second case, we just skip this task, trying to find a better one
        int skip = maxProfit(arr, n - 1,memo);
        // store val in memo table and return
        return memo[n] = Math.max(pick,skip);
    }

    //helper to find nextMin Job
    public static int nextMinJob(int[][] arr, int n){
        int i = n - 1;
        while(i >= 0){
            if(arr[i][1] <= arr[n][0])
                return i;
            i--;
        }
        return -1;
    }
}

//Custom sort class to sort 2D arra based on an index of internal arrays.
class JobComparator implements Comparator<int []>{
    @Override
    public int compare(int[] o1, int[]  o2) {
       return Integer.compare(o1[1],o2[1]);
    }
}
