/*
*   5. Longest Palindromic Substring
    https://leetcode.com/problems/longest-palindromic-substring/description/
* 
* You are given an array prices where prices[i] is the price of a given stock on the ith day.
* You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
* Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*   Example 1:

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
 *  INTUITION = for every index, check with two pointers for Palindrome
 *              Time O(n^2);
 */

public class LongestPalindromSubstring {
    public static void main(String[] args) {

    }

    static String beString = "";
    static int longest = 0;
    public static String longestPalindrome(String s) {
        for(int i = 0 ; i < s.length(); i++){
            longest(s, i, i);
            longest(s, i, i + 1);
        }
        return beString;
    }

    public static void longest(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            if(j - i + 1 > longest){
                longest = j - i + 1;
                beString = s.substring(i, j + 1);
            }
            i--;
            j++;
        }
    }
}
