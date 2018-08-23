/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 /*
	Method 1: Link one list to the other.
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode one, ListNode two) {
        if (one == null || two == null) return null;
        
        ListNode i = one;
        ListNode j = two;

        while(i != j) {
            i = i == null ? two : i.next;
            j = j == null ? one : j.next;
        }

        return i;
    }
}