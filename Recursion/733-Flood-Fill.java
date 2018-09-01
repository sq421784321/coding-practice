class Solution {
	/*
		Method 1: Recursion.
		
		Replace all the cells with same color as the given cell. 
	*/
	
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    private void helper(int[][] image, int row, int col, int newColor, int oldColor) {
        // base case
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        
        image[row][col] = newColor;
        
        helper(image, row + 1, col, newColor, oldColor);
        helper(image, row - 1, col, newColor, oldColor);
        helper(image, row, col + 1, newColor, oldColor);
        helper(image, row, col - 1, newColor, oldColor);
    }
}