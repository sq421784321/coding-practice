class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && i - 1 >= 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            } else if (i % 2 == 1 && i - 1 >= 0 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}