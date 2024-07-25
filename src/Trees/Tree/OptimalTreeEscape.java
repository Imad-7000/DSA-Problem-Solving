/*
 * 
 * Optimal Tree Escape
Objective: Determine who escapes first from a binary tree by either always moving left (Ram) or always moving right (Shyam).

Given:

A binary tree where each node represents a position in a unique training course, with two children nodes (left and right) except
 for leaf nodes, which have no children.
Two characters, Ram and Shyam, start from the root of the binary tree. Ram always moves to the left child, and Shyam always moves 
to the right child. Their goal is to reach any leaf node to escape the tree.
Output:

If both Ram and Shyam escape the tree simultaneously, return 0.
If Ram escapes first, return -1.
If Shyam escapes first, return 1.
Constraints:

The number of nodes in the tree is in the range [0, 200000].
Node values are within [-1000, 1000].
Examples:

Input: root = [1]
Output: 0 Explanation: Both start and end at the root node (the only node), escaping simultaneously.

Input: root = [10, 5, -1, -1, 15, 12, -1, -1, -1]
Output: 1 Explanation: Shyam escapes the tree first by always moving to the right child.

Input: root = [3, 9, 20, -1, -1, 15, 7, -1, -1, -1, -1]
Output: -1 Explanation: Ram escapes the tree first by always moving to the left child.

Solution Approach:

The solutions provided traverse the binary tree based on Ram's and Shyam's strategies, tracking the depth of traversal to
 determine who reaches a leaf node first. The depth comparison between the leftmost and rightmost
 paths effectively decides the output according to the specified rules.
 * 
 */
package Trees.Tree;

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }
}
public class OptimalTreeEscape {
     public int escapeTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = findLeftmostDepth(root);
        int rightDepth = findRightmostDepth(root);

        if (leftDepth < rightDepth) {
            return -1; // Ram escapes first
        } else if (rightDepth < leftDepth) {
            return 1;  // Shyam escapes first
        } else {
            return 0;  // Both escape simultaneously
        }
    }

    private int findLeftmostDepth(Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int findRightmostDepth(Node node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}
