/*
 * 
 * BFS on a graph
 */

package Graphs.CRUD;

import java.util.ArrayDeque;
import java.util.*;

public class BFS {
    public void bfs_list(List<List<Integer>> graph, int start){
        int n = graph.size();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] level = new int[n];
        int cur = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        parent[start] = -1;
        level[start] = cur - 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : graph.get(u)){
                if(!visited[v]){
                    parent[v] = u;
                    visited[v] = true;
                    level[v] = cur;
                }
            }
            cur++;
        }
    }
}
