class Solution {
    /*
		Method 1: Iterative.
		
		ToLowerCase() without the built-in method.
	*/
	
	public String toLowerCase(String str) {
        if (str == null || str.isEmpty()) return str;
        
        char[] array = str.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c >= 'A' && c <= 'Z') {
                array[i] = (char)(c - 'A' + 'a');
            }
        }
        
        return new String(array);
    }
}