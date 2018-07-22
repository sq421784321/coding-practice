class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        long total = 0;
        for (int pile : piles) {
            total += pile;
        }
        
        long min = (total % H > 0 ? 1 : 0) + total / H;
        long max = piles[piles.length - 1];
        
        while (min < max) {
            long mid = min + (max - min) / 2;
            
            if (canFinish(mid, piles, H)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return (int)min;
    }
    
    private boolean canFinish(long k, int[] piles, int H) {
        long curH = 0;
        for (int pile: piles) {
            curH += pile % k > 0 ? 1 : 0;
            curH += pile / k;
        }
        
        return curH <= H;
    }
}