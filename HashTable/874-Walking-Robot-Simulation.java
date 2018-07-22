class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, angle = 0;
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }
        
        int max = 0;
        for (int command: commands) {
            if (command == -1) {
                angle += 1;
                angle = angle == 4 ? 0 : angle;
            } else if (command == -2) {
                angle -= 1;
                angle = angle == -1 ? 3 : angle;
            } else {
                while (command-- > 0 && (!set.contains((x + dirs[angle][0]) + "," + (y + dirs[angle][1])))) {
                    x += dirs[angle][0];
                    y += dirs[angle][1];
                }
            }
            max = Math.max(max, x * x + y * y);
        }
        
        return max;
    }
}