class Solution {
	/*
		Method 1: HashTable
		
		Store all the unique contents and related (dir + filename).
	*/
	
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            
            for (int i = 1; i < parts.length; i++) {
                int idx = parts[i].indexOf("(");
                String filename = parts[i].substring(0, idx);
                String content = parts[i].substring(idx + 1, parts[i].length() - 1);
                
                List<String> list = map.get(content);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(dir + "/" + filename);
                map.put(content, list);
            }
        }
        
        for (List<String> list : map.values()) {
            if (list.size() >= 2) {
                ans.add(list);
            }
        }
        
        return ans;
    }
}