/*
 * 
 * 
 * Check if there exists a path between two nodes
 * if yes, return true
 * else return false
 */

package Graphs.CRUD;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ExistsPathBetweenTwoNodes {
    public boolean path_exists(List<List<Integer>> graph, int src, int des){
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        boolean[] visited = new boolean[graph.size()];
        visited[src] = true;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if(u == des)
                return true;
            for(int v: graph.get(u)){
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


    //The below code gives if path exists and also the path itself
    public List<Integer> get_path(List<List<Integer>> graph, int src, int des){
        boolean[] visited = new boolean[graph.size()];
        List<Integer> ans = new ArrayList<>();
        return_path_dfs(graph, src, des, visited, ans);
        return ans;
    }

    public boolean return_path_dfs(List<List<Integer>> graph, int src, int des, boolean[] visited, List<Integer> ans){
        ans.add(src);
        visited[src] = true;
        if(src == des)
            return true;
        for(int v : graph.get(src)){
            if(!visited[v]){
                if(return_path_dfs(graph, v, des, visited, ans))
                    return true;
            }
        }
        ans.remove(ans.size() - 1);
        return false;
    }

    //Path using BFS
    public List<Integer> path_BFS(List<List<Integer>> graph, int src, int des){
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        int[] parent = new int[graph.size()];
        int[] level = new int[graph.size()];
        int cur = 1;
        visited[src] = true;
        parent[src] = -1;
        level[src] = cur - 1;

        q.add(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for(int v : graph.get(u)){
                if(!visited[v]){
                    q.add(v);
                    visited[v] = true;
                    parent[v] = u;
                    level[v] = cur;
                }
            }
            cur++;
        }
        while (des != -1) {
            ans.add(des);
            des = parent[des];
        }

        return ans;
    }
}
