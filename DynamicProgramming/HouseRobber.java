/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint /nstopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the /npolice if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob <br />tonight without alerting the police.
*/


class Solution {
    // f(i) = max(A[i] + f(i - 2), f(i - 1))
    public int rob(int[] nums) {
        int prev = 0, cur = 0;
        for(int i = 0; i < nums.length; i++) {
            int tmp = cur;
            cur = Math.max(prev + nums[i], cur);
            prev = tmp;
        }
        return cur;
    }
}
