
/*
 * 
 * Range of an array
Given an unsorted array arr of n non-negative integers, you have to find the range of an array. 
The range of an array is the difference between the maximum and minimum value of the array. If a single value is present return 0.

Example 1
Input
arr = [3,2,10,4,7,8]
Output
8
Explanation:
The Maximum value in the array is 10 and the minimum value is 2 so the range is 10 - 2 = 8

Example 2
Input
arr = [30,15,6,10,12,22]
Output
24
Explanation:
The Maximum value in the array is 30 and the minimum value is 6 so the range is 30 - 6 = 24

Constraints:
0 < n <= 100000
0 <= arr[i] <= 100000
 */
package HeyCoach.SessionTest.LevelTest;

import java.util.Arrays;

public class RangeOfArray {
    public int rangeOfAnArray(int[] arr) {
        //Write your code here 
        if(arr.length == 1)
            return 0;
        
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
        
     }
}
