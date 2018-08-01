class Solution {
    // Method 1: 
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) > 1) return false;
        }
        return true;
    }
    
    
    // Method 2: Overthinking version :P
    /*
    public boolean isIdealPermutation(int[] A) {
        int global = 0;
        int local = 0;
        int[] map = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            int cur = A[i];            
            for (int j = cur + 1; j < A.length; j++) {
                map[j]++;
            }            
            global += map[cur];
            if (i + 1 < A.length && A[i] > A[i + 1]) local++;            
        }
        return local == global;
    }
    */
}