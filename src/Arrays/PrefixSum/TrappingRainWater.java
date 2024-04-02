/*
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

package Arrays.PrefixSum;

public class TrappingRainWater {

    //The logic is that the maximum amount of water that can be trapped is minimum of max walls - current wall
    //Hence we find for each index maximum wall as pre and post and perform the differnece

    //Runs in O(n)
    public static int trap(int[] height) {
        int finalAns = 0;

        int[] pre = new int[height.length];
        int[] post = new int[height.length];
        pre[0] = height[0];
        post[height.length - 1] = height[height.length - 1];
        for(int i = 1, j = height.length - 2; i < height.length && j >= 0; i++, j-- ){
            pre[i] = Math.max(pre[i - 1], height[i]);
            post[j] = Math.max(post[j + 1], height[j]);
        }

        for(int i = 0; i < height.length; i++){
            System.out.print(pre[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < height.length; i++){
            System.out.print(post[i] + " ");
        }

        for(int i = 0; i < height.length ; i++){
            int val = Math.min(pre[i], post[i]) - height[i];
            finalAns += val;
        }
        return finalAns;
    }
}
