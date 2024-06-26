/*
 * 
 * 63. Unique Paths 2
 * https://leetcode.com/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 *  The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 * The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square 
that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */
package Recursion.DP;

public class UniquePaths2 {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m + 1][n + 1];
        for(int i = 0 ; i < memo.length; i++){
            for(int j = 0 ; j < memo[i].length; j++)
                memo[i][j] = -1;
        }

        return uniquePaths(obstacleGrid, 0, 0);
    }

    public int uniquePaths(int[][] obstacleGrid, int i, int j){
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1 && obstacleGrid[i][j] == 0)
            return 1;
        if(obstacleGrid[i][j] == 1)
            return 0;
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length)
            return 0;
        if(memo[i][j] != -1)
            return memo[i][j];
        
        int right = uniquePaths(obstacleGrid, i, j + 1);
        int down = uniquePaths(obstacleGrid, i + 1, j);

        return memo[i][j] = right + down;

    }
}
