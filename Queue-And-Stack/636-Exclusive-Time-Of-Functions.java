class Solution {
	/*
		Method 1: Stack.
		
		Pay attention to the "time", when a job "starts", it starts at the very beginning of that time,
		when a job "ends", it ends at the very end of that time.
	*/
	
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        int prevTime = 0;
        
        for (String log : logs) {
            String[] parts = log.split(":");
            
            int id = Integer.valueOf(parts[0]);
            String property = parts[1];
            int time = Integer.valueOf(parts[2]);
            
            if (property.equals("start")) {
                if (!stack.isEmpty()) {
                    int lastJob = stack.peekLast();
                    ans[lastJob] += time - prevTime;
                }
                stack.offerLast(id);
                prevTime = time;
            } else {
                ans[stack.pollLast()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        
        return ans;
    }
}