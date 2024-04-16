/*
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
 * 
 */

package LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        int k = 0;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            k++;
        }
        
        if(fast == null)
            k =(k *2) ;
        else
            k =(k * 2) + 1;
        System.out.println(k);
        if(k == n)
            return head.next;
        for(int i = 1; i < (k - n); i++){
            slow = slow.next;
        }
        if(slow.next == null)
            return null;
        else
            slow.next = slow.next.next;
        
        return head;
    }
}