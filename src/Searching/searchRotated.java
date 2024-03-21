package Searching;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/


33.
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 */



import java.util.Vector;

public class searchRotated {
    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>();
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        System.out.println(searchRotated(arr, 3));
    }

    public static int searchRotated(Vector<Integer> nums, int target) {
        //Write your code here
        return searchIndex(nums, target, 0, nums.size() - 1);

    }

    public static int searchIndex(Vector<Integer> nums, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (nums.elementAt(mid) == target)
            return mid;

        if (target >= nums.elementAt(left) && target < nums.elementAt(mid))
            return searchIndex(nums, target, left, mid);
        else
            return searchIndex(nums, target, mid + 1, right);
    }
}
