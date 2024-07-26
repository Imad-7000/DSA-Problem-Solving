/*
 * 
 * 
 * 
 * 
 * 
 * Houses of Binary Tree
In the HeyCoach Society, All Houses are arranged in the form of a Binary Tree. With all nodes representing the price of the house. Sam is interested to find out the minimum and maximum prices among all the houses present.

For Example: Given the Binary Tree

       1000
     /     \
   2000    3000
  /    \       \
 4000  7000    13000
The minimum and maximum prices among all the houses would be '1000' and '13000' respectively.

Input Format:

A single line that represents the value of the nodes and the value of '- 1' denotes NULL node.
Output Format:

Print an integer denoting the minimum price followed by another integer denoting the maximum price.
Sample Input:

2000 3000 5000 1000 -1 4000 -1 -1 -1 -1 -1
Sample Output:

1000 5000
Constraints:

0 <= N <= 10^3

0 <= data <= 10^6

Where N denotes the total number of nodes and 'data' denotes the value of the node
 * 
 */
package Trees.Tree;

public class MinMaxTree {
    public void solve(Node root) {
        if (root == null) {
            System.out.println("0 0");
            return;
        }

        int[] result = findMinMax(root);
        System.out.println(result[0] + " " + result[1]);
    }

    private int[] findMinMax(Node node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }

        int[] leftResult = findMinMax(node.left);
        int[] rightResult = findMinMax(node.right);

        int minVal = Math.min(node.val, Math.min(leftResult[0], rightResult[0]));
        int maxVal = Math.max(node.val, Math.max(leftResult[1], rightResult[1]));

        return new int[]{minVal, maxVal};
    }

}
