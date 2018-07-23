class HitCounter {
    int[] time = new int[300];
    int[] hit = new int[300];
    
    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (time[index] != timestamp) {
            time[index] = timestamp;
            hit[index] = 1;
        } else {
            hit[index] += 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                count += hit[i];
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */