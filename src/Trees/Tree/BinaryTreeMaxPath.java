/*
 * 124. Binary Tree Max Path
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an 
 * edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
 */
package Trees.Tree;

public class BinaryTreeMaxPath {

    public int helper(){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return maxPathSum(root);
    }
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         max(root, 0);
         return max;
    }

    public int max(TreeNode root, int sum){
        if(root == null)
            return 0;
        int left = max(root.left, sum);
        int right = max(root.right, sum);
        
        left = Math.max(left,0);
        right = Math.max(right, 0);
        max=  Math.max(max,root.val + left + right);
        return root.val + Math.max(left,right);
    }
}
