import Recursion.Backtracking.*;
public class Tester {

    public static void main(String[] args) {

        int[][] memo = new int[7][8];
        for(int i = 0; i < memo.length; i++)
            for(int j = 0; j < memo[i].length; j++)
                memo[i][j] = -1;

        System.out.println(Recursion.Backtracking.DP.LCS.lcs(6, 7, "aggtab", "gtxxayb", memo));

        System.out.println(Recursion.Backtracking.DP.LCS.longest("aggtab","gtxxayb",6,7,memo));
    }
}
