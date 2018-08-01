class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;
        int curr = cost[0];
        
        for (int i = 1; i <= cost.length; i++) {
            int c = (i == cost.length) ? 0 : cost[i];
            int tmp = curr;
            curr = c + Math.min(prev, curr);
            prev = tmp;
        }
        
        return curr;
    }
}