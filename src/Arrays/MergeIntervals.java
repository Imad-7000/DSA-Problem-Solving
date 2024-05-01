/*
    56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description
 * 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < intervals.length; i++){
            int startVal = intervals[i][0];
            int endVal = intervals[i][1];

            int j = i + 1;

            while(j < intervals.length && intervals[j][0] <= endVal){
                endVal = Math.max(endVal, intervals[j][1]);
                j++;
            }

            List<Integer> temp = new ArrayList<>();
            temp.add(startVal);
            temp.add(endVal);
            i = j - 1;
        }

        int[][] array = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            List<Integer> innerList = list.get(i);
            array[i] = new int[innerList.size()];

            for (int j = 0; j < innerList.size(); j++) {
                array[i][j] = innerList.get(j);
            }
        }

        return array;
    }
}
