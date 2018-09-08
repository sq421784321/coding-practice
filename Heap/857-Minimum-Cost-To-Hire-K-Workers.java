class Solution {
    /*
        Method 1: PriorityQueue
        
        1. Sort ratios in ascending order.
		2. Keep a window of size K, workers within this window should be compensated for the ratio of the largest one.
    */
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] array = new double[quality.length][2];
        
        for (int i = 0; i < quality.length; i++) {
            array[i] = new double[] {1.0 * wage[i] / quality[i], quality[i]};
        }
        
        Arrays.sort(array, (a, b) -> Double.compare(a[0], b[0]));
        
        double ans = Double.MAX_VALUE;
        int qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        
        for (int i = 0; i < array.length; i++) {
            qsum += array[i][1];
            pq.offer(-array[i][1]);
            if (pq.size() > K) {
                qsum += pq.poll();
            }
            if (pq.size() == K) {
                ans = Math.min(ans, qsum * array[i][0]);
            }
        }
        
        return ans;
    }
}