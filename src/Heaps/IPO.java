/*
 * 
 * 502 IPO
 * https://leetcode.com/problems/ipo/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, 
 * LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
 *  it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its
 *  total capital after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

 

Example 1:

Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Example 2:

Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
Output: 6
 

Constraints:

1 <= k <= 105
0 <= w <= 109
n == profits.length
n == capital.length
1 <= n <= 105
0 <= profits[i] <= 104
0 <= capital[i] <= 109
 * 
 * 
 */

package Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //ADd capital and profit to 2D array to sort together
        int[][] capAndProf = new int[capital.length][2];
        for(int i = 0 ; i < capAndProf.length; i++){
            capAndProf[i][0] = capital[i];
            capAndProf[i][1] = profits[i];
        }
        FreqSort freq = new FreqSort();
        Arrays.sort(capAndProf, freq);
        int n = capital.length;
        int i = 0;

        //Heap DS to add all profits that lie under the current capital w
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        //we do this for the given k
        while(k > 0){
            //as long as we are in the range of array and capital is less than equal to w, keep adding profit to PQ 
            while(i < n && capAndProf[i][0] <= w){
                pq.add(capAndProf[i][1]);
                i++;
            }
            //if PQ is empty, it means we do not have enough capital for anything, so just break and return w
            if(pq.isEmpty())
                break;
            //take the top most profit and add to w, the working capital
            w += pq.poll();
            k--;
            
        }
        return w;
    }
}

    class FreqSort implements Comparator<int []>{
        @Override
        public int compare(int[] o1, int[]  o2) {
            return Integer.compare(o1[0],o2[0]);
    }
}
