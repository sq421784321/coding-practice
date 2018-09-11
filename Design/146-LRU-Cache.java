class LRUCache {
    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
        
        DNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    
    private DNode head; // newest
    private DNode tail; // oldest
    private Map<Integer, DNode> map;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        DNode node = map.get(key);
        remove(node);
        append(node);
        
        return node.value;
    }
    
    private void remove(DNode node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else if (node.prev == null && node.next == null) {
            head = null;
            tail = null;
        } else if (node.prev != null) {
            head = node.prev;
            node.prev.next = null;
        } else {
            tail = node.next;
            node.next.prev = null;
        }
        
        node.prev = null;
        node.next = null;
        map.remove(node.key);
    }
    
    private void append(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.next = node;
            node.prev = head;
            head = node;
        }
        
        map.put(node.key, node);
    }
    
    public void put(int key, int value) {
        DNode newNode = new DNode(key, value);
        if (map.containsKey(key)) {
            DNode oldNode = map.get(key);
            remove(oldNode);
            append(newNode);
        } else if (map.size() < capacity) {
            append(newNode);
        } else {
            remove(tail);
            append(newNode);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */