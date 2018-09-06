class Solution {
	/*
		Method 1: Recursion
		
		Total number of possibilities is 12 * 6 * 2 * 4 * 4 * 4.
		First, pick 2 numbers from 4 numbers (with order) => 12, then perform one operation => 4. Then put the result back to the number set.
		Second, pick 2 numbers from 3 numbers (one is the result of first step) => 6, then perform one operation => 4. Put the result back.
		Third, pick 2 numbers from 2 numbers => 2, perform one operation => 4.
		
		The idea of recursion:
		Recursively, pick 2 numbers from the nums list, perform one operation to get a result, then put the result and remaining numbers of nums list to a new list.
		
		'+' and '*' are commutative, while '-' and '/' are not.
		We can take advantage of the commutative property and skip the duplicate calculation.
		
		Be careful of performing '/', we need to be sure that denominator is not 0.
		
	*/
	
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return cal(list);
    }
    
    private boolean cal(List<Double> nums, List<String> path) {
        if (nums == null || nums.size() == 0) return false;
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;	// double type, so we simply do approximate comparison.
        }
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                
                if (i != j) {
                    List<Double> next = new ArrayList<>();
                    
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) next.add(nums.get(k));
                    }
                    
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;	// '+' and '*' are commutative, so we skip
                        if (k == 0) next.add(nums.get(i) + nums.get(j));
                        if (k == 1) next.add(nums.get(i) * nums.get(j));
                        if (k == 2) next.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                next.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;	// denominator = 0, so we skip
                            }
                        }
                        
                        if (cal(next, nextPath)) return true;
                        next.remove(next.size() - 1);	// backtracking
                    }
                }
            }
        }
        return false;
    }
}

/*
	Print out all the paths.
*/

/*
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        List<String> path = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        
        for (int num : nums) {
            list.add((double) num);
            path.add("" + num);
        }
        
        cal(list, path, ans);
        System.out.println(ans);
        
        return ans.size() > 0;
    }
    
    private void cal(List<Double> nums, List<String> path, List<String> ans) {
        if (nums == null || nums.size() == 0) return;
        if (nums.size() == 1) {
            boolean res = Math.abs(nums.get(0) - 24) < 1e-6;
            if (res) {
                ans.add(path.get(0));
            }
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                
                if (i != j) {
                    List<Double> next = new ArrayList<>();
                    List<String> nextPath = new ArrayList<>();
                    
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            next.add(nums.get(k));
                            nextPath.add(path.get(k) + "");
                        }
                    }
                    
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) {
                            next.add(nums.get(i) + nums.get(j));
                            nextPath.add("(" + path.get(i) + "+" + path.get(j) + ")");
                        }
                        if (k == 1) {
                            next.add(nums.get(i) * nums.get(j));
                            nextPath.add("(" + path.get(i) + "*" + path.get(j) + ")");
                        }
                        if (k == 2) {
                            next.add(nums.get(i) - nums.get(j));
                            nextPath.add("(" + path.get(i) + "-" + path.get(j) + ")");
                        }
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                next.add(nums.get(i) / nums.get(j));
                                nextPath.add("(" + path.get(i) + "/" + path.get(j) + ")");
                            } else {
                                continue;
                            }
                        }
                        
                        // if (cal(next, nextPath)) return true;
                        cal(next, nextPath, ans);
                        next.remove(next.size() - 1);
                        nextPath.remove(nextPath.size() - 1);
                    }
                }
            }
        }
    }
}
*/