/*
 * 958
 * 
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
 * 
 * Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}),
 and all nodes in the last level ({4, 5, 6}) are as far left as possible.
Example 2:


Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 1000
 */

package Trees.Tree;

public class Iscomplete {
    public boolean isCompleteTree(TreeNode root) {
        int count = count(root);
        return isCompleteTree(root, 0 , count - 1);
    }

    public boolean isCompleteTree(TreeNode root, int idx, int count){
        if(root == null && idx > count)
            return true;
        if(root == null && idx <= count)
            return false;
        if(idx >count)
            return false;
        return isCompleteTree(root.left, 2 * idx + 1, count) && isCompleteTree(root.right, 2 * idx + 2, count);
    }
    public int count(TreeNode root){
        if(root == null)
            return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
