/*
 * 662. Maximum width of BT
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 * 
 * Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level 
are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
 */

package Trees.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryT {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        HashMap<TreeNode, Integer> hash = new HashMap<>();
        int current = 1;
        int max = 0;
        if(root != null){
            q.add(root);
            hash.put(root, 0);
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
             if(node.left!=null){
                q.add(node.left);
                hash.put(node.left, 2 * hash.get(node) + 1);
            }
            if(node.right != null){
                q.add(node.right);
                hash.put(node.right, 2 * hash.get(node)  +2 );
            }
            list.add(hash.get(node));
            current--;
            if(current == 0){
                max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
                list = new ArrayList<>();
                current = q.size();
            }
            
           
            
        }
        return max;
    }
}
