/*
 * 300. Longest Increasing Subsequence
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 * 
 *  
 * Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 
 */

public class LongestIncreasingSubSequence {
    public static int lengthOfLIS(int[] nums) {
        int best = 1;
        for(int i = nums.length - 1; i >=0; i--){
            for(int j = 0; j < i; j++){
                int temp = 1;
                if(nums[j] < nums[i])
                    temp++;
                if(temp > best)
                    best = temp;
            }
        }
        return best;
    }   

   

    public static void main(String[] args) {
        int[] arr = new int[]{97,98,99,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
}
