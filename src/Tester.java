import java.util.*;

import HeyCoach.SessionTest.LevelTest.UniqueSubsequence;
import Recursion.DP.GetMax;

public class Tester {

    public static void main(String[] args) {
      
        GetMax g = new GetMax();
        System.out.println(g.getMaximumGenerated(4));

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
