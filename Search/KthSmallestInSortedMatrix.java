/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.

*/

// Method 1 : using min heap
public class Solution {
    static class Point {
        int i;
        int j;
        
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>(11, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2) {
                if(matrix[p1.i][p1.j] == matrix[p2.i][p2.j]) {
                    return 0;
                }
                return matrix[p1.i][p1.j] - matrix[p2.i][p2.j];
            }
        });
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        minHeap.offer(new Point(0, 0));
        
        while(k > 1) {
            Point cur = minHeap.poll();
            int i = cur.i;
            int j = cur.j;
            if(i + 1 < n && !visited[i + 1][j]) {
                visited[i + 1][j] = true;
                minHeap.offer(new Point(i + 1, j));
            }
            if(j + 1 < m && !visited[i][j + 1]) {
                visited[i][j + 1] = true;
                minHeap.offer(new Point(i, j + 1));
            }
            k--;
        }
        
        return matrix[minHeap.peek().i][minHeap.peek().j];
    }
}

// Method 2 : binary search, using range as the "search space"
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = matrix[0][0], right = matrix[n - 1][m - 1] + 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = m - 1;
            for(int i = 0; i < n; i++) {
                while(j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1;
            }
            
            if(count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
