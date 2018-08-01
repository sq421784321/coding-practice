class Solution {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        Set<Integer> primes = getPrimeSet();
        
        for (int i = L; i <= R; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                count += (num & 1);
                num >>= 1;
            }
            ans += (primes.contains(count) ? 1 : 0);
        }
        
        return ans;
    }
    
    private Set<Integer> getPrimeSet() {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(11);
        set.add(13);
        set.add(17);
        set.add(19);
        return set;
    }
}