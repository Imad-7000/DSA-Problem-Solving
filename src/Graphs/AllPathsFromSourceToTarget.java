/*
 * 
 * 
 * 797. All Paths from Source To Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 * 
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 

Constraints:

n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
All the elements of graph[i] are unique.
The input graph is guaranteed to be a DAG.
 */

package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans =  new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        all_paths(graph, 0, graph.length - 1, visited, new ArrayList<>(), ans );
        return ans;    
    }

    public static void all_paths(int[][] graph, int src, int des, boolean[] visited, List<Integer> temp,  List<List<Integer>> ans ){
        temp.add(src);
        visited[src] = true;

        if(src == des){
            ans.add(new ArrayList<>(temp));
        }

        if(graph[src] != null){
        for(int i = 0 ; i < graph[src].length; i++){
            int v = graph[src][i];
            if(!visited[v]){
                all_paths(graph, v, des, visited, temp,ans);
            }
        }
    }
        visited[src] = false;
        temp.remove(temp.size() - 1);
    }
}
