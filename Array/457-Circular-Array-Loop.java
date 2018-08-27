class Solution {
    /*
        Method 1: Fast & Slow pointer.
        
        If there is a loop, fast and slow pointer will meet eventually.
        If not, set numbers all along the path to 0 to indicate visited status.
    */
    
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            
            int slow = i;
            int fast = i;
            while (nums[slow] * nums[i] > 0 && nums[fast] * nums[i] > 0) {
                slow = next(slow, nums);
                fast = next(next(fast, nums), nums);
                if (slow == fast) {
                    // Exception : one number case
                    if (slow == next(slow, nums)) {
                        break;
                    }
                    return true;
                }
            }
            
            // Set numbers all along the path to 0
            slow = i;
            while (nums[slow] * nums[i] > 0) {
                int tmp = next(slow, nums);
                nums[slow] = 0;
                slow = tmp;
            }
        }
        return false;
    }
    
    // Get next valid index
    private int next(int i, int[] nums) {
        int next = i + nums[i];
        return (next + nums.length) % nums.length;
    }
}