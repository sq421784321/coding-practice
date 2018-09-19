class Solution {
	/*
		Method 1: Swap.
		
		Swap the random picked index with tail index. 
		And use hashmap to record that relationship.
		Meanwhile, use an 'offset' to keep track of the latest tail.
	*/
	
    private Map<Integer, Integer> map;
    private int rows, cols;
    private int offset;
    private Random random;
    
    public Solution(int n_rows, int n_cols) {
        random = new Random();
        this.rows = n_rows;
        this.cols = n_cols;
        map = new HashMap<>();
        this.offset = rows * cols - 1;
    }
    
    public int[] flip() {
        int index = random.nextInt(offset + 1);
        // Swap with the tail element
        int element = map.getOrDefault(index, index);
        map.put(index, map.getOrDefault(offset, offset));
        map.put(offset, element);
        
        offset -= 1;
        return new int[] { element / cols, element % cols };
    }
    
    public void reset() {
        offset = rows * cols - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */