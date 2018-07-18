class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String word : d) {
            if (canDelete(s, word) && (ans.equals("") || word.length() > ans.length() || (word.length() == ans.length() && ans.compareTo(word) > 0))) {
                ans = word;
            }
        }
        return ans;
    }
    
    private boolean canDelete(String source, String ter) {
        if (ter.length() > source.length() || (ter.length() == source.length() && !ter.equals(source))) {
            return false;
        }
        
        int terIndex = 0;
        for (int i = 0; i < source.length() && terIndex < ter.length(); i++) {
            if (source.charAt(i) == ter.charAt(terIndex)) {
                terIndex++;
            }
        }
        return terIndex == ter.length();
    }
}