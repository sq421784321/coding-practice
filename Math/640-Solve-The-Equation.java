class Solution {
    private final String NO_SOLUTION = "No solution";
    private final String INFINITE_SOLUTION = "Infinite solutions";
    
    public String solveEquation(String equation) {
        String[] equations = equation.split("=");

        int[] left = cal(equations[0]);
        int[] right = cal(equations[1]);
        
        int coeff = left[0] - right[0];
        int sum = right[1] - left[1];
        
        if (coeff == 0 && sum == 0) {
            return INFINITE_SOLUTION;
        } else if (coeff == 0 && sum != 0) {
            return NO_SOLUTION;
        } else {
            return "x=" + sum / coeff;
        }
        
    }
    
    private int[] cal(String s) {
        // ans[0] : coeff, ans[1] : sum
        int[] ans = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+' || Character.isDigit(c)) {
                int j = (Character.isDigit(c) ? i : i + 1);
                int sign = (c == '-' ? -1 : 1);
                if (s.charAt(j) == 'x') {
                    ans[0] += sign;
                    i = j;
                    continue;
                }
                
                int num = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                if (j < s.length() && s.charAt(j) == 'x') {
                    ans[0] += sign * num;
                    i = j;
                } else {
                    ans[1] += sign * num;
                    i = j - 1;
                }
            } else if (c == 'x') {
                ans[0] += 1;
            }
        }
        return ans;
    }
}