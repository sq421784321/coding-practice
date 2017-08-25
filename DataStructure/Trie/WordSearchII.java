Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or 
vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

// First construct a trie, then use backtracking to find the word.

class Solution {
    static class TrieNode {
        TrieNode[] children;
        String word;
        
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rs = new ArrayList<>();
        int n = board.length;
        if(n == 0) {
            return rs;
        }
        int m = board[0].length;
        if(m == 0) {
            return rs;
        }
        
        Set<String> set = new HashSet<>();
        TrieNode root = getRoot(words);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                checkExist(board, n, m, i, j, root, rs);
            }
        }
        
        return rs;
    }
    
    private void checkExist(char[][] board, int n, int m, int i, int j, TrieNode root, List<String> rs) {
        char c = board[i][j];
        if(c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        if(root.word != null) {
            rs.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '#';
        if(i + 1 < n) {
            checkExist(board, n, m, i + 1, j, root, rs);
        } 
        if(j + 1 < m) {
            checkExist(board, n, m, i, j + 1, root, rs);
        } 
        if(i - 1 >= 0) {
            checkExist(board, n, m, i - 1, j, root, rs);
        }
        if(j - 1 >= 0) {
            checkExist(board, n, m, i, j - 1, root, rs);
        }
        board[i][j] = c;
    }
    
    private TrieNode getRoot(String[] words) {
        TrieNode root = new TrieNode();
        
        for(String word : words) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        
        return root;
    }
}
