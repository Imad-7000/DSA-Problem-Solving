/*
 * 
 * 
 * Code to check if cycle exist in directed or undirected graph
 * 
 */
package Graphs.CRUD;
import java.util.*;
public class HasCycle {
    public boolean hasCycle(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        for(int i = 0; i < graph.size();i++){
            if(!visited[i])
                if(hasCycleUndirected(graph, visited, i, -1))
                    return true;
        }
        return false;
    }

    public boolean hasCycleUndirected(List<List<Integer>> graph, boolean[] visited, int src, int parent){
        visited[src] = true;

        for(int v : graph.get(src)){
            if(!visited[v])
                return hasCycleUndirected(graph, visited, v, src);
            else if(v != parent)
                return true;
        }
        return false;
    }

    public boolean hasCycleD(List<List<Integer>> graph){
        boolean[] visited = new boolean[graph.size()];
        boolean[] rec_stack = new boolean[graph.size()];

        for(int i = 0; i < graph.size(); i++){
            if(!visited[i])
                if(hasCycleDirected(graph, visited, i, rec_stack))
                    return true;
        }
        return false;
    }

    public boolean hasCycleDirected(List<List<Integer>> graph, boolean[] visited, int src, boolean[] rec_stack){
        visited[src] = true;
        rec_stack[src] = true;

        for(int v : graph.get(src)){
            if(!visited[v]){
                if(hasCycleDirected(graph, visited, v, rec_stack))
                    return true;
            }
            else if(rec_stack[v])
                return true;
        }
        rec_stack[src] = false;
        return false;
    }
}
