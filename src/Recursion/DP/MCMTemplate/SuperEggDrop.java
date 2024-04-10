/*
 * 887 Super Egg Drop
 * https://leetcode.com/problems/super-egg-drop/description/
 * 
 * You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break,
 and any egg dropped at or below floor f will not break.

Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, 
you can no longer use it. However, if the egg does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.

 

Example 1:

Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.
Example 2:

Input: k = 2, n = 6
Output: 3
Example 3:

Input: k = 3, n = 14
Output: 4
 

Constraints:

1 <= k <= 100
1 <= n <= 104
 */

package Recursion.DP.MCMTemplate;

public class SuperEggDrop {


    public int superEggDrop(int k, int n) {
        int[][] memo = new int[k+1][n+1];
        for(int i = 0; i < memo.length;i++)
         for(int j =0;j<memo[i].length;j++)
             memo[i][j] =-1;
         return helper(k,n,memo); 
     }
 
     public int helper(int k , int n, int[][] memo){
        //If only 1 egg, traverse all floors, hence ans = n
          if( k == 1)
             return n;

        //if no floors or 1 floor, return n
         if(n == 0 || n == 1)
             return n;
        //If already traversed, return
         if(memo[k][n] != -1)
             return memo[k][n];

        //Since we need to find minimum floor which will break the egg, we set ans as max
         int ans = Integer.MAX_VALUE;
         int i = 1;
         int j = n;
         //Traverse from 1 to n, and we assume either mid can break the egg or not, hence we maximise the traversal in each half and then find the min of it
         while(i <= j){
            int mid = (i + j)/2;
            int temp1=helper(k - 1, mid - 1, memo);int temp2=helper(k, n - mid , memo);
            int temp = 1 + Math.max(temp1,temp2);
            //if temp1 is less than temp2, meaning threshold is not in lower half, we increment i to mid + 1
            if(temp1 < temp2)
                i = mid + 1;
            //else threshold is in bottom half, so we make j less than mid floor
            else
                j = mid - 1;
            if(temp < ans)
                ans = temp;
         }
         memo[k][n] = ans;
         return ans;
     }
 }

