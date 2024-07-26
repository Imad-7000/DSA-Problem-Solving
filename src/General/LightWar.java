/*
 * 
 * Light War
You are given an array of integers stones where stones[i] is the weight of the ith stone. 
We are playing a game with the stones. On each turn, we choose the two lightest stones and smash them together.
 Suppose the two lightest stones have weights x and y with x <= y. The result of this smash is: If x == y, both stones are destroyed, 
 and If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x. At the end of the game, there is at most one stone left. 
 Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1
Input
Input : n = 6, nums = [2,7,1,8,1,4]
Output : 3
Constraints
1 <= stones.length <= 30

1 <= stones[i] <= 1000
 */
package General;

import java.util.PriorityQueue;
import java.util.Vector;

public class LightWar {
    public static int stonebreaker(Vector<Integer> nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all stones to the min-heap
        for (int num : nums) {
            minHeap.offer(num);
        }

        // Process the stones until there is at most one stone left
        while (minHeap.size() > 1) {
            int stone1 = minHeap.poll();
            int stone2 = minHeap.poll();

            if (stone1 != stone2) {
                minHeap.offer(stone2 - stone1);
            }
        }

        return minHeap.isEmpty() ? 0 : minHeap.poll();
    }
}
