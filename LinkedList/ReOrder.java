/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReOrder {
    public ListNode reorderList(ListNode A) {
        ListNode slow = A;
        ListNode fast = A.next;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node1 = A;
        ListNode node2 = slow.next;
        slow.next = null;

        node2 = reverseList(node2);

        A = new ListNode(0);
        ListNode curr = A;
        while(node1!=null || node2!=null){
            if(node1!=null){
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
            if(node2!=null){
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        A = A.next;
        return A;
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
