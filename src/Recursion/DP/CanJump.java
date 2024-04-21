/*
 * 
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * You are given an integer array nums. You are initially positioned 
 * at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105



THIS IS DP SOLUTION, better solution exists in ARRAYS folder
 */

package Recursion.DP;

public class CanJump {
    int[] memo;
    public boolean canJump(int[] nums) {
        memo = new int[nums.length + 1];
        return canJump(nums,0);
    }

    public boolean canJump(int[] nums, int idx){
        if(idx < nums.length - 1 && nums[idx] == 0)
            return false;
        if(idx > nums.length - 1)  
            return false;
        if(idx == nums.length - 1)
            return true;
        if(memo[idx] != 0){
            if(memo[idx] == 1)
                return true;
            else
                return false;
        }

        boolean ans = false;
        for(int i = 1; i <= nums[idx]; i++){
            ans = canJump(nums, idx + i);
            if(ans)
                break;
        }
        if(ans)
            memo[idx] = 1;
        else
            memo[idx] = -1;
        return ans;
    }
}
