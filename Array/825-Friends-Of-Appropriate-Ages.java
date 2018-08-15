class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int ans = 0;
        for (int ageA = 0; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 0; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageA * 0.5 + 7 >= ageB) continue;
                if (ageA < ageB) continue;
                if (ageA < 100 && 100 < ageB) continue;
                ans += countA * countB;
                if (ageA == ageB) ans -= countA;
            }
        }

        return ans;
    }
}

// class Solution {
    
//     // ages[B] > 0.5*ages[A] + 7 &&
//     // ages[B] <= ages[A] &&
//     // ages[B] <= 100 || ages[A] >= 100
    
//     public int numFriendRequests(int[] ages) {
//         if (ages == null || ages.length == 0) return 0;
        
//         Arrays.sort(ages);
// //        int[] count = new int[121];
//         int ans = 0;
        
// //         for (int age: ages) {
// //             count[age]++;
// //         }
        
//         int left = 0;
//         int count = 0;
        
//         for (int i = 1; i < ages.length; i++) {
//             if (ages[i] == ages[i - 1]) {
//                 ans += count;
                
//             }
            
//             while (left < i && 0.5 * ages[i] + 7 >= ages[left]) {
//                 left++;
//             }
            
//             if (left == i) continue;
            
//             if (ages[left] <= 100 || ages[i] >= 100) {
//                 int count = i - left;
//                 if (ages[i] == ages[left]) {
//                     int j = i;
//                     while (j + 1 < ages.length && ages[j] == ages[j + 1]) {
//                         j++;
//                     }
//                     i = j;
//                     ans += (j - left) * (j - left + 1);
                    
//                 } else {
//                     int j = i;
//                     while (j + 1 < ages.length && ages[j] == ages[j + 1]) {
//                         j++;
//                     }
//                     ans += (j - i + 1) * count;
//                     i = j;
//                 }
//             }
            
            
//         }
        
//         return ans;
//     }
// }