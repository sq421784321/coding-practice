class Solution {
	/*
		Method 1: Greedy.
		Always pick one big number and one small number, and determine whether the sum is larger than limit or not.
		
		First of all, sort the array in increasing order.
		Then, use two pointers to search from two sides of the array, and check the relation between the sum and limit.
		If sum <= limit, meaning these two persons could share a same boat. So, we move on to the next couple.
		If sum > limit, we try to send larger person first, because that way, we are more likely to let two persons in the remaining share the same boat.
	*/
	
    public int numRescueBoats(int[] people, int limit) {        
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int ans = 0;
        while (left < right) {
            if (people[right] + people[left] > limit) {
                ans += 1;
                right--;
            } else {
                ans += 1;
                right--;
                left++;
            }
        }
        return left == right ? ans + 1 : ans;
    }
}