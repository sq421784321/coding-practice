class LogSystem {
	/*
		Method 1: HashTable.
		
		Put(): O(1)
		Retrieve(): O(N)
		
	*/
	
    Map<Integer, String> map;
    
    public LogSystem() {
        map = new HashMap<>();
    }
    
    public void put(int id, String timestamp) {
        map.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ans = new ArrayList<>();
        int target = 0;
        
        switch(gra) {
            case "Year":
                target = 4;
                break;
            case "Month":
                target = 7;
                break;
            case "Day":
                target = 10;
                break;
            case "Hour":
                target = 13;
                break;
            case "Minute":
                target = 16;
                break;
            case "Second":
                target = 19;
                break;
        }
        
        s = s.substring(0, target);
        e = e.substring(0, target);
        
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            String value = entry.getValue().substring(0, target);
            if (s.compareTo(value) <= 0 && e.compareTo(value) >= 0) {
                ans.add(entry.getKey());
            }
        }
        
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */