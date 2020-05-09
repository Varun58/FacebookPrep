package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ReverseWordsInAString_73 {

  public static void main(String[] args) {
    System.out.println(new ReverseWordsInAString_73().reverseWords("The sky is blue"));
    System.out.println(new ReverseWordsInAString_73().reverseWords2("Roses are red"));
  }

  // T O(N)
  // S O(N)
  public String reverseWords2(String s) {
    s = s.trim();
    List<String> words= Arrays.asList(s.split("\\s+"));
    Collections.reverse(words);
    return String.join(" ", words);
  }

  // T O(N)
  // S O(N)
  public String reverseWords(String s) {
    int left =0, right = s.length() -1;
    while(left<=right && s.charAt(left) == ' ') {
      ++left;
    }
    while(left<=right && s.charAt(right) == ' ') {
      --right;
    }

    Deque<String> d = new ArrayDeque<String>();
    StringBuilder word = new StringBuilder();
    while(left <= right) {
      char c = s.charAt(left);

      if(word.length() != 0 && c == ' ') {
        d.offerFirst(word.toString());
        word.setLength(0);
      } else if( c != ' ') {
        word.append(c);
      }

      ++left;
    }
    d.offerFirst(word.toString());

    return String.join(" ", d);
  }
}
