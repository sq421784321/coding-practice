class Solution {
	/*
		Method 1: Iterative.
		
		Figure out the total number of shift for each index.
	*/
	
    public String shiftingLetters(String S, int[] shifts) {
        int shift = 0;
        char[] array = S.toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            shift += shifts[i];
            shift %= 26;
            
            char old = array[i];
            array[i] = (char)((old + shift - 'a') % 26 + 'a');
        }
        
        return new String(array);
    }
}