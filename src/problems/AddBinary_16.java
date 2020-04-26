package problems;

import java.math.BigInteger;

public class AddBinary_16 {
  public static void main(String[] args) {
    System.out.println(new AddBinary_16().addBinary("1010", "1011"));
    System.out.println(new AddBinary_16().addBinaryWithPlusOperator("1010", "1011"));
  }

  public String addBinary(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);
    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry, answer;

    while (y.compareTo(zero) != 0) {
      answer = x.xor(y);
      carry = (x.and(y)).shiftLeft(1);

      x = answer;
      y = carry;
    }

    return x.toString(2);
  }

  public String addBinaryWithPlusOperator(String a, String b) {
    int n = a.length();
    int m = b.length();

    if (n < m) {
      return addBinaryWithPlusOperator(b, a);
    }
    int L = Math.max(n, m);

    int carry = 0;
    int j = m - 1;
    StringBuilder sb = new StringBuilder();
    for (int i = L - 1; i > -1; i--) {
      if (a.charAt(i) == '1') {
        carry++;
      }

      if (j > -1 && b.charAt(j) == '1') {
        carry++;
      }

      if (carry % 2 == 1) {
        sb.append('1');
      } else {
        sb.append('0');
      }

      carry = carry / 2;
      j--;
    }

    if (carry == 1) {
      sb.append('1');
    }
    return sb.reverse().toString();
  }
}
