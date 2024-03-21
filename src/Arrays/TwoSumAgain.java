package Arrays;
//Given an array of integers nums and an integer k, write a program to return the number of unique k-diff pairs in the array.
//        A k-diff pair is defined as an integer pair (nums[i], nums[j]), where the following conditions are true:
//
//        0≤i,j<length of nums and i≠j.
//
//        The absolute difference between the two numbers is exactly k, i.e., ∣nums[i]−nums[j]∣=k.
//
//        Input Format:
//        The first line contains an integer n and k space-separated, representing the number of elements in the array nums.
//
//        The second line contains n space-separated integers, the elements of the array nums.
//
//        Output Format:
//        Print a single integer representing the number of unique k-diff pairs in the array.
//
//        Sample Input:
//        5 2
//        3 1 4 1 5
//
//        Sample Output:
//        2

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumAgain {
    public static void main(String[] args) {

    }

    public static int findPairs(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++)
            hashMap.put(Math.abs(nums.get(i)), i);

        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (hashMap.containsKey(Math.abs(nums.get(i)) + Math.abs(k)) && i != hashMap.get(Math.abs(nums.get(i)) + Math.abs(k))) {
                hashMap.remove(Math.abs(nums.get(i)) + Math.abs(k));
                count++;
            }
        }

        return count;
    }
}
