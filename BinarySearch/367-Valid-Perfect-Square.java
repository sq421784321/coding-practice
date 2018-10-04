class Solution {
	/*
		Method 1: Binary Search.
		
	*/
	
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return false;
    }
	
	/*
		Method 2: Newton Method.
		
		public boolean isPerfectSquare(int num) {
			long x = num;
			while (x * x > num) {
				x = (x + num / x) / 2;
			}
			return x * x == num;
		}
	*/
}