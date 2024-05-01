/*
 * 107
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * 
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (i.e., from left to right, level by level from leaf to root).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
 */

package Trees.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalReverse {
     public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root!= null)
            queue.add(root);
        int current = 1;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            temp.add(node.val);
            current--;
            if(current == 0){
                list.add(temp);
                temp = new ArrayList<>();
                current = queue.size();
            }
        }
        reverse(list);
        return list;
    }

    public void reverse(List<List<Integer>> list){
         if(list.size() <= 1 || list == null)
            return;
            
        List<Integer> temp = list.remove(0);
        reverse(list);
        list.add(temp);
    }
}
