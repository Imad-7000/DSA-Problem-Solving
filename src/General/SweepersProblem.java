/*
 * 
 * 
 * 
 * Sweepers Problem
 * 
You are managing a team of sweepers responsible for cleaning a series of roads in a city. Each road has a certain length, 
represented by an array of integers. Given the lengths of these roads and the number of sweepers available, your goal is to assign the sweepers to the roads 
in a continuous manner to minimize the total time required for cleaning all the roads.

Input Format:

The first line contains an integer, N, representing the number of roads.
The second line contains Nspace-separated integers, each representing the length of thei-th road.
The third line contains an integer, K, representing the number of sweepers.
Output Format:

Print a single integer representing the minimum time required to clean all the roads.
Constraints:

1 <= N <= 105
1 <= Length of each road (A[i]) <= 10^6
1 <= K <= N
Sample Input:

5
5 10 30 20 15
3
Sample Output:

35
Explanation:

Given 5 roads with lengths [5, 10, 30, 20, 15]and 3 sweepers, 
the optimal way to distribute the workload among the sweepers ensures that all roads are cleaned in a minimum total time of35.
 This output implies that the work distribution strategy must result in the least possible maximum work done by any sweeper,
  considering the sweepers work on continuous sections of roads.
 * 
 */
package General;

import java.util.Vector;

public class SweepersProblem {
    long minTime(Vector<Integer> arr, int n, int k) {
        // Convert Vector to an array for easier handling
        int[] roadLengths = new int[n];
        for (int i = 0; i < n; i++) {
            roadLengths[i] = arr.get(i);
        }

        // Initialize low and high for binary search
        long low = 0, high = 0;

        for (int length : roadLengths) {
            low = Math.max(low, length);
            high += length;
        }

        // Perform binary search to find the minimum time
        while (low < high) {
            long mid = (low + high) / 2;
            if (canSweepInTime(roadLengths, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canSweepInTime(int[] roadLengths, int k, long maxTime) {
        int requiredSweepers = 1;
        long currentSum = 0;

        for (int length : roadLengths) {
            if (currentSum + length > maxTime) {
                requiredSweepers++;
                currentSum = length;
                if (requiredSweepers > k) {
                    return false;
                }
            } else {
                currentSum += length;
            }
        }

        return true;
    }
}
