/*
 * 1470. https://leetcode.com/problems/shuffle-the-array/description/
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

 

Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
 */

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ShuffleArray {


    public int[] shuffle(int[] nums, int n) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        //Store first n elements in list1 and next size - n elements in list2
        for(int i = 0; i < n; i++)
            list1.add(nums[i]);
        for(int i = n; i < nums.length; i++)
            list2.add(nums[i]);

        int i = 0;
        int j = 1;
        int k = 0;

        //Add back to main array alternatively
        while(j < nums.length){
            nums[i] = list1.get(k);
            nums[j] = list2.get(k);
            i +=2;
            j +=2;
            k++;
        }
        return nums;
    }
    
}
