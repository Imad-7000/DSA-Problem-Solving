/*
    64. Minimum Path Sum

    https://leetcode.com/problems/minimum-path-sum/description/
 * 
 * Given a m x n grid filled with non-negative numbers,
 *  find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */

package Recursion.DP;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[0].length; j++)
                memo[i][j] = -1;
        return grid(grid, grid.length - 1, grid[0].length - 1,memo );
    }

    public int grid(int[][] grid, int m,int n, int[][] memo){
        if(m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if(m == 0 && n == 0)
            return grid[m][n];
        if(memo[m][n] != -1)
            return memo[m][n];
        memo[m][n] = grid[m][n] + Math.min(grid(grid, m - 1, n,memo),grid(grid, m, n - 1,memo));
        return memo[m][n];
    }
}