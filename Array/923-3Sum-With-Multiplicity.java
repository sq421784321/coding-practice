class Solution {
	/*
		Method 1: HashMap.
		
		First of all, build the frequency map.
		Then, sort the entire array, start from the lowest element, try to find the bigger two elements.
		Next, scan the frequency map to get the valid tuples.
	*/
	
    public int threeSumMulti(int[] A, int target) {
        int[] map = new int[101];   
        Arrays.sort(A);
        for (int num : A) {
            map[num] += 1;
        }
        
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int t = target - A[i];
            map[A[i]] -= 1;
            
            int left = A[i];
            
            while (left <= t - left) {
                if (t - left <= 100) {
                    if (left < t - left) {
                        ans += map[left] * map[t - left]; 
                    } else {
                        if (map[left] >= 2) {
                            ans += map[left] * (map[left] - 1) / 2;
                        }
                    }
                    ans = ans % (1000000000 + 7);
                }
                left += 1;
            }
        }
        return ans;
    }
}