/*
Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, 
compute the volume of water it is able to trap after raining.

Note:
Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

Example:

Given the following 3x6 height map:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

Return 4.
*/

// Using min heap, and breadth first search.
// Whenever you get a cell which is higher than its neighbors, fill the neighbors to the cell's height, 
// and plus the difference to the final result.

public class Solution {
    static class Element implements Comparable<Element> {
        int i;
        int j;
        int height;
        
        public Element(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }
        
        @Override
        public int compareTo(Element another) {
            if(this.height == another.height) {
                return 0;
            }
            return this.height - another.height;
        }
        
    }
    
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        if(n == 0) {
            return 0;
        }
        int m = heightMap[0].length;
        if(m == 0) {
            return 0;
        }
        
        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];
        
        preProcess(heightMap, n, m, visited, minHeap);
        
        int max = 0;
        
        while(!minHeap.isEmpty()) {
            Element cur = minHeap.poll();
            visited[cur.i][cur.j] = true;
            
            List<Element> neis = getNeis(cur, heightMap, n, m);
            for(Element nei : neis) {
                if(!visited[nei.i][nei.j]) {
                    visited[nei.i][nei.j] = true;
                    max += Math.max(cur.height - nei.height, 0);
                    nei.height = Math.max(nei.height, cur.height);
                    minHeap.offer(nei);
                }
            }
        }
        return max;
    }
    
    private List<Element> getNeis(Element cur, int[][] matrix, int n, int m) {
        int i = cur.i;
        int j = cur.j;
        List<Element> rs = new ArrayList<>();
        if(i + 1 < n) {
            rs.add(new Element(i + 1, j, matrix[i + 1][j]));
        }
        if(i - 1 >= 0) {
            rs.add(new Element(i - 1, j, matrix[i - 1][j]));
        }
        if(j + 1 < m) {
            rs.add(new Element(i, j + 1, matrix[i][j + 1]));
        }
        if(j - 1 >= 0) {
            rs.add(new Element(i, j - 1, matrix[i][j - 1]));
        }
        return rs;
    }
    
    private void preProcess(int[][] matrix, int n, int m, boolean[][] visited, PriorityQueue<Element> minHeap) {
        for(int i = 0; i < n; i++) {
            visited[i][0] = true;
            visited[i][m - 1] = true;
            minHeap.offer(new Element(i, 0, matrix[i][0]));
            minHeap.offer(new Element(i, m - 1, matrix[i][m - 1]));
        }
        for(int j = 0; j < m; j++) {
            visited[0][j] = true;
            visited[n - 1][j] = true;
            minHeap.offer(new Element(0, j, matrix[0][j]));
            minHeap.offer(new Element(n - 1, j, matrix[n - 1][j]));
        }
    }
}
