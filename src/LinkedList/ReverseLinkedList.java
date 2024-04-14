/**
 * 
 * 
 * reverse a linked list
Given a linked list of N nodes, your task is to reverse the list.

Input Format:
A singly linked list of N nodes, where N is the number of nodes in the linked list.
The linked list is provided as a sequence of N integer values, where each value represents the val of a node, and nodes are connected in the order they are given.
Output Format:

The reversed linked list as a sequence of integers, now ordered from the last node in the input list to the first.
Input:
LinkedList: 2->7->8->9->10

Output:
Reversed LinkedList: 10 9 8 7 2

Example:

Input:

LinkedList: 1->2->3->4->5->6

Output:
Reversed LinkedList: 6 5 4 3 2 1
 */

package LinkedList;
class ListNode{
    int data;
    ListNode next;
}
public class ReverseLinkedList {
    public ListNode reverse(ListNode head){
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
}
