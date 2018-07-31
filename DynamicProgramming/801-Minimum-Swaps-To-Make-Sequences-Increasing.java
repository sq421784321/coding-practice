class Solution {
    public int minSwap(int[] A, int[] B) {
        // swap : minimum number of swaps to make A[0, i - 1] increasing, and A[i - 1] is swapped if necessary
        // unswap: minimum number of swaps to make A[0, i - 1] increasing, and A[i - 1] is unswapped if necessary
        int swap = 1, unswap = 0;
        
        for (int i = 1; i < A.length; i++) {
            int newSwap = A.length, newUnswap = A.length;
            // Condition 1:
            // Both of A[i - 1] and A[i] need to be swapped or unswapped
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                // Both unswap
                newUnswap = Math.min(newUnswap, unswap);
                // Both swap
                newSwap = Math.min(newSwap, swap + 1);
            }
            
            // Condition 2:
            // One of A[i - 1] and A[i] need to be swapped or unswapped
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                // Swap A[i - 1]
                newUnswap = Math.min(newUnswap, swap);
                // Swap A[i]
                newSwap = Math.min(newSwap, unswap + 1);
            }
            
            // Update swap and unswap
            swap = newSwap;
            unswap = newUnswap;
        }
        return Math.min(swap, unswap);
    }
}