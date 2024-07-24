/*
 * 
 * 
 * 
 * Grid Puzzle-II
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
  An obstacle and space are marked as 1 or 0 respectively in the grid. A path that the robot takes cannot include any square that is an obstacle. 
  Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 10^9.

Example

Input : obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]

Output: 2

Explanation: 

There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Constraints

2 <= m,n <= 500

grid contains only 0 and 1
 */
package Recursion.DP;

import java.util.Arrays;

public class Grid2 {
        private int[][] memo;
    private int[][] grid;
    private int m, n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        grid = obstacleGrid;
        memo = new int[m][n];
        
        // Initialize memoization table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return uniquePaths(0, 0);
    }

    private int uniquePaths(int i, int j) {
        // Check if out of bounds
        if (i >= m || j >= n) {
            return 0;
        }
        
        // Check if the cell is an obstacle
        if (grid[i][j] == 1) {
            return 0;
        }
        
        // Check if we reached the destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        
        // Check if the value is already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Recursive calculation
        int rightPaths = uniquePaths(i, j + 1);
        int downPaths = uniquePaths(i + 1, j);

        // Memoize and return the result
        memo[i][j] = rightPaths + downPaths;
        return memo[i][j];
    }

}
