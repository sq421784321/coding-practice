class Solution {
	/*
		Method 1: Iterative.
		
		Simply find each word and reverse it. In place.
	*/
	
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == ' ') {
                reverse(left, i - 1, array);
                left = i + 1;
            }
        }
        reverse(left, array.length - 1, array);
        
        return new String(array);
    }
    
    private void reverse(int l, int r, char[] array) {
        while (l < r) {
            char tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
    }
}