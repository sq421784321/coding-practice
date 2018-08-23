/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Assume the input linked list is not null.

		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				break;
			}
		}

		if(fast == null || fast.next == null) {
			return null;
		}

		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
    }
}

// 2*s = left + R + kC
// l   = left + R + mC
// (left + R + kC) * 2 = left + R + mC
// left + R + (2k - m)C = 0
// left + R = (m - 2k)C
// left = (m - 2k - 1)C + (C - R)