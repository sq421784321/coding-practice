class Solution {
    /*
            a   b   c   d
            b   e   f   d  
            c   f   
            d   d   a   
    
    */
    
	/*
		Method 1: Iterative
		
		Check each row and related column.
		
		Be careful of the index out-of-bound.
	*/
	
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String row = words.get(i);
            int j = 0;
            for (; j < row.length(); j++) {
                char rowChar = row.charAt(j);
                
                if (j >= words.size() || i >= words.get(j).length() || words.get(j).charAt(i) != rowChar) {
                    return false;
                }
            }
            
            if (j < words.size() && words.get(j).length() >= i + 1) {
                return false;
            }
            
        }
        
        return true;
    }
}