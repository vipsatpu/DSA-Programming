/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

    public ListNode reverse(ListNode A){
        ListNode prev = null;
        ListNode next = A;
        ListNode curr = A;
        while(curr !=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode A, int B, int C) {

        if(B==C){
            return A;
        }
        ListNode preEnd = null, temp =A;
        int i = 1;
        while(i<B){
            preEnd = temp;
            temp=temp.next;
            i++;
        }
        if(preEnd != null){
            preEnd.next = null;
        }
        ListNode start = temp;
        while(i<C){
            temp = temp.next;
            i++;
        }
        ListNode postBeg = temp.next;
        temp.next = null;

        start = reverse(start);
        if(preEnd!=null){
            preEnd.next = start;
        }
        else{
            A = start;
        }
        temp = start;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = postBeg;
        return A;
    }
}
