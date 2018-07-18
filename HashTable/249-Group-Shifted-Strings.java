class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        // key: unique pattern
        // val: index of the result list 
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();
            
        for (String str : strings) {
            String value = getUniqueVal(str);
            
            Integer index = map.get(value);
            if (index == null) {
                List<String> list = new ArrayList<String>();
                list.add(str);
                ans.add(list);
                map.put(value, ans.size() - 1);
            } else {
                List<String> list = ans.get(map.get(value));
                list.add(str);
            }
        }
        
        return ans;
    }
    
    private String getUniqueVal(String str) {
        char[] array = str.toCharArray();
        
        int offset = array[0] - 'a';
        
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] - offset) < 'a' ? (char)(array[i] - offset + 26) : (char)(array[i] - offset);
        }
        
        return new String(array);
    }
    
    // private int getUniqueVal(String str) {
    //     int ans = 0;
    //     for (int i = 1; i < str.length(); i++) {
    //         int cur = str.charAt(i) - str.charAt(i - 1);
    //         if (cur < 0) cur += 26;
    //         ans *= 26;
    //         ans += cur;
    //     }
    //     return ans;
    // }
}