import java.util.*;

import SlidingWindow.BinarySubarrayWithSum;
import Trees.Tree.BinaryTreeMaxPath;



public class Tester {

    public static void main(String[] args) {
        int[] nums= new int[]{0,0,0,0,0};
        BinarySubarrayWithSum b = new BinarySubarrayWithSum();
        System.out.println(b.numSubarraysWithSum(nums, 0));
    }    

}
