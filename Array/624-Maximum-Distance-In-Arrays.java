class Solution {
	/*
		Method 1: Iterative
		
		Scan list one by one, to avoid maximum distance happening in the same list,
		keep a max and a min so far, then update maximum distance with the larger one between |max - rowMin| and |rowMax - min|.
	*/
	
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;
        
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int rowMax = array.get(array.size() - 1);
            int rowMin = array.get(0);
            
            ans = Math.max(ans, Math.max(Math.abs(max - rowMin), Math.abs(rowMax - min)));
            
            min = Math.min(min, rowMin);
            max = Math.max(max, rowMax);
        }
        
        return ans;
    }
}