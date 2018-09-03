class Solution {
	/*
		Method 1: Iterative.
		
		Two flags to represent monotone increasing array and monotone decreasing array respectively.
	*/
	
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for (int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                decreasing = false;
            }
            if (A[i] < A[i - 1]) {
                increasing = false;
            }
        }
        
        return (increasing || decreasing);
    }
}