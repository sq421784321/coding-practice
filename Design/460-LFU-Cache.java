class LFUCache {
    private int min;
    private int capacity;
    private Map<Integer, Integer> keyToVal;		// map from key to value
    private Map<Integer, Integer> keyToCount;	// map from key to count
    private Map<Integer, LinkedHashSet<Integer>> countToLFUKeys;	// map from count to ordered set of keys 
    
    public LFUCache(int capacity) {
        min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLFUKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
		
        int count = keyToCount.get(key);
        countToLFUKeys.get(count).remove(key);		// remove old count
		
        if (count == min && countToLFUKeys.get(count).size() == 0) {	// update new min
            min++;
        }
        putCount(key, count + 1);	// update new count
        return keyToVal.get(key);
    }
    
    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        LinkedHashSet<Integer> set = countToLFUKeys.get(count);
        if (set == null) {
            set = new LinkedHashSet<Integer>();
        }
        set.add(key);
        countToLFUKeys.put(count, set);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (keyToVal.containsKey(key)) {	// if existing, update old key
            keyToVal.put(key, value);
            get(key);
            return;
        }
        
        if (keyToVal.size() >= capacity) {	// Otherwise, if reach the capacity, evict the oldest least frequent key
            evict(countToLFUKeys.get(min).iterator().next());
        }
        
        min = 1;		//	add cur key
        putCount(key, min);
        keyToVal.put(key, value);
    }
    
    private void evict(int key) {
        countToLFUKeys.get(min).remove(key);
        keyToVal.remove(key);
        keyToCount.remove(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */