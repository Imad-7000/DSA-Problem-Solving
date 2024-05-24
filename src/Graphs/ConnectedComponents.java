/*
 * 2685. Count the Number of Connected Components
 * https://leetcode.com/problems/count-the-number-of-complete-components/description/
 * 
 * 
 * You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. 
 * You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, 
and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

 

Example 1:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all of the components of this graph are complete.
Example 2:



Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an edge between every pair of two vertices. 
On the other hand, the component containing vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5. 
Thus, the number of complete components in this graph is 1.
 

Constraints:

1 <= n <= 50
0 <= edges.length <= n * (n - 1) / 2
edges[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
There are no repeated edges.
 */
package Graphs;

import java.util.*;

public class ConnectedComponents {
    int count = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;
        boolean[] visited = new boolean[graph.size()];
        for(int i = 0; i < graph.size(); i++){
            HashSet<Integer> vertices = new HashSet<>();
            if(!visited[i]){
                dfs(graph, visited, vertices, i);

            if(isConnectedComponent(graph, vertices))
                count++;
            }
        }

        return count;
    }

    public boolean isConnectedComponent(List<List<Integer>> graph, HashSet<Integer> vertices){
        int edges = 0;
        int n = vertices.size();
        for(int v : vertices){
            edges += graph.get(v).size();
        }
        edges = edges/2;
        return (edges == n * (n - 1)/2);
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, HashSet<Integer> vertices, int src){
        visited[src] = true;
        vertices.add(src);
        for(int v : graph.get(src)){
            if(!visited[v])
                dfs(graph, visited, vertices, v);
        }
    }
}
