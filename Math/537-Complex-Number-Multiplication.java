class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] argsA = a.split("\\+");
        String[] argsB = b.split("\\+");
        argsA[1] = argsA[1].substring(0, argsA[1].length() - 1);
        argsB[1] = argsB[1].substring(0, argsB[1].length() - 1);
        
        int real = Integer.parseInt(argsA[0]) * Integer.parseInt(argsB[0]);
        real -= Integer.parseInt(argsA[1]) * Integer.parseInt(argsB[1]);
        
        int imag = Integer.parseInt(argsA[0]) * Integer.parseInt(argsB[1]);
        imag += Integer.parseInt(argsA[1]) * Integer.parseInt(argsB[0]);
        
        return real + "+" + imag + "i";
    }
}