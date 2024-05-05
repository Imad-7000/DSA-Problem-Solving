/*
 * 
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description
 * 
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.


INTUITION : Use the concept of DFS ON GRID

 */

package Graphs;

import java.util.Stack;

public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfsOnGrid(grid, visited, i, j);
                }
            }
        }
        return count;
    }


    public void dfsOnGrid(char[][] grid,boolean[][] visited, int i , int j){
        visited[i][j] = true;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        while (!stack.isEmpty()) {
            int[] u = stack.pop();
            int row = u[0];
            int col = u[1];
            if(row + 1 < grid.length){
                if(grid[row + 1][col] == '1' && !visited[row + 1][col]){
                    visited[row + 1][col] = true;
                    stack.push(new int[]{row + 1, col});
                }
            }
            if(row - 1 >= 0){
                if(grid[row - 1][col] == '1' && !visited[row - 1][col]){
                    stack.push(new int[]{row - 1, col});
                    visited[row - 1][col] = true;
                }
            }
            if(col + 1 < grid[0].length){
                if(grid[row][col + 1] == '1' && !visited[row][col + 1]){
                    stack.push(new int[]{row, col + 1});
                    visited[row][col + 1] = true;
                }
            }
            if(col - 1 >= 0){
                if(grid[row][col - 1] == '1' && !visited[row][col - 1]){
                    stack.push(new int[]{row, col - 1});
                    visited[row][col - 1] = true;
                }
            }
        }
    }
}
