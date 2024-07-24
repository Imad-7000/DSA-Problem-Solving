/*
 * 
 * 
 * 
 * MAX ELEMENT IN CIRCULAR QUEUE
Ramesh loves diamonds, One day he found out that there is a circular linked list-like structure present in this neighbourhood, 
and each node of that linked list contains the number of diamonds in the form of node value, Ramesh wants to collect the maximum 
amount of diamonds but he can only take away the diamonds of only one of the node. How many diamonds can Ramesh get?
A linked list is said to be circular when the last node of a linked list is connected with the first node.

Example 1:
Input:
list = [1,2,3,6,8]
Output:
8
Example 2:
Input:
list = [9,3,6,9,25]
Output:
25
Constraints:
The number of the nodes in the list is in the range [0., 10^4]

0 <= Node.val <= 10^4
 */
package General;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class MaxElemInQueue {
    public void printList(Node head) {
        //Write your code here
         if (head == null) {
              System.out.println(0);
              return;
          }
  
          int maxDiamonds = head.data;
          Node current = head.next;
  
          // Traverse the list starting from the node next to the head
          while (current != head) {
              if (current.data > maxDiamonds) {
                  maxDiamonds = current.data;
              }
              current = current.next;
          }
  
          // Print the maximum diamonds
          System.out.println(maxDiamonds);
  
      }
}
