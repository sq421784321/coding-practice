class Solution {
	/*
		Method 1: Iterative.
		
		Enumerate all the cases.
		1. Two strings with different length.
		2. Two strings with same length and duplicate chars.
		3. Two strings with same length but no duplicate chars, and only have two chars with different order.
	*/
	
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        
        if (A.equals(B)) {
            Set<Character> set = new HashSet<>();
            for (char c: A.toCharArray()) {
                if (!set.add(c)) {
                    return true;
                }
            }
            return false;
        }
        
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            }
        }
        
        return diff.size() == 2 && A.charAt(diff.get(0)) == B.charAt(diff.get(1)) && A.charAt(diff.get(1)) == B.charAt(diff.get(0));
    }
}