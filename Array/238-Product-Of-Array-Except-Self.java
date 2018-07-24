// Method 1: 3 Pass. Time: O(n). Space: O(n)
// Method 2: 2 Pass. Time: O(n). Space: O(1)

// Method 2
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int cur = 1;
        int left = 1;
        int right = 1;
        
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left;
            left *= nums[i];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }
        
        return ans;
    }
}