class Solution {
	/*
		Method 1: Sliding Window + Counter.
	*/
	
    public int totalFruit(int[] tree) {
        int ans = 0;
        
        int left = 0;
        int[] map = new int[tree.length];
        int count = 0;
        
        for (int i = 0; i < tree.length; i++) {
            int cur = tree[i];
            
            map[cur]++;
            
            if (map[cur] == 1) {
                count += 1;
            }
            
            while(count == 3 && left < i) {
                int old = tree[left];
                
                map[old]--;
                
                if (map[old] == 0) {
                    count -= 1;
                }
                left++;
            }
            
            ans = Math.max(ans, i - left + 1);
        }
        
        return ans;
    }
}