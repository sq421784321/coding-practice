class Solution {
	/*
		Method 1: Iterative
		
		Time: O(V * N)
		
		For each droplet, check left side first, then right side, then current.
	*/
	
    public int[] pourWater(int[] heights, int V, int K) {
        while (V > 0) {
            int h = heights[K];
            int drop = K;
            
			// Check left side
            for (int i = K - 1; i >= 0 && heights[i] <= h; i--) {
                if (heights[i] < h) {
                    h = heights[i];
                    drop = i;
                }
            }
            
            if (drop != K) {
                heights[drop]++;
                V--;
                continue;
            }
            
			// Check right side
            for (int i = K + 1; i < heights.length && heights[i] <= h; i++) {
                if (heights[i] < h) {
                    h = heights[i];
                    drop = i;
                }
            }
            
			// No matter where 'drop' is, we increment the height of that index.
            heights[drop]++;
            V--;
        }
        
        return heights;
    }
}