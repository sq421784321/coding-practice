class Solution {
//     public int minRefuelStops(int target, int startFuel, int[][] stations) {
//         long[] dp = new long[stations.length + 1];
//         dp[0] = startFuel;
        
//         for (int i = 0; i < stations.length && target > stations[i][0]; i++) {
            
//             for (int j = i; j >= 0; j--) {
//                 if (dp[j] >= stations[i][0]) {
//                     dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
//                 }                   
//             }
            
//         }
        
//         for (int i = 0; i <= stations.length; i++) {
//             if (dp[i] >= target) return i;
//         }
//         return -1;
//     }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int dist = startFuel;
        int stop = 0;
        int index = 0;
        while (true) {
            while (index < stations.length && dist >= stations[index][0]) {
                pq.add(-stations[index][1]);
                index++;
            }
            if (dist >= target) return stop;
            if (pq.isEmpty()) return -1;
            dist += -pq.poll();
            stop++;
        }
    }
}