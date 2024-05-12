import java.util.*;

import Arrays.Candy;
import Graphs.FindEventualSafeStates;
import Graphs.MinimumNumberOfVertices;
import Graphs.NumberOfProvinces;
import Graphs.WordSearch;
import LinkedList.SplitlinkedListInParts;
import Recursion.DP.CountandSay;
import Recursion.DP.KnapsackTemplate.SubArrayWithKdifferentIntegers;

public class Tester {

    public static void main(String[] args) {
         int[][] graph = new int[7][];
         graph[0] = new int[]{1,2};
         graph[1] = new int[]{2,3};
         graph[2] = new int[]{5};
         graph[3] = new int[]{0};
         graph[4] = new int[]{5};
         graph[5] = new int[]{};
         graph[6] = new int[]{};

        FindEventualSafeStates find = new FindEventualSafeStates();
        find.eventualSafeNodes(graph);
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

        char[][] board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','E','S'};
        board[2] = new char[]{'A','D','E','E'};

        // WordSearch wordSearch = new WordSearch();
        // System.out.println(wordSearch.exist(board, "ABCESEEEFS"));

        // int[] num = new int[]{1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4};
        // Candy candy = new Candy();
        // System.out.println(candy.candy(num));
    }    

}
