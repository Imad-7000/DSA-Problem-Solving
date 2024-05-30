/*
 * 
 * 
 * Minimum subset difference partition
Given an array arr of size n containing non-negative integers, the task is to divide it into two sets S1 and S2 such that the absolute 
difference between their sums is minimum and find the minimum difference

Example 1
Input
n = 4, arr = [1, 6, 11, 5]
Output
1
Explanation
Subset1 = {1, 5, 6}, sum of Subset1 = 12 Subset2 = {11}, sum of Subset2 = 11

Example 2:

Input:

N = 2, arr = [1, 4]
Output:

3
Input Format

The first line of input contains integer 'n' denoting the size of the array.

The second line of the input contains 'n' space-separated integers denoting the elements of the array 'arr'.
Output Format
Return the minimum possible absolute difference. 
Constraints:
1 <= arr.length <= 200
1 <=arr[i] <= 100
 * 
 * 
 */
package Recursion.DP;

import java.util.Arrays;

public class MinimumSubsetDiff {
    
    int min = Integer.MAX_VALUE;
    int[][] memo ;
    public int minDifference(int[] arr, int n) {
        //Write your code here;
        
        int right = Arrays.stream(arr).sum();

        memo = new int[arr.length + 1][right + 1];
        for(int i = 0 ; i < memo.length; i++){
            for(int j = 0; j < memo[i].length ; j++)
                memo[i][j] = -1;
        } 
        int left = 0;
        return minD(arr, 0, left, right);
      
    }

    public int minD(int[] arr, int i, int left, int right){
        if(i == arr.length)
            return Math.abs(left - right);
        if(memo[i][left] != -1)
            return memo[i][left];
        
        
            
        int pick = minD(arr, i + 1, left + arr[i], right - arr[i]);
        int skip = minD(arr, i + 1, left, right);
        
        return memo[i][left] = Math.min(pick, skip);
    }
}
