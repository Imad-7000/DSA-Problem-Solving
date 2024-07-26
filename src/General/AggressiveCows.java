/*
 * 
 * Aggressive Cows
In this scenario, the objective is to strategically allocate k aggressive cows to stalls in a way that maximizes the minimum distance between any two cows.
 Given an array of n integers representing stall positions, along with the integer k indicating the number of aggressive cows, the challenge is to find an 
 arrangement that ensures the largest possible gap between any two cows.

Sample Input 

5 3

1 2 4 8 9
Sample Output 

3
Constraints:

2 <= n <= 10^5

2 <= k <= n

0 <= stalls[i] <= 10^9
 */
package General;

import java.util.Arrays;

public class AggressiveCows {
    public int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int left = 1; // Minimum possible distance
        int right = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceCows(stalls, n, k, mid)) {
                result = mid;
                left = mid + 1; // Try for a larger distance
            } else {
                right = mid - 1; // Try for a smaller distance
            }
        }

        return result;
    }

    private boolean canPlaceCows(int[] stalls, int n, int k, int minDist) {
        int count = 1; // Place first cow in the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++;
                lastPosition = stalls[i];
                if (count == k) {
                    return true;
                }
            }
        }

        return false;
    }
}
