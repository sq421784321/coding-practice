class Solution {
	/*
		Method 1: BFS
		
		One directional BFS.
			curNode
			/		\
		neighbors	neighbors
		  /	 \		/  \
		nn	 nn	   nn  nn(end ? return)
		
		Can be optimized to bidirectional BFS. (beginSet, endSet)
	*/
	
    public int minMutation(String start, String end, String[] bank) {
        boolean[] visited = new boolean[bank.length];
        Deque<String> queue = new LinkedList<>();
        queue.offerLast(start);
        
        int step = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0){
                String cur = queue.pollFirst();
            
                for (int i = 0; i < bank.length; i++) {
                    if (!visited[i]) {
                        int diff = countDiff(bank[i], cur);
                        if (diff == 1 && bank[i].equals(end)) {
                            return step;
                        }                        
                        if (diff == 1) {
                            queue.offerLast(bank[i]);
                            visited[i] = true;
                        }
                    }
                }
                
                size--;
            }
            step++;
        }
        
        return -1;
    }
    
    private int countDiff(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}