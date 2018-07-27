class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        // Time: O(n), Space: O(n)
        Map<String, Integer> freqMap = getMap(words);
        
        // Create a minHeap to store map entry
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() != e2.getValue()) {
                    return e1.getValue() - e2.getValue();
                } else {
                    return e2.getKey().compareTo(e1.getKey());
                }
            }
        }); 
        
        // Time: O(n * logk)
        for (Map.Entry<String, Integer> cur: freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(cur);
            } else {
                if (cur.getValue() > minHeap.peek().getValue()){
                    minHeap.poll();
                    minHeap.offer(cur);
                } else if (cur.getValue() == minHeap.peek().getValue() && cur.getKey().compareTo(minHeap.peek().getKey()) < 0) {
                    minHeap.poll();
                    minHeap.offer(cur);
                }
            }
        }
        
        //List<String> ans = new ArrayList<>();
        String[] array = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            array[i] = minHeap.poll().getKey();
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