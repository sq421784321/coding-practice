/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/




class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], n = nums.length;
        
        int product = 1;
        for(int i = 0; i < n; i++) {
            product *= nums[i];
            if(product > max) max = product;
            if(nums[i] == 0) product = 1;
        }
        
        product = 1;
        for(int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            if(product > max) max = product;
            if(nums[i] == 0) product = 1;
        }
        
        return max;
    }
}
