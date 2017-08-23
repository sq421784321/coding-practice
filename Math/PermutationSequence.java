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
