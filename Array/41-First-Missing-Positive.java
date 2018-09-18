class Solution {
	/*
		Method 1: Sort.
		
		Intuition: put each positive number into its right position. For example, put 1 to first position (index = 0), put 2 to second position (index = 1), and so on.
		Note: 1. Be sure nums[nums[i] - 1] != nums[i] to avoid infinite loop.
			  2. Be sure nums[i] is not out of bounds.
	*/
	
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int value = nums[i];
            while (nums[i] <= nums.length && nums[i] >= 1 && nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}