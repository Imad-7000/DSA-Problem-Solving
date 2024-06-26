/*
    61 Rotate Linked List

    https://leetcode.com/problems/rotate-list/description/

 * Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 * 
 */

package LinkedList;

class ListNode {
         int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

public class RotateLinkedList {
    public ListNode rotaListNode(ListNode head, int k){
            if (head == null || head.next == null || k == 0) {
                return head;
            }
    
            ListNode tail = head;
            int size = 1;
    
            while (tail.next != null) {
                size++;
                tail = tail.next;
            }
    
            int rotationCount = k % size;
            tail.next = head;
     
            for (int i = 0; i < size - rotationCount; i++) {
                tail = tail.next;
            }
        
        
            head = tail.next;
            tail.next = null;
    
            return head;
        }
    }

