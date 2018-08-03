class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] ans = new int[rowIndex + 1];
        
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i || j == 0) {
                    ans[j] = 1;
                } else {
                    ans[j] = ans[j] + ans[j - 1];
                }
            }
        }
        
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            l.add(ans[i]);
        }
        return l;
    }
}