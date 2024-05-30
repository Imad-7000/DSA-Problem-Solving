/*
 * 
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 * 
 * You are given an integer array coins representing coins of different denominations and 
 * an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 * 
 */
package Recursion.DP.KnapsackTemplate;

public class CoinChange {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
         memo = new int[coins.length + 1][amount + 1];
         for(int i = 0; i < memo.length;i++){
            for(int j = 0; j <memo[i].length;j++){
                memo[i][j] = -1;
            }
         }
        int val = minCoins(coins, amount, coins.length - 1) ;
        if(val >= 100000)
            return -1;
        else
            return val;
    }
    public int minCoins(int[] coins, int amount, int i){
        if(i < 0)
            return 100000;
        if(amount == 0)
            return 0;

        if(memo[i][amount] !=-1)
            return memo[i][amount];
        int skip = minCoins(coins, amount, i - 1);
        int pick = 100000;
        if(amount - coins[i] >= 0)
            pick = 1 + minCoins(coins, amount - coins[i],i);

        return memo[i][amount] = Math.min(pick,skip);
    }
}
