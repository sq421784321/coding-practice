Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

/* make use of a HashMap and Doublely Linked Node*/
class LRUCache {
    static class Node {
        Node prev;
        Node next;
        int key;
        int val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        public void update(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
    }
    
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        
        remove(node);
        append(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)) {
            node = map.get(key);
            remove(node);
            node.val = value;
        } else if (map.size() < capacity) {
            node = new Node(key, value);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }
    
    //         A <==> B <==> C <==> D
    //        tail                 head
    // [least recently used]    [recently used]
    
    private void remove(Node node) {
        map.remove(node.key);
        if(head == node) {
            head = node.prev;
        }
        
        if (tail == node) {
            tail = node.next;
        } 
        
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }
    
    private Node append(Node node) {
        map.put(node.key, node);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            head.next = node;
            node.prev = head;
            head = node;
        }
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
