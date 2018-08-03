class Solution {
    public void rotate(int[] nums, int k) {
        /*
            Method 1:
            1. Reverse the whole array
            2. reverse the first k elements
            2. reverse the last (n - k) elements
        */
        
        /*
            Method 2:
            move each element to the kth position to its right
            keep moving
            until back to index=0
        */
        int n = nums.length;
        int count = 0;
        k = k % n;
        
        for (int i = 0; i < k; i++) {
            if (count == n) {
                break;
            }
            int cur = i;
            int val = nums[i];
            while ((cur + k) % n != i) {
                int next = (cur + k) % n;
                int nextVal = nums[next];
                nums[next] = val;
                val = nextVal;
                cur = next;
                count++;
            }
            nums[i] = val;
            count++;
        }
    }
}