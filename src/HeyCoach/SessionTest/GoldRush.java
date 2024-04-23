/*
 * 
 * 
 * 
 You're a seasoned prospector during the height of the Gold Rush, striking it rich in a hidden valley overflowing with gold nuggets!
  But these nuggets aren't your typical ore; they possess a curious property: you can split them in half (reduce their value exactly)
  and still mine additional nuggets from the smaller pieces. Your goal? Maximize your profit by strategically splitting nuggets to 
  reach the richest vein of gold as quickly as possible.

Scenario: You're a seasoned prospector during the height of the Gold Rush, striking it rich in a hidden valley overflowing with gold nuggets!
 But these nuggets aren't your typical ore; they possess a curious property: you can split them in half (reduce their value exactly) 
 and still mine additional nuggets from the smaller pieces. Your goal? Maximize your profit by strategically splitting nuggets to reach the 
 richest vein of gold as quickly as possible.

Challenge:

You're presented with an array nums representing the values of your found nuggets (positive integers between 1 and 10^7).
You can halve any nugget in your pile (reduce its value to exactly half) in a single operation. This halved nugget still counts as part of your gold stash.
Your mission is to minimize the number of splitting operations you need to perform to reduce the total value of your gold by at least half. 
Remember, the faster you reach this threshold, the more profitable your expedition!
Bonus Objective:

Efficiency is Gold: Develop a cunning mining algorithm that identifies the optimal splitting strategy, even for vast goldfields (large nums arrays).
 Can you strike the balance between maximizing profit and minimizing effort?

Input/Output Format:

Input:
An array nums containing the values of your gold nuggets.

Output:
Return a single integer representing the minimum number of splitting operations needed to reach the profit 
target (reduce the total gold value by at least half).

Examples:
Input:
5 19 8 1 (Nuggets in your prospector's pan)

Output:
3 (Following a specific splitting strategy, you can reach the target in 3 operations)

Input:
3 8 20 (Another gold-filled vein)

Output:
3 (Similarly, with the right approach, you can achieve the profit goal in 3 operations)

Constraints:
1 <= n <= 10^5 (Number of gold nuggets in your pile)
1 <= nums[i] <= 10^7 (Individual nugget value)
 */

package HeyCoach.SessionTest;

import java.util.Arrays;

public class GoldRush {
    public int min = Integer.MAX_VALUE;
    public int goldRush(int[] nums){
        int current = Arrays.stream(nums).sum();
        int target = current / 2;
         goldRush(nums, target, current, nums.length - 1);
         return min;
    }

    public int goldRush(int[] nums, int target, int current, int idx){
        if(current == target)
            return 1;
        if(idx < 0)
            return 0;
        if(nums[idx] == 0)
            return 0;
        int[] temp = nums;
        temp[idx] = temp[idx]/2;
        int sum = Arrays.stream(temp).sum();
        int pick = 1 + goldRush(temp, target, sum, idx);
        int skip = 1+ goldRush(nums, target, current,idx - 1);
        int val = Math.max(pick, skip);
        min = Math.min(min,val);
        return val;

    }
}
