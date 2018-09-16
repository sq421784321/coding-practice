class Solution {
	/*
		Method 1: Two Pointers.
	*/
	
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ans[left] = A[i];
                left++;
            } else {
                ans[right] = A[i];
                right--;
            }
        }
        
        return ans;
    }
}