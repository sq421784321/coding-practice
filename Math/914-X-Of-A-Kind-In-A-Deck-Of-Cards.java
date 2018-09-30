class Solution {
	/*
		Method 1: Math + Greatest Common Divisor.
	*/
	
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        
        int cur = 0;       
        for (int key: map.keySet()) {
            cur = gcd(cur, map.get(key));
			if (cur == 1) {
				return false;
			}
        }
        
        return cur > 1;
    }
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}