import java.util.ArrayList;
import java.util.List;

import Graphs.CRUD.CreateGraph;
import HeyCoach.SessionTest.LevelTest.Removeduplicates;
public class Tester {

    public static void main(String[] args) {
        int[][] graph = new int[4][];
        graph[0] = new int[]{1,2};
        graph[1] = new int[]{3};
        graph[2] = new int[]{3};

        List<List<Integer>> t = allPathsSourceTarget(graph);
        for(int i = 0 ; i < t.size(); i++){
            for(int j = 0 ; j < t.get(i).size(); j++){
                System.out.print(t.get(i).get(j) + "    ");
            }
            System.out.println();
        }

    }
     
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
            ans.add(temp);
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
