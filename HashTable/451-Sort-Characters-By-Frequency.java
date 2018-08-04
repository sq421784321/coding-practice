class Solution {
    public String frequencySort(String s) {
        int[] array = new int[256];
        List<Character>[] list = new List[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)]++;
        }
        
		// Bucket sort
        for (int i = 0; i < array.length; i++) {
            int count = array[i];
            if (count > 0) {
                List<Character> chars = list[count - 1];
                if (chars == null) {
                    chars = new ArrayList<>();
                }
                chars.add((char)i);
                list[count - 1] = chars;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            List<Character> chars = list[i];
            if (chars != null) {
                for (char c : chars) {
                    int j = i + 1;
                    while (j-- > 0) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}