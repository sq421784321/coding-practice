class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freqMap = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        
        for (String word : banned) {
            banSet.add(word);
        }
        
        String[] words = paragraph.replaceAll("[!?',;.]", "").toLowerCase().split(" ");
        String ans = "";
        freqMap.put(ans, 0);
        
        for (String word: words) {
            if (banSet.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            ans = freqMap.get(ans) < freqMap.get(word) ? word : ans;
        }
        
        return ans;
    }
}