package problems;

public class ValidPalindromePart1_20 {

  public static void main(String[] args) {
    System.out.println(new ValidPalindromePart1_20().isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(new ValidPalindromePart1_20().isPalindrome2("A man, a plan, a canal: Panama"));
  }

  public boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }

      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome2(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetterOrDigit(s.charAt(i))) {
        sb.append(Character.toLowerCase(s.charAt(i)));
      }
    }

    String filteredString = sb.toString();
    String reverseString = sb.reverse().toString();
    return filteredString.equals(reverseString);
  }
}
