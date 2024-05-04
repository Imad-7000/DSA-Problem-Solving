
/*
 * 
 * 
 * Class to create a graph and edges to it, both in adjacency matrix and adjacency list form 
 * For our purpose, we consider undirected unweighted graph
 *
 */
package Graphs.CRUD;
import java.util.*;
public class CreateGraph {
    int nodes;
    int edges;
    List<List<Integer>> adj_list;
    int[][] adj_matrix;

    public CreateGraph(int n, int e){
        this.nodes = n;
        this.edges = e;
        adj_list = new ArrayList<>();
        adj_matrix = new int[this.nodes][this.nodes];
        for(int i = 0 ; i < this.adj_matrix.length; i++){
            for(int j = 0; j < this.adj_matrix[i].length; j++)
                adj_matrix[i][j] = 0;
        }

        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            this.adj_list.add(list);
        }
    }

    public void add_edge(int node1, int node2){
        this.adj_matrix[node1][node2] = 1;
        this.adj_matrix[node2][node1] = 1;

        this.adj_list.get(node1).add(node2);
        this.adj_list.get(node2).add(node1);
    }

    public void print_adj_list(){
        for(int i = 0 ; i < this.adj_list.size();i++){
            System.out.print(i + " : ");
            for(int j = 0; j < this.adj_list.get(i).size(); j++){
                System.out.print(this.adj_list.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public void print_adj_matrix(){
        for(int i = 0 ; i < this.adj_matrix.length;i++){
            for(int j = 0; j < this.adj_matrix[i].length; j++){
                System.out.print(adj_matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void dfs(boolean list){

        DFS dfs = new DFS();
        if(list)
            dfs.dfs_list(adj_list);
        else
            dfs.dfs_matrix(adj_matrix);
    }

    public void bfs(boolean list){
        BFS bfsa = new BFS();
      
        bfsa.bfs_list(adj_list, 0);
        
    }
}
