// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, 
// replace the number by the sum of the squares of its digits, 
// and repeat the process until the number equals 1 (where it will stay), 
// or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 1 * 1 + 9 * 9 = 82
// 8 * 8 + 2 * 2 = 68
// 6 * 6 + 8 * 8 = 100
// 1 * 1 + 0 * 0 + 0 * 0 = 1

class Solution {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        
        while(n >= 10) {
            int sum = 0;
            int tmp = n;
            while(tmp > 0) {
                sum += (tmp % 10) * (tmp % 10);
                tmp = tmp / 10;
            }
            n = sum;
        }
        
        return n == 1 || n == 7;
    }
}
  
  
