import java.util.*;

import Graphs.CityWithSmallestNeighbours;
import HeyCoach.SessionTest.LevelTest.UniqueSubsequence;
import Recursion.DP.GetMax;

public class Tester {

    public static void main(String[] args) {
      
       int[][] egdes = new int[4][];
       egdes[0] = new int[]{0,1,3};
       egdes[1] = new int[]{1,2,1};
       egdes[2] = new int[]{1,3,4};
       egdes[3] = new int[]{2,3,1};

       CityWithSmallestNeighbours city = new CityWithSmallestNeighbours();
       System.out.println(city.findTheCity(4, egdes, 4));
   
    }    

}
