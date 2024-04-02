import Recursion.Backtracking.*;
public class Tester {

    public static void main(String[] args) {

        // int[][] memo = new int[7][8];
        // for(int i = 0; i < memo.length; i++)
        //     for(int j = 0; j < memo[i].length; j++)
        //         memo[i][j] = -1;

        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(Arrays.PrefixSum.TrappingRainWater.trap(arr));

    }
}
