class Solution {
    /*
        Method 1 : try to find the pattern.
        
		Two conditions:
		k = odd
		k = even
		
		k = 3	1 5 2 3 4
		k = 2	1 5 4 3 2
		
        1 2 3 4 5 k = 1
        1 2 3 5 4 k = 2
        1 2 5 3 4 k = 3
        1 5 2 4 3 k = 4
    */
    
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        
        int small = 1;
        int large = n;
        
        int index = 0;
        int count = k;
        
        while (count > 0) {
            if (index % 2 == 0) {
                ans[index] = small;
                small++;
            } else {
                ans[index] = large;
                large--;
            }
            index++;
            count--;
        }
        
        if (k % 2 == 0) {
            for (; index < n; index++) {
                ans[index] = large;
                large--;
            }
        } else {
            for (; index < n; index++) {
                ans[index] = small;
                small++;
            }
        }
        
        return ans;
    }
}