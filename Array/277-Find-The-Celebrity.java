/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        int j = 1;
        
        // Skip all the persons who doesn't satisfy the rule. 
        while (j < n) {
            boolean flag = knows(j, candidate);
            if (!flag) {
                candidate = j;
            }
            j++;
        }
        
        // Validation
        for (j = 0; j < n; j++) {
            if (j < candidate && !knows(j, candidate)) return -1;
            if (j != candidate && knows(candidate, j)) return -1;
        }
        
        return candidate;
    }
}