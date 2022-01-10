/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A.next;
        if(fast==null){
            return 1;
        }
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null && A.val != fast.val){
            return 0;
        }
        ListNode node2 = slow.next;
        if(node2.next == null){
            if(A.val != node2.val){
                return 0;
            }
        }
        node2 = reverseList(node2);
        while(node2!=null){
            if(A.val != node2.val){
                return 0;
            }
            A = A.next;
            node2= node2.next;
        }
        return 1;
    }

    public ListNode reverseList(ListNode node){

        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
