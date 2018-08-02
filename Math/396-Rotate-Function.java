class Solution {
    public int maxRotateFunction(int[] A) {
        int max = 0;
        int sum = 0;
        int f = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            f += i * A[i];
        }
        
        max = f;
        for (int i = 1; i < A.length; i++) {
            f = f + sum - A.length * A[A.length - i];
            max = Math.max(f, max);
        }
        
        return max;
    }
    
    /*
        sum = sum(A);
        
        F(0) = 0 * A[0] + 1 * A[1] + ... + (n - 1) * A[n - 1]
        
        F(1) = F(0) + sum - (n) * A[n - 1]
        F(2) = F(1) + sum - (n) * A[n - 2]
        ...
        F(n) = F(n - 1) + sum - (n) * A[0]
    
    */
}