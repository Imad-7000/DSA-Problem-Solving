/*
 * 
 * 1971. Find if Path Exists In A Graph
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 * 
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
 * The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional 
 * edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
 */
package Graphs;
import java.util.*;
public class FindIfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph= new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            List<Integer> list= new ArrayList<>();
            graph.add(list);
        }

        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        return path_exists(graph, source, destination);
    }

    public boolean path_exists(List<List<Integer>> graph, int src, int des){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        stack.push(src);
        visited[src] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if(u == des)
                return true;
            
            for(int v : graph.get(u)){
                if(!visited[v]){
                    stack.push(v);
                    visited[v] = true;
                    if(v == des)
                        return true;
                }
            }
        }
        return false;
    }
}
