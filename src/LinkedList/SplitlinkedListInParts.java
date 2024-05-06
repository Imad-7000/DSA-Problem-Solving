/*
 * 
 * 
 * Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater
 than or equal to parts occurring later.

Return an array of the k parts.

 

Example 1:


Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].
Example 2:


Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 

Constraints:

The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50
 */
package LinkedList;
class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SplitlinkedListInParts {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        ListNode temp1 = head;
        int size = count(temp1);
        int numOfElementsInEach = size / k;
        int numberOfExtras = size % k;
        int j = 0;
        for(int i = 0; i < k ; i++){
            ListNode temp = null;
            ListNode temp2 = null;
            int t = numOfElementsInEach;
            if(t > 0){
                temp = head;
                temp2 = head;
                head = head.next;
                t--;
                while(t > 0){
                    temp.next = head;
                    temp = temp.next;
                    head = head.next;
                    t--;
                }
            }
            if(numberOfExtras > 0){
                if(temp == null){
                    temp = head;
                    temp2 = head;
                }
                else{
                    temp.next = head;
                    temp = temp.next;
                }
                head = head.next;
                numberOfExtras--;
            }
            if(temp != null)
                temp.next = null;
            arr[j] = temp2;
            j++;
        }
        return arr;
    }

    public int count(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public void helper(){
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for(int i = 2; i <= 10; i++){
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }

        ListNode[] t = splitListToParts(head, 3);
        for(int i = 0; i < t.length; i++){
            ListNode h= t[i];
            while (h != null) {
                System.out.print(h.val + " ,  ");
                h = h.next;
            }
            System.out.println();
        }
    }
}
