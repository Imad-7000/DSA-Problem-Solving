/*
 * 
 * 
 * MIN TAX PAID_II
Given a n x n grid filled with non-negative numbers, A explorer is at top left cell and he has to find a path from top left to bottom right, 
but there is a condition he has to pay an amount equal to the cell if he choose to include a particular cell in his path, suggest a falling path 
which minimizes the money paid by the explorer. The explorer can move down, right or diagonally down.

Example

Input:
3 3
1 2 3
4 5 6
7 8 9
Output:
15

Explanation:
The explorer will start from matrix[0][0] that is from 1 then move to 5 then finally to 9 which is at matrix[n-1][n-1]. 
The total cost is 16 which is the minimum possible achievable.

Constraints:
n == matrix.length == matrix[i].length

1 <= n <= 100

-100 <= matrix[i][j] <= 100
 */
package Recursion.DP;

import java.util.Arrays;

public class MinTaxPaid2 {
    private int[][] memo;
    private int[][] grid;
    private int n;

    public int solve(int[][] ar, int m, int n) {
        this.n = n;
        this.grid = ar;
        this.memo = new int[m][n];

        // Initialize memoization table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return minPathSumHelper(0, 0);
    }

    private int minPathSumHelper(int i, int j) {
        // Check if out of bounds
        if (i >= n || j >= n) {
            return Integer.MAX_VALUE;
        }

        // Check if we reached the destination
        if (i == n - 1 && j == n - 1) {
            return grid[i][j];
        }

        // Check if the value is already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Recursive calculation
        int right = minPathSumHelper(i, j + 1);
        int down = minPathSumHelper(i + 1, j);
        int diagonal = minPathSumHelper(i + 1, j + 1);

        // Memoize and return the result
        memo[i][j] = grid[i][j] + Math.min(right, Math.min(down, diagonal));
        return memo[i][j];
    }
}
