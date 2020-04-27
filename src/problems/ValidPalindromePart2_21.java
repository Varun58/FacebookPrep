package problems;

//https://www.youtube.com/watch?v=L_74qbyPHXE
public class ValidPalindromePart2_21 {
  public static void main(String[] args) {
    System.out.println(new ValidPalindromePart2_21().isValidPalindrome("abca"));
  }

  public boolean isValidPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
      }

      i++;
      j--;
    }

    return true;
  }

  private boolean isPalindrome(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;
  }
}
