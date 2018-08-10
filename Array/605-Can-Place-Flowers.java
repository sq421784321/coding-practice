class Solution {
    /*  
        Method 1: Iterative
        
        [left, right]: (n + 1) / 2
        [left, right) or (left, right]: n / 2
        (left, right): (n - 1) / 2
    */
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int left = 0, right = 0;
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                left = i;
                right = i;
                
                while (right < flowerbed.length && flowerbed[right] == 0) {
                    right++;
                }

                if (left == 0 && right == flowerbed.length) {
                    count += (right - left + 1) / 2;
                } else if (left == 0 || right == flowerbed.length) {
                    count += (right - left) /2;
                } else {
                    count += (right - left - 1) / 2;
                }
                i = right;
            }
        }
        
        return count >= n;
    }
}