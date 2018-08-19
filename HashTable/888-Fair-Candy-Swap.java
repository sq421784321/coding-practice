class Solution {
	/*
		Method 1: HashTable
		
		Time Complexity: O(N)
		Space Complexity: O(N)
	*/
	
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];
        int sumA = 0;
        int sumB = 0;
        Set<Integer> set = new HashSet<>();
        
		for (int num : A) {
            sumA += num;
        }
        
        for (int num : B) {
            sumB += num;
            set.add(num);
        }
        
        helper(A, B, sumA - sumB, set, ans);
        return ans;
    }
    /*
		Assume: A = [1, 1], B = [2, 2]
		sumA = 2, sumB = 4, diff = 2 - 4 = -2
		
		equalSum = (sumA + sumB) / 2 = sumA - (sumA - sumB) / 2 = sumA - diff / 2
		
		For each num in A:
			newSum = sumA - num
			equalSum = sumA - diff / 2
			if (equalSum - newSum == num - diff / 2) in arrayB:
				we find answer
		
	*/
    private void helper(int[] A, int[] B, int diff, Set<Integer> set, int[] ans) {
        for (int num : A) {
            if (set.contains(num - diff / 2)) {
                ans[0] = num;
                ans[1] = num - diff / 2;
                return;
            }
        }
    }
}