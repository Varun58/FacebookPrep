package problems;

public class LongestPalindromicSubstring_64 {

  public static void main(String[] args) {
    System.out.println(new LongestPalindromicSubstring_64().longestPalindromicSubstring("babad"));
  }

  public String longestPalindromicSubstring(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    int start = 0, end = 0, maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);

      int len = Math.max(len1, len2);
      if(maxLen < len) {
        start = i - (len -1)/2;
        end = i + len/2;
        maxLen = len;
      }
    }

    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left;
    int R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  public String longestPalindromeDp(String input) {
    if (input == null || input.length() == 1 || input.length() == 0) {
      return input;
    }

    int n = input.length();

    boolean[][] table = new boolean[n][n];

    // All substrings of length 1 are palindrome
    int maxLength = 1;
    for (int i = 0; i < n; i++) {
      table[i][i] = true;
    }

    // Check for substring of length 2
    int start = 0;
    for (int i = 0; i < n - 1; i++) {
      if (input.charAt(i) == input.charAt(i + 1)) {
        table[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }

    // check for substring of length greater than 2
    for (int k = 3; k <= n; k++) {
      for (int i = 0; i < n - k + 1; i++) {

        int j = i + k - 1;

        if (table[i + 1][j - 1] && input.charAt(i) == input.charAt(j)) {
          table[i][j] = true;
          if (k >= maxLength) {
            start = i;
            maxLength = k;
          }
        }
      }
    }

    return input.substring(start, start + maxLength);
  }

  public  String longestPalindromeBrute(String input) {
    String longestP = "";

    for (int i = 0; i < input.length(); i++) {
      for (int j = i +1; j <= input.length(); j++) {
        //System.out.println(input.substring(i, j));

        String inputSubstring = input.substring(i, j);

        if(isPalindrome(inputSubstring)
            && longestP.length() <= inputSubstring.length()) {
          longestP = inputSubstring;
        }
      }
    }
    return longestP;
  }

  public  boolean isPalindrome(String s) {

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }
}
