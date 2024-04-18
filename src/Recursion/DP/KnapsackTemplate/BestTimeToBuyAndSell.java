/*
 * GREEDY AND DP Approach
 * 
 * 121. Best Time to Buy and Sell Stock Price
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 * 
 * 
 * 
 * INTUITION: This code will fail on Memory Exceeded error at n = 10000 for DP
 * Hence this can be solved by Greedy Method as well
 */


package Recursion.DP.KnapsackTemplate;

public class BestTimeToBuyAndSell {
    static int[][] memo;
    public static int maxProfit(int[] prices) {
        memo = new int[prices.length + 1][prices.length + 1];
        for(int i = 0; i < memo.length; i++)
            for(int j =0; j < memo[i].length;j++)
                memo[i][j] = -1;
        return max(prices,prices.length - 1,prices.length -1);
    }

    public static int max(int[] prices, int n, int i){
        if( n < 0 )
            return 0;
        if( i < 0 )
            return 0;
        if(memo[n][i] != -1)
            return memo[n][i];
        int ans = 0;

        if(prices[n] < prices[i])
            ans = prices[i] - prices[n];
        
        return memo[n][i] = Math.max(ans,Math.max(max(prices, n - 1, i),max(prices, n - 1, i - 1)));

    }


    public int greedyApp(int[] prices){
        int maxProfit = 0;
        int best = prices[0];

        for(int i = 0 ; i < prices.length; i++){
            if(prices[i] > best){
                if(prices[i] - best > maxProfit)
                    maxProfit = prices[i] - best;
            }
            else{
                best = Math.min(best,prices[i]);
            }
        }
        return maxProfit;
    }
}
