class Solution {
	/*
		Method 1: Iterative.
	*/
	
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            char pre = S.charAt(i - 1);
            if (cur == pre) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> array = new ArrayList<>();
                    array.add(i - count);
                    array.add(i - 1);
                    ans.add(array);
                }
                count = 1;
            }
        }
        if (count >= 3) {
            List<Integer> array = new ArrayList<>();
            array.add(S.length() - count);
            array.add(S.length() - 1);
            ans.add(array);
        }
        
        return ans;
    }
}