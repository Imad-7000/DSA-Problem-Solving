/*
 * 
 * 2305. Fair Distribution Of Cookies
 * https://leetcode.com/problems/fair-distribution-of-cookies/description/
 * 
 * You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag.
 *  You are also given an integer k that denotes the number of children to distribute all the bags of cookies to.
 *  All the cookies in the same bag must go to the same child and cannot be split up.

The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.

Return the minimum unfairness of all distributions.

 

Example 1:

Input: cookies = [8,15,10,20,8], k = 2
Output: 31
Explanation: One optimal distribution is [8,15,8] and [10,20]
- The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
- The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
The unfairness of the distribution is max(31,30) = 31.
It can be shown that there is no distribution with an unfairness less than 31.
Example 2:

Input: cookies = [6,1,3,2,2,4,1,2], k = 3
Output: 7
Explanation: One optimal distribution is [6,1], [3,2,2], and [4,1,2]
- The 1st child receives [6,1] which has a total of 6 + 1 = 7 cookies.
- The 2nd child receives [3,2,2] which has a total of 3 + 2 + 2 = 7 cookies.
- The 3rd child receives [4,1,2] which has a total of 4 + 1 + 2 = 7 cookies.
The unfairness of the distribution is max(7,7,7) = 7.
It can be shown that there is no distribution with an unfairness less than 7.
 * 
 * 
 * INTUITION : We create an array of number of divisions we need and intialise elements to zero.
 *              Create a for loop for every member and we start adding members to each recursively.
 *              and each time we add members, we check array for max and compare it to glbal min. if this is smaller, we update
 *              
 *              The main intuition is, after a certain division the max we get from the array, will no longer be min difference, and 
 *              it will stop updating. Thus becoming answer.
 */

package Recursion.Backtracking;

import java.util.Arrays;

public class FairDistOfCookies {
    int globalMin = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        helper(cookies, children, 0);
        return globalMin;
    }

    public void helper(int[] cookies, int[] children, int current){
        if(current == cookies.length){
            int val = Arrays.stream(children).max().orElse(0);
            globalMin = Math.min(val, globalMin);
            return;
        }

        for(int i = 0 ; i < children.length; i++){
            children[i] += cookies[current];
            helper(cookies, children, current + 1);
            children[i] -= cookies[current];
            //Since every child is identical, we add this to remove redundant operations.
            if(children[i] == 0)
                break;
        }
    }
}
