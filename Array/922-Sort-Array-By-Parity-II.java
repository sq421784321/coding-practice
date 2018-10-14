class Solution {
	/*
		Method 1: Iterative.
		
		Keep the current position of odd parity and even parity, then update whenever dismatch happens. 
	*/
	
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int i = 0;
        
        while (i < A.length) {
            if (i % 2 == 0) {
                if (A[i] % 2 != 0) {
                    swap(A, i, odd);
                    odd += 2;
                    i -= 1;
                }
            } else {
                if (A[i] % 2 == 0) {
                    swap(A, i, even);
                    even += 2;
                    i -= 1;
                }
            }
            i += 1;
        }
        
        return A;
    }
    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}