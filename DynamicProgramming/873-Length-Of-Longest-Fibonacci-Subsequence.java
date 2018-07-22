class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < A.length; i++) index.put(A[i], i);
        Map<Integer, Integer> longest = new HashMap<>();
        int max = 0;
        for (int k = 2; k < A.length; k++) {
            for (int j = k - 1; j >= 1; j--) {
                int i = index.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && j > i) {
                    // we have two pairs now: 
                    // [i, j] and [j, k]
                    // longest([j, k]) = longest([i, j]) + 1, if i + j == k
                    int length = longest.getOrDefault(i * A.length + j, 2) + 1;
                    longest.put(j * A.length + k, length);
                    max = Math.max(length, max);
                }
            }
        }
        return max;
    }
}