/*
 * 
 * 
 * Median in a data stream
 * 
 * 
Given that n integers are read from a data stream. Your task is to find the median of the elements read so far.
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
  So the median is the floor of the average of the two middle values.

Example 1
Input
arr = [5,3,8]
Output
[5,4,5]
Explanation
After reading first element of stream, Median of [5] is 5 After reading second element of stream, Median of [5, 3] = floor((5+3)/2)=4 
After reading third element of stream, Median of [5,3,8] = 5 ,it is the middle value of the sorted array So the output will be 5 4 5.

Example 2:

Input:

arr = [1,2,3] 
Output:

[1,1,2]
Constraints:
1 <= n <= 10000
0 <= arr[i] <= 100000
 */
package HeyCoach.SessionTest.LevelTest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfInputStream {
    public List<Integer> findMedian(List<Integer> arr, int n) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < arr.size(); i++){
            pq.add(arr.get(i));
            int median = median(pq);
            list.add(median);
        }
        return list;
    }

    public int median(PriorityQueue<Integer> pq){
        int size = pq.size();
        List<Integer> temp = new ArrayList<>();
        int mid = (0 + size)/2;
        double val = 0;
        if(size % 2 == 0){
            int i = 0;
            while(i <= mid){
                int t = pq.poll();
                if( i == mid - 1 || i == mid)
                    val += t;
                temp.add(t);
                i++;
            }
        }
        else{
            int i = 0;
            while(i <= mid){
                int t = pq.poll();
                if(i == mid)
                    val += t;
                temp.add(t);
                i++;
            }
        }

        for(int i = 0 ; i < temp.size(); i++){
            pq.add(temp.get(i));
        }
        if(size %2==0)
            val = Math.floor(val/2);
        return (int) val;
    }
}
