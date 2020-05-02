package problems;

public class MultplyStrings_54 {

  public static void main(String[] args) {
    System.out.println(new MultplyStrings_54().multiply("58", "23"));
  }

  //https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3013/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
  //https://www.youtube.com/watch?v=CnEFY5Y3Z68
  public String multiply(String num1, String num2) {
    int m = num1.length();
    int n = num2.length();
    int[] pos = new int[m + n];


    for(int i= m-1;i>=0;i--) {
      for(int j = n-1;j>=0;j--) {

        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

        int p1 = i + j;
        int p2 = i + j + 1;

        int sum = mul + pos[p2];

        pos[p1] += sum / 10;
        pos[p2] = sum % 10;
      }
    }


    StringBuilder sb = new StringBuilder();
    for(int value: pos) {
      if(!(sb.length() == 0 && value == 0)) {
        sb.append(value);
      }
    }

    return sb.length() == 0 ? "0": sb.toString();
  }
}
