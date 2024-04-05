import Recursion.*;
public class Tester {

    public static void main(String[] args) {

        int[][] memo = new int[7][8];
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++){
                    if(i ==0 || j==0)
                        memo[i][j] = 0;
                    else
                        memo[i][j] = -1;
            }
        
            int val = Recursion.DP.LCSTemplate.LCS.lcs(6, 7, "aggtab", "gtxxayb", memo);
            
            for(int i = 0; i < memo.length; i++){
                for(int j = 0; j < memo[i].length; j++){
                    System.out.print(memo[i][j] + "         ");
                }
                System.out.println();
            }
            
            System.out.println(Recursion.DP.LCSTemplate.LCS.longest("aggtab", "gtxxayb", 5, 6));
        // int[] arr = new int[]{1,1,1,1,1};
        // System.out.println(Recursion.DP.KnapsackTemplate.TargetSum.findTargetSumWays(arr, 1));
       // System.out.println(Arrays.PrefixSum.TrappingRainWater.trap(arr));
      // System.out.println(Recursion.LargestMerge.largestMerge("cabaa", "bcaaa"));

    }
}
