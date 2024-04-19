/*
 * 
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * 
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. 
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */
package Recursion.DP;

public class CanJumpTwo {
    int[] memo;
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        memo = new int[nums.length + 1];
        for(int i = 0 ; i < memo.length; i++)
            memo[i] = -1;
        return canJump(nums,0);
    }

    public int canJump(int[] nums, int idx){
        if(idx == nums.length - 1)
            return 0;
        if(idx < nums.length && nums[idx] == 0)
            return 10000;
       
        if(idx >= nums.length)
            return 10000;
        if(memo[idx] != -1)
            return memo[idx];

        int minJumps = Integer.MAX_VALUE;;
        for(int i = 1; i <= nums[idx]; i++){
            int ans = 1 + canJump(nums, idx + i);
            minJumps = Math.min(ans, minJumps);
        }
        memo[idx] = minJumps;
        return minJumps;
    }
}
