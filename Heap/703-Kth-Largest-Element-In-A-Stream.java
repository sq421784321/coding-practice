class KthLargest {
	/*
		Method 1: minHeap.
		
		Maintain a minHeap of size k to store the k largest elements.
	*/
	
    private PriorityQueue<Integer> minHeap;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        
        for (int num : nums) {
            minHeap.add(num);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */