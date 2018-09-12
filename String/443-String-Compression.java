class Solution {
	/*
		Method 1 : Two Pointers.
		
		One pointer is to keep track of the final answer, and the other pointer is to go through all the elements of the original array.
	*/
	
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        
        while (right < chars.length) {
            chars[left] = chars[right];
            
			// Count the repeated times
			int count = 0;
            while (right < chars.length && chars[right] == chars[left]) {
                right++;
                count++;
            }
            
            left += 1;
            int l = left;
			
			// Condition 1: repeated times > 1
            if (count > 1) {
                while (count > 0) {
                    chars[left] = (char)(count % 10 + '0');
                    count /= 10;
                    left++;
                }
                reverse(chars, l, left - 1);
            }
			// Condition 2: repeated times == 1
			// Do nothing.
        }
        
        return left;
    }
    
    private void reverse(char[] array, int l, int r) {
        while (l < r) {
            char tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
            l++;
            r--;
        }
    }
}