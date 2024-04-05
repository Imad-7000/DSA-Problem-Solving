/*
 * Given an integer array nums, return all the different possible non-decreasing subsequences 
 * of the given array with at least two elements. You may return the answer in any order.

 
Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100
 */

package Recursion.DP.KnapsackTemplate;

import java.util.List;

public class NonDecreasingSubsequence {
     public List<List<Integer>> findSubsequences(int[] nums) {
        
    }

    public void helper(int[] nums, List<List<Integer>> list, List<Integer> current,  int n){
        if(n == nums.length)
            return;
        if(current.size() > 1)
        {
            if(current.get(current.size() - 1) > current.get(current.size() - 2)){
                list.add(current);
            }
            else
                return;
        }
        
    
        
    }
}
