/*
 * 1192. Critical Connections
 * https://leetcode.com/problems/critical-connections-in-a-network/description/
 * 
 * 
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi]
 *  represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
 * 
 * 
 */
package Graphs;

import java.util.*;

public class CriticalConnections {
    List<List<Integer>> bridges = new ArrayList<>();
     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] ids = new int[n];
        int[] low = new int[n];
        int id = 0;

        for (int i = 0; i < graph.length; i++) 
            graph[i] = new ArrayList<>();

        for (int i = 0; i < connections.size(); i++) {
            int a = connections.get(i).get(0), b = connections.get(i).get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, visited,-1,0,ids,id,low);
        return bridges;
    }
    public void dfs(ArrayList<Integer>[] graph, boolean[] visited, int parent, int i, int[] ids, int id, int[] low) {
        visited[i] = true; 
        ids[i] = low[i] = id++;
        
        for (int node : graph[i]) {
            if (node == parent) continue;
            if (!visited[node]) {
                dfs(graph, visited, i, node, ids, id,low);
				
				//things below happen during backtracking
                low[i] = Math.min(low[i], low[node]);   
                if (ids[i] < low[node]) 
                    bridges.add(Arrays.asList(i, node));
            } else {
                low[i] = Math.min(low[i], ids[node]);
            }
        }
    }
}
