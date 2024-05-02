/*
 * 
 * 
 * Minimum Evacuation Time
You're a botanist infiltrating a secret warehouse teeming with oranges! But these aren't ordinary oranges;
 they're prone to a contagious rot that spreads like wildfire! Your mission? Determine the minimum time it takes to rot all 
 oranges before which you will have to act.

You're presented with a grid representing the warehouse (array grid). Each cell holds an integer: 0: Empty space 1:
 Fresh orange (ripe for the picking) 2: Rotten orange (spreading the contagion) Every minute, any fresh orange adjacent 
 (up, down, left, right) to a rotten one succumbs to the rot itself. Your mission is to find the minimum number of minutes
  it takes for all fresh oranges to rot. If it is impossible for all the oranges to rot then return -1.

Input/Output Format:
Input:
A nested array grid representing the warehouse layout, where each cell contains an integer (0, 1, or 2).

Output:
A single integer indicating the minimum time it takes to rot all oranges or -1 if it is impossible to rot all fresh oranges.

Examples:
Input:
[[2, 1, 1], [1, 1, 0], [0, 1, 1]] (Warehouse filled with both ripe and rotten oranges)

Output:
4 (It takes 4 minutes for all oranges to rot.)

Input:
[[2, 1, 1], [0, 1, 1], [1, 0, 1]] (Another warehouse layout)

Output:
-1 (The left bottom orange will never rot thus the output is -1)

Input:
[[0, 2]] (A small warehouse with no fresh oranges)

Output:
0 (Since there are no fresh oranges to begin with, the evacuation time is instantly completed.)

Constraints:
1 <= m (number of rows in the warehouse) <= 10
1 <= n (number of columns in the warehouse) <= 10
Each cell in grid can only hold 0, 1, or 2.


TODO
 */
package Graphs;

import java.util.*;

public class MinimumEvacTIme {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    public int MinimumEvacuationTime(int[][] grid) {
        //Write your code here
        int start = -1;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[i].length; j++){
                int current = i * j;
                if(grid[i][j] == 2)
                    start = current;
                boolean zero = true;
                List<Integer> temp = new ArrayList<>();
                if(i + 1 < grid.length){
                    temp.add((i + 1) * j);
                    if(grid[i + 1][j] != 0)
                        zero = false;
                }
                if(i - 1 >= 0){
                    temp.add((i - 1 )* j);
                    if(grid[i - 1][j] != 0)
                        zero = false;
                }
                if(j + 1 < grid[i].length){
                    temp.add(i * (j + 1));
                    if(grid[i][j + 1] != 0)
                        zero = false;
                }
                if(j - 1 < grid[i].length){
                    temp.add(i * (j - 1));
                    if(grid[i][j - 1] != 0)
                        zero = false;
                }

                if(zero)
                    return -1;

                graph.put(current, temp);
            }
        }

        int size = grid.length * grid[0].length;
        int i = 0;

        boolean[] visited = new boolean[size];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (q.isEmpty()) {
            int val = q.poll();
            List<Integer> neighbours = graph.get(val);

        }
  
    }
}
