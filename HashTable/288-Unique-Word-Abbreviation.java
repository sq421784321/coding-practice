class ValidWordAbbr {
    private Map<String, String> map = new HashMap<>();
    private Set<String> falseSet = new HashSet<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            String original = map.get(abbr);
            if (original == null) {
                map.put(abbr, word);
            } else if (!word.equals(original)) {
                falseSet.add(abbr);
            }
        }
    }
    
    private String getAbbr(String word) {
        if (word == null || word.length() <= 2) return word;
        return word.charAt(0) + "" + (word.length() - 2) + word.charAt(word.length() - 1);
    }
    
    public boolean isUnique(String word) {
        // if the whole word exists in the dic, and no other words have same abbr, return true
        //                                      otherwise, return false
        // if the whole word not exists in the dic, and no other words have same abbr, return true
        //                                      otherwise, return false

        String abbr = getAbbr(word);
        if (falseSet.contains(abbr)) {
            return false;
        } else {
            return word.equals(map.getOrDefault(abbr, word));
        }
    }
    
}




/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */