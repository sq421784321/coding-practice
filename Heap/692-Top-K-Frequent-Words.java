class Solution {
    /*
        Method 1: PriorityQueue
        
        Time: O(n * log k), Space: O(n)
    */
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = getMap(words);
        
        // minHeap to sort map entries in ascending order (freq small first, alphabetical large first)
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() != e2.getValue()) {
                    return e1.getValue() - e2.getValue();
                }
                return e2.getKey().compareTo(e1.getKey());
            }
        }); 
        
        for (Map.Entry<String, Integer> cur: freqMap.entrySet()) {
            minHeap.add(cur);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Append from the rightmost position
        String[] array = new String[minHeap.size()];
        while (!minHeap.isEmpty()) {
            array[minHeap.size() - 1] = minHeap.poll().getKey();
        }
        return Arrays.asList(array);
    }
    
    private Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
}