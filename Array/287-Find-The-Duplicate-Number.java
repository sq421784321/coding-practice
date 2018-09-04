class Solution {
	/*
		Method 1: Slow & Fast pointers.
		
		Step 1: Find the meet point p1 using slow and fast pointers. Slow pointer moves one step each time, while fast pointer moves two step each time.
		Step 2: Find the entrance p2 of the circle. Reset slow pointer, and move slow pointer and fast pointer one step each time, they will meet at the entrance eventually.
		
		Time Complexity: O(N)
		Space Complexity: O(1)
	*/
	
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}