class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        int count = 0;
        
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
            if (map[c - 'a'] == 1) {
                count++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
                
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map[cur - 'a'] == 1) {
                count--;
            }
            map[cur - 'a']--;
            
            if (i >= p.length()) {
                char pre = s.charAt(i - p.length());
                map[pre - 'a']++;
                if (map[pre - 'a'] == 1) {
                    count++;
                }
            }
            
            if (count == 0) {
                ans.add(i - p.length() + 1);
            }
        }
        
        return ans;
    }
}