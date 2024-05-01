/*
 * 
 * 106. COnstruct Tree from Inorder and PostOrder
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * 
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder 
 * is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */
package Trees.Tree;

public class ConstructInorderAndPostOrder {
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        return build(inorder, postorder, 0, idx);
    }

    public TreeNode build(int[] inorder, int[] postorder, int i, int j){
        if( i > j || idx < 0)
            return null;
        TreeNode root = new TreeNode(postorder[idx]);
        for(int k = i; k <=j;k++ ){
            if(inorder[k] == postorder[idx]){
                idx--;
                root.right = build(inorder, postorder, k + 1, j);
                root.left = build(inorder, postorder, i, k -1);
                break;
            }
        }
        return root;
    }

}
