class Solution {
	/*
		Method 1: Iterative
	*/
	
    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());
        
        char[] array = new char[length + 1];
        
        int c = 0;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = array.length - 1;
        
        while (k >= 1) {
            int a = (i >= 0 ? num1.charAt(i) - '0' : 0);
            int b = (j >= 0 ? num2.charAt(j) - '0' : 0);
            int sum = a + b + c;
            
            array[k] = (char)(sum % 10 + '0');
            c = sum / 10;
            
            i--;
            j--;
            k--;
        }
        
        if (c == 1) {
            array[k] = '1';
            return new String(array);
        }
        
        return new String(array, 1, length);
    }
}