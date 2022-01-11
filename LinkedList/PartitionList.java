/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {

        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while(A != null){

            if(A.val < B){
                before.next = A;
                before = before.next;

            }
            else{
                after.next = A;
                after = after.next;

            }
            A = A.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }
}
