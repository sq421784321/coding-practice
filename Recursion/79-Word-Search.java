class Solution {
	/*
		Method 1: Recursion + Backtracking.
		
		Trick 1:
			If some cell of the original board has been travered, we could mark it as some special letter, like '#', to distinguish from the alphabetical letters.
	*/
	
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (helper(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(int r, int c, char[][] board, int index, String word) {
        if (index >= word.length()) {
            return true;
        }
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        char old = board[r][c];
        board[r][c] = '#';
        
        boolean left = helper(r, c - 1, board, index + 1, word);
        boolean right = helper(r, c + 1, board, index + 1, word);
        boolean up = helper(r - 1, c, board, index + 1, word);
        boolean down = helper(r + 1, c, board, index + 1, word);
        
        if (!left && !right && !up && !down) {
            board[r][c] = old;
        }
        
        return left || right || up || down;
    }
}

/*
    A   B   C   E
    S   F   E   S
    A   D   E   E
*/