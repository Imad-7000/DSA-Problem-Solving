import java.util.*;

import HeyCoach.SessionTest.LevelTest.UniqueSubsequence;

public class Tester {

    public static void main(String[] args) {
      
        String s = "abc";
        UniqueSubsequence u = new UniqueSubsequence();
        System.out.println(u.distinctSubseqII(s));

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
