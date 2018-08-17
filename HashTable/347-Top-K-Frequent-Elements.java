class Solution {
	/*
		Method 1: Bucket Sort.
		
		Put distinct numbers into different bucket based on their frequencies.
	*/
	
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        
        Map<Integer, Integer> freqMap = getMap(nums);
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int count = e.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(e.getKey());
        }
        
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (k == 0) {
                break;
            }
            if (buckets[i] != null) {
                if (buckets[i].size() <= k) {
                    ans.addAll(buckets[i]);
                    k -= buckets[i].size();
                } else {
                    for (int j = 0; j < k; j++) {
                        ans.add(buckets[i].get(j));
                    }
                    break;
                }
            }
        }
        
        return ans;
    }
    
    private Map<Integer, Integer> getMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
}