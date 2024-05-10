/*
 * 
 * 128/ Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
package HashSet;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>  seen = new HashSet<>();
        for(int num: nums)
            seen.add(num);
        int maxCount = 0;

        for(int i = 0; i < nums.length; i++){
            int val = nums[i];
            if(seen.contains(val)){
                int count = 1;
                int temp =val - 1;
                while (seen.contains(temp)) {
                    seen.remove(temp);
                    temp = temp - 1;
                    count++;
                }
                temp = val + 1;
                while(seen.contains(temp)){
                    seen.remove(temp);
                    temp = temp + 1;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}
