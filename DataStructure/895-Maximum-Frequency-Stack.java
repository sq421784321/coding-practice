class FreqStack {
	/*
		Method 1: HashMap of Stack.
		
		levelMap: {frequency: stack of numbers}
		freqMap: {number: frequency}
		
		For example:
		5 -> 1 -> 5 -> 2 -> 5 -> 1 -> 4
		
		levelMap: {
			1 : {5, 1, 2, 4}
			2 : {5, 1}
			3 : {5}
		}
		freqMap: {
			1:2
			2:1
			4:1
			5:3
		}
	*/
	
    private int maxFreq = 0;
    private Map<Integer, Deque<Integer>> levelMap; 
    private Map<Integer, Integer> freqMap;
    
    public FreqStack() {
        freqMap = new HashMap<>();
        levelMap = new HashMap<>();
    }
    
    public void push(int x) {
        int newFreq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, newFreq);
        maxFreq = Math.max(maxFreq, newFreq);
        
        Deque<Integer> stack = levelMap.get(newFreq);
        if (stack == null) {
            stack = new LinkedList<>();
        }
        stack.offerLast(x);
        levelMap.put(newFreq, stack);
    }
    
    public int pop() {
        int res = levelMap.get(maxFreq).pollLast();
        freqMap.put(res, maxFreq - 1);
        if (levelMap.get(maxFreq).size() == 0) {
            maxFreq -= 1;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */