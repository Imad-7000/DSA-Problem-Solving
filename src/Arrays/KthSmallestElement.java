/*
 * 
 * kth smallest element
Given an input stream arr of n integers. Find the Kth smallest element for 
each element in the stream and if the Kth smallest element doesn't exist, then print -1.

Example 1

Input: n = 6, k = 4, arr = [1,2,3,4,5,6]

Output: [-1,-1,-1,4,4,4]

Constraints

1 <= n,k <= 10^5

1 <= arr[i] <= 10^5
 */

package Arrays;

import java.util.Arrays;

public class KthSmallestElement {
    public int[] kthSmallest(int k, int[] arr, int n) {
        int[] answer = new int[arr.length];
        if(k > arr.length)
            {
                for(int i = 0; i< answer.length;i++)
                    answer[i] = -1;
                return answer;
            }
        Arrays.sort(arr);
        int val = arr[k - 1];
        for(int i = 0; i < arr.length; i++){
            if(i < k - 1)
                answer[i] =  -1;
            else
                answer[i] = val;
        }
        return answer;
    }
}
