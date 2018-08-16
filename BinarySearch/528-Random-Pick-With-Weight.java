class Solution {
	/*
		Method 1: Random & Binary Search.
		
		Time Complexity: O(log n)
		
		Get the total number, get a random number from [1, sum], find where it's located
	*/
	
    int[] array;
    Random rd = new Random();
    
    public Solution(int[] w) {
        array = new int[w.length];
        
        for (int i = 0; i < w.length; i++) {
            array[i] = (i == 0 ? w[i] : w[i] + array[i - 1]);
        }
    }
    
    public int pickIndex() {
        int num = rd.nextInt(array[array.length - 1]) + 1;
        
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */