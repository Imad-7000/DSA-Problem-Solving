/*
 * 
 * First Negative element in evry window size k
In the town of Kanpur, where technology intertwined with everyday life, 
lived a young programmer named Nitin. One sunny afternoon, while strolling through the local park, 
she stumbled upon an antique book filled with intricate coding riddles.
Determined to crack the enigma, Nitin found a puzzling task: to locate the first negative integer
 within every subarray of window size k in a given sequence(say arr) of size N . 
 
 Help Nitin in solving this task.

Example:

Input:

k= 3
arr={12, -1, -7, 8, -15, 30, 16, 28}  
Output:

-1 -1 -7 -15 -15 0 
Constraints:

1 <= N <= 10^5
10^5 <= A[i] <= 10^5
1 <= K <= N
 */


package SlidingWindow;

import java.util.ArrayList;

public class FirstNegativeElement {

    public static void printFirstNegativeInteger(ArrayList<Integer> arr, int k) {


        //iterate to i - k 
        int i = 0;
        while (i <= arr.size() - k) {
            int j = i; // j = i to start a new window every time

            //if any element found as negative, print break and move to next window
            while(j < k + i ){
                if(arr.get(j) < 0){
                    System.out.print(arr.get(j) + " ");
                    break;
                }
                j++;
            }

            //if no negative elemnt, print 0;
            if(j == k + i)
                System.out.print("0" + " ");
            i++;
        }
    }

}
