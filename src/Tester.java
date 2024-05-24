import java.util.*;

import Graphs.ConnectedComponents;


public class Tester {

    public static void main(String[] args) {
         int[][] graph = new int[4][];
         graph[0] = new int[]{0,1};
         graph[1] = new int[]{0,2};
         graph[2] = new int[]{1,2};
         graph[3] = new int[]{3,4};


        ConnectedComponents connectedComponents = new ConnectedComponents();
        System.out.println(connectedComponents.countCompleteComponents(6, graph));
        // FindEventualSafeStates find = new FindEventualSafeStates();
        // find.eventualSafeNodes(graph);
        // NumberOfProvinces num = new NumberOfProvinces();

        // System.out.println(num.findCircleNum(graph));

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        list.add(temp);
        temp = new ArrayList<>(); 
        temp.add(0);
        temp.add(2);
        list.add(temp);
        temp = new ArrayList<>(); 
        temp.add(2);
        temp.add(5);
        list.add(temp);
        temp = new ArrayList<>(); 
        temp.add(3);
        temp.add(4);
        list.add(temp);
        temp = new ArrayList<>(); 
        temp.add(4);
        temp.add(2);
        list.add(temp);
        temp = new ArrayList<>(); 

   
    }    

}
