class Solution {
	/*
		Method 1: Two pointers.
		
		Keep track of the start index of each valid mountain.
	*/
	
    public int longestMountain(int[] A) {
        int ans = 0;
        
        int start = 0;   //  start index of the mountain
        int cur = 1;     //  current index
        
        while (cur < A.length) {
            int tmp = cur;
            
            int incr = 0;
            while (cur < A.length && A[cur] > A[cur - 1]) {
                incr++;
                cur++;
            }
            
            int decr = 0;
            while (cur < A.length && A[cur] < A[cur - 1]) {
                decr++;
                cur++;
            }
            
            // Make sure to meet the mountain property
            if (incr > 0 && decr > 0) {
                ans = Math.max(ans, cur - start);
            }
            start = cur - 1;
            
            // Avoid infinite loop
            if (cur == tmp) {
                cur++;
                start++;
            }
        }
        
        return ans >= 3 ? ans : 0;
    }
}