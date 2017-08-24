public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        // method 1 : recursion
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        
        next.next = head;
        head.next = null;
        
        return newHead;
        
//        // method 2 : iteration
        
//         ListNode cur = head;
//         ListNode pre = null;
//         while(cur != null) {
//             ListNode next = cur.next;
//             cur.next = pre;
//             pre = cur;
//             cur = next;
//         }
//         return pre;
    }
}

