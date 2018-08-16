class Solution {
	/*
		Method 1: A lot of corner cases.
		
		For IPv4:
			1) trailing dots
			2) empty string
			3) super large string
			4) not numeric
			5) leading zero of non-zero number 
			6) extra zero of zero
			7) larger than 255
		
		For IPv6:
			1) trailing colons
			2) empty string
			3) extra leading 0
			3) contains invalid character
	*/
	
    private final String NEITHER = "Neither";
    
    public String validIPAddress(String IP) {
        int pos = IP.indexOf(".");
        
        if (pos < 0) {
            // IPv6
            String[] parts = IP.split(":");
            
            if (parts.length == 8) {
                // Condition 1: trailing colon
                if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
                    return NEITHER;
                }
                
                for (String part: parts) {
                    // Condition 2: extra leading 0 or empty string
                    if (part == null || part.length() == 0 || part.length() > 4) {
                        return NEITHER;
                    }
                    
                    // Condition 3: contains invalid character
                    for (int i = 0; i < part.length(); i++) {
                        char cur = part.charAt(i);
                        if (!((cur >= '0' && cur <= '9') || (cur >= 'a' && cur <= 'f') || (cur >= 'A' && cur <= 'F'))) {
                            return NEITHER;
                        }
                    }
                }
                return "IPv6";
            }
        } else {
            // IPv4
            String[] parts = IP.split("\\.");
            
            if (parts.length == 4) {
                // Condition 1: trailing dot
                if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
                    return NEITHER;
                }
                
                for (String part: parts) {
                    // Condition 2: empty string or super large string
                    if (part == null || part.length() == 0 || part.length() > 3) {
                        return NEITHER;
                    }
                    
                    // Conditon 3: not numeric
                    for (int i = 0; i < part.length(); i++) {
                        char cur = part.charAt(i);
                        if (cur < '0' || cur > '9') {
                            return NEITHER;
                        }
                    }
                    
                    int num = Integer.valueOf(part);
                    // Condition 4: leading zero of non-zero number
                    if (num > 0 && part.charAt(0) == '0') {
                        return NEITHER;
                    } else if (num == 0 && part.length() > 1) { // Condition 5: extra zero of zero
                        return NEITHER;
                    } else if (num > 255) { // Condition 6: larger than 255
                        return NEITHER;
                    }
                }
                return "IPv4";
            }
        }
        return NEITHER;
    }
}