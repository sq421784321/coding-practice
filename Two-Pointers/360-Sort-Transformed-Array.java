class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        
        if (a > 0) {
            int left = 0, right = nums.length - 1;
            int index = nums.length - 1;
            
            while (left <= right) {
                int leftValue = getValue(nums[left], a, b, c);
                int rightValue = getValue(nums[right], a, b, c);
                
                if (leftValue > rightValue) {
                    ans[index] = leftValue;
                    left += 1;
                } else {
                    ans[index] = rightValue;
                    right -= 1;
                }
                index -= 1;
            }
            
        } else {
            int left = 0, right = nums.length - 1;
            int index = 0;
            
            while (left <= right) {
                int leftValue = getValue(nums[left], a, b, c);
                int rightValue = getValue(nums[right], a, b, c);
                
                if (leftValue < rightValue) {
                    ans[index] = leftValue;
                    left += 1;
                } else {
                    ans[index] = rightValue;
                    right -= 1;
                }
                index += 1;
            }
        }
        
        
        return ans;
    }
    
    private int getValue(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}