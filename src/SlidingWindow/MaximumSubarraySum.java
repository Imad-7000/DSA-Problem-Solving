/*
 * 2461. maximum sum of distinct subarrays with length k
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */


package SlidingWindow;

import java.util.HashSet;

public class MaximumSubarraySum {

    public static long maximumSubarraySum(int[] nums, int k){
        long answer = 0;

        int i = 0; 

        while(i <= nums.length - k){
            
             HashSet<Integer> seen = new HashSet<>();
            long temp = 0;
            int j = i;
            while (j < i + k) {
                if(!seen.contains(nums[j])){
                    seen.add(nums[j]);
                    temp += nums[j];
                }
                j++;
            }
            
            if(seen.size() == k && temp > answer)
            answer = temp;
            i++;
        }
        return answer;
    }

    public static long maximumSubarraySumv2(int[] nums, int k){
        long answer = 0;
        int i = 0; 
        HashSet<Integer> seen = new HashSet<>();
        int temp = 0;
        int j = 0;
        while (i <= nums.length - k) {
            seen.add(nums[i]);
            while (j < i + k) {
                if(!seen.contains(nums[j])){
                    seen.add(nums[j]);
                }
                
                temp += nums[j];
                j++;
            }
            if(seen.size() == k && temp > answer){
               
                answer = temp;
                }
            seen.remove(nums[i]);
            temp -= nums[i];
            i++;
        }

        return answer;
    }

    public static long maximumSubarraySumv3(int[] nums, int k){
        HashSet<Integer> hash = new HashSet<>();
        long answer = 0;
        long temp = 0;

        int i = 0; 
        int j = 0;

        while (j < nums.length) {
            if(!hash.contains(nums[j])){
                hash.add(nums[j]);
                temp += nums[j];
                j++;

                while (hash.size() > k) {
                    hash.remove(nums[i]);
                    temp -= nums[i];
                    i++;
                }

                if(hash.size() == k)
                    answer = Math.max(answer, temp);
            }
            else{
                hash.remove(nums[i]);
                temp -= nums[i];
                i++;
            }
        }
        return answer;
    }
}
