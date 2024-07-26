/*
 * 
 * 
 * Book Allocation Problem
You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book. 
Out of all the permutations, the goal is to find the permutation where the student with the most books allocated to him gets the minimum number of pages, 
out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Example 1:

Input:

- N = 4
- A[] = {12,34,67,90}
- M = 2
Output:

113
`Explanation:
Allocation can be done in the following ways:

{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Expected Time Complexity:
O(NlogN)

Expected Auxilliary Space:
O(1)

Constraints:
1 <= N <= 10^5

1 <= A [ i ] <= 10^6

1 <= M <= 10^5
 */
package General;

public class BookAllocationProblem {
    int findPages(int[] A, int N, int M) {
        if (N < M) {
            return -1;
        }

        // Initialize low and high for binary search
        int low = Integer.MAX_VALUE, high = 0;
        for (int i = 0; i < N; i++) {
            low = Math.min(low, A[i]);
            high += A[i];
        }

        // Perform binary search to find the minimum possible maximum pages
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocate(A, N, M, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canAllocate(int[] pages, int N, int M, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int i = 0; i < N; i++) {
            if (pages[i] > maxPages) {
                return false;
            }

            if (currentSum + pages[i] > maxPages) {
                studentsRequired++;
                currentSum = pages[i];

                if (studentsRequired > M) {
                    return false;
                }
            } else {
                currentSum += pages[i];
            }
        }

        return true;
    }
}
