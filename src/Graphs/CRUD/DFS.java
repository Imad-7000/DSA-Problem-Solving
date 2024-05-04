package Graphs.CRUD;

import java.util.*;

public class DFS {

    public void dfs_list(List<List<Integer>> adj_list){
        int n = adj_list.size();
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visitDFS(adj_list, visited, i);
            }
        }
    }

    public void visitDFS(List<List<Integer>> graph, boolean[] visited, int current){
        Stack<Integer> stack = new Stack<>();

        stack.push(current);
        visited[current] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            System.out.print(cur + " ");
            for(int v : graph.get(cur)){
                if(!visited[v]){
                    stack.push(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();
    }

    public void dfs_matrix(int[][] adj_matrix){
        int n = adj_matrix.length;
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visitDFSMatrix(adj_matrix, visited, i);
            }
        }
    }

    public void visitDFSMatrix(int[][] graph, boolean[] visited, int current){
        Stack<Integer> stack = new Stack<>();

        stack.push(current);
        visited[current] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            System.out.print(cur + " ");
            for(int v = 0; v < graph.length; v++){
                if(graph[cur][v] == 1 && !visited[v]){
                    stack.push(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println();
    }
}
