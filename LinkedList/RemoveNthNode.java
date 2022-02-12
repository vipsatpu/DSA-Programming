/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 new ListNode(1) { val = 1; next = null}
 [1]
 ListNode ln2 = new ListNode(2) { val = 2; next = null}

 List<> list = new ArrayList();
 list.add(listnode)
 ListNode ln = lsit.get(0);
 ln.val =1;
 ln.next = ln2.addr();

 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode temp = A; // 1 2 3 4 5
        int len =0;
        while(temp!=null){
            temp = temp.next; // 2 , 3 4 5
            len++; //1 2 3, 4
        }
        if(B> len){
            return A.next; // 2 ,3, 4 ,5
        }
        int pos = len - B +1; // 4 - 2 = 2 +1 = 3
        if(pos==1){
            return A.next; // 1 2 3 4 5
        }
        temp = A; // 1 2 3 4 5
        len =0;
        while(temp!= null){
            len++;
            if(pos-1==len){
                // temp .val = 3
                // temp.next = 4
                // temp.next.next= 4..next = 5
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return A;
    }
}
