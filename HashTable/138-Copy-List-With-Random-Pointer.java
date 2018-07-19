/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if (head == null) return null;
        
        RandomListNode dummyNode = new RandomListNode(0);
        RandomListNode cur = dummyNode;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        while (head != null) {
            
            RandomListNode next = null;
            
            if(map.containsKey(head)) {
                next = map.get(head);
            } else {
                next = new RandomListNode(head.label);
            }
            map.put(head, next);
            cur.next = next;
            
            if (head.random != null) {
                RandomListNode nextRandom = null;
                
                if (map.containsKey(head.random)) {
                    nextRandom = map.get(head.random);
                } else {
                    nextRandom = new RandomListNode(head.random.label);
                }
                
                map.put(head.random, nextRandom);
                next.random = nextRandom;
            }
            
            cur = cur.next;
            head = head.next;
        }
        return dummyNode.next;
    }
}