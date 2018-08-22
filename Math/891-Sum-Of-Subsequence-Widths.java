class Solution {
    /*
        Method 1: Iterative. Find the pattern.
        
        First, sorting the array will not affect the final result.
        Second, after sort, for each index i, there are i numbers smaller than A[i], n - 1 - i numbers larger than A[i].
            Hence, there are 2 ^ i sequences where A[i] is the largest number
                   there are 2 ^ (n - 1 - i) sequences where A[i] is the smallest number.
            So, we do ans += A[i] * (2 ^ i) - A[i] * (2 ^ (n - 1 - i))
        
    */
    
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        
        long ans = 0;
        long mod = (long)(1e9 + 7);
        long c = 1;
        
        for (int i = 0; i < A.length; i++, c = (c << 1) % mod) {
            ans = (ans + A[i] * c - A[A.length - 1 - i] * c) % mod;
        }
        
        return (int)((ans + mod) % mod);
    }
}