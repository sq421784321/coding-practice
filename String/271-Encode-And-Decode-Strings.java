public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : strs) {
            sb.append(str.length() + "/");
            sb.append(str);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                count *= 10;
                count += s.charAt(i) - '0';
                i++;
            }
            
            i++;
            
            ans.add(s.substring(i, i + count));
            i+= count - 1;
        }
        return ans;
    }
}