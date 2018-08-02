class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) return nums[0] + "";
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0] + "/(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i] + "/");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        
        return sb.toString();
    }
}