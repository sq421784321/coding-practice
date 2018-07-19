class Solution {
    private Map<Character, Character> map;
    private char[] one = {'0', '1', '8'};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        map = getMap();
        
        helper((n - 1) / 2, n / 2, "", ans);
        
        return ans;
    }
    
    private void helper(int left, int right, String str, List<String> ans) {
        if (left < 0) {
            ans.add(str);
            return;
        }
        
        if (left == right) {
            for (int i = 0; i < one.length; i++) {
                String next = one[i] + str;
                helper(left - 1, right + 1, next, ans);
            }
        } else if (left > 0) {
            for (char c : map.keySet()) {
                String next = c + str + map.get(c);
                helper(left - 1, right + 1, next, ans);
            }
        } else {
            for (char c : map.keySet()) {
                if (c != '0') {
                    String next = c + str + map.get(c);
                    helper(left - 1, right + 1, next, ans);
                }
            }
        }
        
    }
    
    private Map<Character, Character> getMap() {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        return map;
    }
}