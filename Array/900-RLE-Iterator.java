class RLEIterator {
	/*
		Method 1: Iterative.
		
		Keep track of the index and sum, then find the next element whose sum is larger or equal to target.
	*/
	
    int[] original;
    long target = 0;
    int curIndex = 0;
    long curSum = 0;
    
    public RLEIterator(int[] A) {
        original = A;
    }
    
    public int next(int n) {
        target += n;
        
        while (curIndex < original.length && curSum + original[curIndex] < target) {
            curSum += original[curIndex];
            curIndex += 2;
        }
        
        if (curIndex >= original.length) {
            return -1;
        }
        
        return original[curIndex + 1];
    }
    
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */