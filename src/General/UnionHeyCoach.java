/*
 * 
 * 
 * 
 * Union in heycoach
Two heyCoach students have been assigned to solve certain coding problems for their upcoming tasks , 
the problems is represented with tme. he help of the problem’s number associated with it,
 both of them have a list of problems represented by an array of problem’s number(say arr1 and arr2),
  now as they have very limited time, they want to help each other by solving together. Return how many problems they have to solve together in order to save time.

Example 1
Input
 arr1= [1, 2, 3 , 5]
 arr2 =[7,6,5,8,9] 
Output
8
Example 2
Input
 arr1=[2,3]
 arr2 =[2,3]
Output
2
Constraints:
1<=arr1.length,arr2.length<=1000 For all 0<= i <arr1.length,arr2.length

1<=arr1[i],arr2[i]<=1000
 */
package General;

import java.util.ArrayList;
import java.util.List;

public class UnionHeyCoach {
     public List<Integer> solve(List<Integer> arr) {
        int n = arr.size();
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        
        // Calculate prefix sums
        prefixSum[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr.get(i);
        }
        
        // Calculate suffix sums
        suffixSum[n - 1] = arr.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr.get(i);
        }
        
        // Find indices where prefixSum[i] == suffixSum[i]
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}
