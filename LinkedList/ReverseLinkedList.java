public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        
        next.next = head;
        head.next = null;
        
        return newHead;
    }
}

