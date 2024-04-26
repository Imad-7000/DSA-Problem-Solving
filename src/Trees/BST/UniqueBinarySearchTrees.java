/**
 * 
 * 96. Unique Binary Search Tree
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1

This problem is based on CATALAN NUMBER - template : memoize to make it faster
 */

package Trees.BST;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        int ans  = 0;
        for(int i = 0 ; i< n;i++){
            ans += numTrees(n - 1 - i) * numTrees(i);
        }
        return ans;
    }
}
