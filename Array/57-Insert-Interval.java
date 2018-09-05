/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	/*
		Method 1: Iterative.
		
		Some edge cases:
			1)	[new] [old]
			2)	[old] [new]
			3)	[old] [new] [old]
	*/
	
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }
        
        boolean isInserted = false;
        
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (newInterval.start > cur.end) {
                ans.add(cur);
            } else if (newInterval.end < cur.start) {
                if (!isInserted) {
                    ans.add(newInterval);
                    isInserted = true;
                }
                ans.add(cur);
            } else {
                i = helper(intervals, newInterval, i, ans);
                isInserted = true;
            }
        }
        
        if (!isInserted) {
            ans.add(newInterval);
        }
        return ans;
    }
    
    private int helper(List<Interval> intervals, Interval newInterval, int index, List<Interval> ans) {
        int s = Math.min(newInterval.start, intervals.get(index).start);
        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            index++;
        }
        int e = Math.max(newInterval.end, intervals.get(index - 1).end);
        ans.add(new Interval(s, e));
        return index - 1;
    }
}