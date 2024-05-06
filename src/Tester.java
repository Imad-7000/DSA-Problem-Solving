import java.util.*;

import Graphs.MinimumNumberOfVertices;
import Graphs.NumberOfProvinces;
import Graphs.WordSearch;
import LinkedList.SplitlinkedListInParts;
import Recursion.DP.CountandSay;
import Recursion.DP.KnapsackTemplate.SubArrayWithKdifferentIntegers;

public class Tester {

    public static void main(String[] args) {
        // int[][] graph = new int[4][];
        // graph[0] = new int[]{1,0,0,1};
        // graph[1] = new int[]{0,1,1,0};
        // graph[2] = new int[]{0,1,1,1};
        // graph[3] = new int[]{1,0,1,1};

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

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCESEEEFS"));
    }    

}
