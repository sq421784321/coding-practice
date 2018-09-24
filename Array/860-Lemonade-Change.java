class Solution {
	/*
		Method 1: Greedy.
		
		Every time try to exchange with the largest posible bill first.
	*/
	
    public boolean lemonadeChange(int[] bills) {
        int[] map = new int[3];
        
        for (int bill : bills) {
            if (bill == 5) {
                map[0]++;
            } else if (bill == 10) {
                map[0]--;
                map[1]++;
            } else {
                if (map[1] > 0) {
                    map[1]--;
                    map[0]--;
                    map[2]++;
                } else {
                    map[0] -= 3;
                }
            }
            
            if (map[0] < 0) {
                return false;
            }
        }
        
        return true;
    }
}
