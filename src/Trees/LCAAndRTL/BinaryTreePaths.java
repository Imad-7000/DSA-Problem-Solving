/*
 * 257 Binary Tree Path
 * https://leetcode.com/problems/binary-tree-paths/description/
 * 
 * Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 * 
 */
package Trees.LCAAndRTL;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
}

public class BinaryTreePaths {
      List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        rtl(root, "");
        return list;
    }

    void  rtl(TreeNode root, String path){
        if(root == null)
            return;
        
        path += root.val + "->";
        if(root.left == null && root.right == null){
             
             list.add(path.substring(0,path.length() -2));
        }
           
        rtl(root.left, path);
        rtl(root.right, path);
        path = path.substring(0,path.length() -2);
        
    }
}
