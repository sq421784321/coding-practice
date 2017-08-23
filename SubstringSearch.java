public class SubstringSearch {
 /**
  *   KMP Algorithm
  *   O(m + n) time: m is the length of text, n is the length of pattern 
  *   O(n) space.
  */
  
  public boolean KMP(String text, String pattern) {
    char[] text_array = text.toCharArray();
    char[] pat_array = pattern.toCharArray();
    
    int[] table = getTable(pattern);
    int i = 0, j = 0;
    
    while(i < text_array.length && j < pat_array.length) {
      if(text_array[i] == pat_array[i]) {
        i++;
        j++;
      } else {
        if(j == 0) {
          i++;
        } else {
          j = table[j - 1];
        }
      }
    }
    
    if(j == pat_array.length) {
      return true;
    }
    return false;
  }
  
  private int[] getTable(char[] pattern) {
    int[] table = new int[pattern.length];
    int j = 0;
    int i = 1;
    while(i < pattern.length) {
      if(pattern[j] == pattern[i]) {
        table[i] = j + 1;
        j++;
        i++;
      } else {
        if(j == 0) {
          table[i] = 0;
          i++;
        } else {
          j = table[j - 1];
        }
      }
    }
    return table;
  }
  
}
