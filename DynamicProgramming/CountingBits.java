/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/

// Number i and number i / 2 only differ by 1 bit.
// If the least significant of i is 1, then f(i) = f(i / 2) + 1;
//                                          f(i) = f(i / 2), else


class Solution {
    public int[] countBits(int num) {
        
        int[] array = new int[num + 1];
        
        for(int i = 1; i <= num; i++) {
            array[i] = array[i >> 1] + (i & 1);
        }
        
        
        return array;
    }
}
