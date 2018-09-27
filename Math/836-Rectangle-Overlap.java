class Solution {
	/*
		Method 1: Overlap Check.
		
		Determine the relative position of these two rectangles.
		
		4 cases where there are no overlap:
		1) one is to the right of the other
		2) one is to the left of the other
		3) one is to the upper of the other
		4) one is to the down of the other
	*/
	
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        long x = Math.max((long)(Math.min(rec2[2], rec1[2]) - Math.max(rec2[0], rec1[0])), 0);
        long y = Math.max((long)(Math.min(rec2[3], rec1[3]) - Math.max(rec2[1], rec1[1])), 0); 
        
        return x * y > 0;
    }
}
