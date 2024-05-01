/*

    103
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * 
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 * 
 */
package Trees.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root==null) {
            return Collections.emptyList();
        }
        
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
		List<List<Integer>> result = new ArrayList<>();
        List<Integer> row  = null;
		TreeNode node = null;
        deque.addFirst(root);
        
        while(!deque.isEmpty()) {
            
            row = new ArrayList<>();
            result.add(row);
            int size = deque.size();
			
            while(size>0) {
                node = deque.removeFirst();                
                row.add(node.val);
                
                if(node.left!=null) {
                    deque.addLast(node.left);
                }
                
                if(node.right!=null) {
                    deque.addLast(node.right);
                }
                
                size--;
            }
            
            size = deque.size();
            if(size > 0) {
                row = new ArrayList<>();
                result.add(row);
            }
            
            while(size > 0) {
                node = deque.removeLast();
                row.add(node.val);
                
                if(node.right!=null) {
                    deque.addFirst(node.right);
                }
                
                if(node.left!=null) {
                    deque.addFirst(node.left);
                }    
                
                size--;
            }
        }
        return result;
    }
}
