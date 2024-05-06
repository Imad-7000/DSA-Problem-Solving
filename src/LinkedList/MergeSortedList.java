/*
 * 
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 */

package LinkedList;

class ListNode {
        int val;
        ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list2.val < list1.val)
            return mergeTwoLists(list2, list1);
        
        ListNode head = list1;

        while(head != null && list2 != null){
            if(head.val < list2.val){
                ListNode temp = new ListNode(list2.val, null);
                temp.next = head.next;
                head.next = temp;
                head = head.next;
                list2 = list2.next;
            }
            else if(head.val == list2.val)
            {
                ListNode temp = list2;
                temp.next = head.next;
                head.next = temp.next;
                head = head.next.next;
                list2 = list2.next;
            }
            else{
                
            }
        }
    }
}
