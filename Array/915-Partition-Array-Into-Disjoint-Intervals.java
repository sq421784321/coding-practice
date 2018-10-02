class Solution {
	/*
		Method 1: Iterative.
		
		Create a helper array to keep the minimum number from current index to the right end.
	*/
	
    public int partitionDisjoint(int[] A) {
        int[] smallestToRight = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                smallestToRight[i] = Integer.MAX_VALUE;
            } else {
                smallestToRight[i] = Math.min(smallestToRight[i + 1], A[i]); 
            }
        }
        
        int largestSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            largestSoFar = Math.max(largestSoFar, A[i]);
            if (largestSoFar <= smallestToRight[i + 1]) {
                return i + 1;
            }
        }
        
        return 0;
    }
}