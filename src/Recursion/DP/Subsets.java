/*
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 * 
 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 * 
 */
package Recursion.DP;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        subsets(nums, 0 , new ArrayList<>());
        return ans;
    }

    public void subsets(int[] nums, int i, List<Integer> temp){
        if( i >= nums.length)
            return;
        temp.add(nums[i]);
        ans.add(new ArrayList<>(temp));

        subsets(nums, i + 1, temp);
        subsets(nums, i + 1, new ArrayList<>());
    }
}
