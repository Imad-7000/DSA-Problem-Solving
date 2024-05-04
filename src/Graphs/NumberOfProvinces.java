/*
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/
 * 
 * 
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 *  and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected,
 and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

package Graphs;

import java.util.Stack;

public class NumberOfProvinces {
    int count = 0;
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                findConn(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    public void findConn(int[][] graph, int start, boolean[] visited){
        visited[start] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for(int i = 0 ; i < graph[u].length; i++){
                if(graph[u][i] == 1 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}
