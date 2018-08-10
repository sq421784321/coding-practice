class Solution {
    /*
        Method 1 : Greedy
        
        1. locate the leftmost digit which has larger digits to its right
        2. locate the rightmost larger digit
        3. swap
    */
    
    public int maximumSwap(int num) {
        char[] array = String.valueOf(num).toCharArray();
        int[] pos = new int[10];
        for (int i = 0; i < array.length; i++) {
            pos[array[i] - '0'] = i;
        }
        
        int index = 0;
        while (index < array.length) {
            char cur = array[index];

            int larger = pos.length - 1;            
            for (; larger >= 0; larger--) {
                if (larger > (cur - '0') && pos[larger] > index) {
                    break;
                }
            }
            
            if (larger >= 0) {
                char temp = array[index];
                array[index] = array[pos[larger]];
                array[pos[larger]] = temp;
                break;
            }
            index++;
        }
        
        return Integer.valueOf(new String(array));
    }
}