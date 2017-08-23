// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.


class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i; // {1, 1, 2, 6, 24, 120, ...}
        }
        
        for(int i = 1; i <= n; i++) {
            list.add(i);  // {1, 2, 3, 4, ...}
        }
        
        k--;
        
        for(int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(list.get(index));
            list.remove(index);
            k -= index * factorial[n - i];
        }
        
        return sb.toString();
    }
}
