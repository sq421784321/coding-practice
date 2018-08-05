class Solution {
	/*
		Method 1: Iterative.
		Memory Limit Exceed.
	*/
	
	
	/*
		Method 2: Recursion.
		The idea is if we meet a number, we only calculate the exact string length, once it reaches or exceeds K, we do a module operation to K,
		because our final answer would be at somewhere in S[0, i - 1].
		If we meed a letter, we just need to check whether we reach K.
	*/
    public String decodeAtIndex(String S, int K) {
        long cur = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= '2' && c <= '9') {
                int count = c - '0';
                if (cur * count >= K) {
                    String str = S.substring(0, i);
                    return decodeAtIndex(str, (int)((K - 1) % cur + 1));
                } else {
                    cur *= count;
                }
            } else {
                cur += 1;
                if (cur == K) {
                    return S.substring(i, i + 1);
                }
            }
        }
        return "";
    }
}