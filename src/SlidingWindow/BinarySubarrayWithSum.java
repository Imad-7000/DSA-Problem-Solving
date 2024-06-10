/*
 * 
 * 930. Binary subarray with Sums
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 * 
 * 
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */
package SlidingWindow;

public class BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int j = 0;
        int i = 0;
        int count = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            if(sum == goal)
                count++;
            if(sum > goal){
            while (i < nums.length && sum >= goal) {
                sum -= nums[i];
                i++;
                if(sum == goal)
                    count++;
            }
        }
            j++;
        }
        while(i < nums.length && sum >= goal){
            sum -= nums[i];
            if(sum == goal)
                count++;
            i++;
        }
        return count;
    }
}   
