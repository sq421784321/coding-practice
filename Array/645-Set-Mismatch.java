class Solution {
	/*
		Method 1: HashSet.
		
		Method 2: Put into right slot.
		
		Swap each element and put it into its right final slot (for example, values are from 1 to n, so after swap, nums[i] should be equal to i + 1)
	*/
	
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        // Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans[0] = nums[i];
                ans[1] = i + 1;
            }
        }
        
        return ans;
    }
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}