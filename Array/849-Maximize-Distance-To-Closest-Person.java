class Solution {
	/*
		Method 1: Iterative.
		
	*/
	
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int left = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (left == -1) {
                    ans = Math.max(ans, i);
                } else {
                    ans = Math.max(ans, (i - left) / 2);
                }
                left = i;
            }
        }
        ans = Math.max(ans, seats.length - left - 1);
        return ans;
    }
}