// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

import java.math.*;
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        //HashMap<Element, List<Point>> map = new HashMap<>();
        if(points.length == 0) {
            return 0;
        }
        int n = points.length;
        int global_max = 0;
        for(int i = 0; i < n; i++) {
            HashMap<BigDecimal, Integer> map = new HashMap<>();
            Point a = points[i];
            int sameX = 0; // to record the line parrallel to y-axis
            int same = 0;
            int local_max = 0;
            for(int j = 0; j < n; j++) {
                Point b = points[j];
                if(a.x == b.x && a.y == b.y) {
                    same++;
                } else if (a.x == b.x) {
                    sameX++;
                } else {
                    BigDecimal y = new BigDecimal(a.y - b.y);
                    BigDecimal x = new BigDecimal(a.x - b.x);
                    BigDecimal slope = y.divide(x, MathContext.DECIMAL128);
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                    local_max = Math.max(local_max, map.get(slope));
                }
            }
            global_max = Math.max(global_max, Math.max(sameX, local_max) + same);
        }
        return global_max;
    }
}
