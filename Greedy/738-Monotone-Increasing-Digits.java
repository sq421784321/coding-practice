class Solution {
    // Discussion Solution
    // Clean code.
    public int monotoneIncreasingDigits(int N) {
        int ans = 0;
        int power = 1;
        int prevDigit = 9;
        
        while (N > 0) {
            int curDigit = N % 10;
            if (curDigit <= prevDigit) {
                ans += power * curDigit;
            } else {
                curDigit -= 1;
                ans = curDigit * power + (power - 1);
            }
            N /= 10;
            power *= 10;
            prevDigit = curDigit;
        }
        return ans;
    }
    
    // My solution
    // Ugly code.
    /* 
    public int monotoneIncreasingDigits(int N) {
        if (N <= 9) return 0;
    
        int[] array = getDigitArray(N);
        int ans = 0;
        int power = (int)Math.pow(10, array.length - 1);
        
        for (int i = 0; i < array.length; i++) {
            int cur = i;
            while (cur - 1 >= 0 && array[cur - 1] > array[cur]) {
                array[cur - 1] -= 1;
                array[cur] = 9;
                cur -= 1;
            }
            if (cur != i) {
                for (int j = i + 1; j < array.length; j++) {
                    array[j] = 9;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            ans += array[i] * power;
            power /= 10;
        }
        return ans;
    }
    
    private int[] getDigitArray(int N) {
        int digits = 0;
        int tmp = N;
        
        while (tmp > 0) {
            tmp /= 10;
            digits++;
        }
        int[] array = new int[digits];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = N % 10;
            N /= 10;
        }
        return array;
    }
    */
}
