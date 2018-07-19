class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> destack = new LinkedList<>();
        if (nums == null || nums.length == 0) return nums;
        
        int[] res = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            
            int cur = nums[i];
            
            while (!destack.isEmpty() && nums[destack.peekLast()] < cur) {
                destack.pollLast();
            }
            
            destack.offerLast(i);
            
            if (i >= k - 1) {
                // [i - k + 1 , i]
                if (destack.peekFirst() < i - k + 1) {
                    destack.pollFirst();
                }
                res[i - k + 1] = nums[destack.peekFirst()];
            }
        }
        
        return res;
    }
}