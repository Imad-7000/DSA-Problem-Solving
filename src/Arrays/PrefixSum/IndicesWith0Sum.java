/*
 * 
 * ROHAN LOVES 0 (2)
Rohan loves 0, he has been assigned a task by his coach to find all the indexes of an array having length n,
 such that on those indexes say i, 0<=i<=n-1, the absolute difference between PrefixSum[i] and SuffixSum[i] is 0.

Note: Prefix Sum : Prefix Sum[i] is defined as the sum of all the values of the array up to index i.

PrefixSum[0]=nums[0];

PrefixSum[1]=nums[0]+nums[1];

PrefixSum[i]=nums[0]+nums[1]+nums[2]+........nums[i].

Suffix Sum : Suffix Sum[i] is defined as the sum of all the values from end of the array up to index i.

Suffix Sum[n-1] = nums[n-1];

Suffix Sum[n-2] = nums[n-2]+nums[n-1];

Suffix Sum[i] = nums[i]+nums[i+1]+nums[i+2]+........nums[n-1].

Constraints:

1<=n<=10^4;

-10^4<=nums[i]<=10^4;

Sample test cases:

Input:
{4, 2, -3, 1, 6}

Output:
{1};

`Input:
{1, 2, -2, 3}

`Output: {1 2};
 */

package Arrays.PrefixSum;

import java.util.ArrayList;
import java.util.List;

public class IndicesWith0Sum {

    public static List<Integer> solve(List<Integer> arr) {
        int[] prefixSum = new int[arr.size()];
        int[] suffixSum = new int[arr.size()];
        
        prefixSum[0] = arr.get(0);
        suffixSum[arr.size() - 1] = arr.get(arr.size() - 1);

        int i = 1;
        int j = arr.size() - 2;

        while (i < arr.size()) {
            prefixSum[i] = prefixSum[i - 1] + arr.get(i);
            suffixSum[j] = suffixSum[j + 1] + arr.get(j);
            i++;
            j--;
        }
        arr = new ArrayList<>();
        for(int k = 0; k < prefixSum.length; k++){
            int val = Math.abs(prefixSum[k]) - Math.abs(suffixSum[k]);
            if(val == 0)
                arr.add(k);
        }
        return arr;
    }

}
