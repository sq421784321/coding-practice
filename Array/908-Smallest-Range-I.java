class Solution {
	/*
		Method 1: Iterative.
		
		Find the min and max of the input array.
		All the other elements must be within the range of min and max.
	*/
	
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
		
        return max - K - (min + K) >= 0 ? max - K - (min + K) : 0;
    }
}