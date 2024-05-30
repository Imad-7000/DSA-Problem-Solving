/*
 * 
 * 
 * Room Allotment
There is a large hotel, and n customers will arrive soon. Each customer wants to have a single room.

You know each customer's arrival and departure day. Two customers can stay in the same room if the departure day of the first customer 
is earlier than the arrival day of the second customer.

What is the minimum number of rooms that are needed to accommodate all customers? And how can the rooms be allocated?

Input
The first input line contains an integer n: the number of customers.

Then there are n lines, each of which describes one customer. Each line has two integers a and b: the arrival and departure day.

Output
Print first an integer k: the minimum number of rooms required.

Example 1
Input
3
1 2
2 4
4 4
Output
2
Constraints:
1≤ n ≤2*10^5
1≤ a ≤ b ≤10^9
 * 
 */
package HeyCoach.SessionTest.LevelTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RoomAllotment {
    public int roomsReq(int[] arr, int[] dep, int n) {
        int[][] c = new int[arr.length][2];
        for(int i = 0 ; i < arr.length; i++){
            c[i][0] = arr[i];
            c[i][1] = dep[i];
        }
        Arrays.sort(c, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int count = 0;
        PriorityQueue<Integer> free = new PriorityQueue<>();
        for(int i = 0 ; i < c.length;i++){
            if(free.isEmpty()){
                free.add(c[i][1]);
                count++;
            }
            else{
                int q = free.peek();
                if(c[i][0] > q){
                    free.poll();
                }
                else{
                    count++;
                }
                free.add(c[i][1]);
            }
        }
        return count;
    }
}
