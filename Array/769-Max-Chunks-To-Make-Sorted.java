class Solution {
    /*
		Method 1 : Greedy.
		
		How can we construct a chunk? -> The largest number within this chunk should be placed at the rightmost position.
	*/
	
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int cur = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            cur = Math.max(cur, arr[i]);
            if (cur == i) {
                ans += 1;
            }
        }
        
        return ans;
    }
	
	// Test case:
	// 5 3 2 0 1 4
}