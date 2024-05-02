/*
 * 
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * 
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
package Trees.Tree;

import java.util.*;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
       Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if(root != null)
            q.add(root);
        else
            return new ArrayList<>();
        list.add(root.val);
        int current = 1;
        
        while (!q.isEmpty()) {
            TreeNode node  = q.poll();
            if(node.right != null)
                q.add(node.right);
            if(node.left!= null)
                q.add(node.left);
            current--;
            if(current == 0){
                if(q.peek() != null)
                list.add(q.peek().val);
                current = q.size();
            }
        }
        return list;
    }
}
