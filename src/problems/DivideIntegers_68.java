package problems;

public class DivideIntegers_68 {
  public static void main(String[] args) {
    System.out.println(new DivideIntegers_68().divide(Integer.MIN_VALUE, 1));
  }

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int negatives = 2;

    if (dividend > 0) {
      negatives--;
      dividend = -dividend;
    }

    if (divisor > 0) {
      negatives--;
      divisor = -divisor;
    }

    int highestDouble = divisor;
    int highestPowerOfTwo = -1;
    while (highestDouble >= Integer.MIN_VALUE / 2
        && dividend <= highestDouble + highestDouble) {
      highestPowerOfTwo += highestPowerOfTwo;
      highestDouble += highestDouble;
    }

    int quotient = 0;
    while (dividend <= divisor) {
      if (dividend <= highestDouble) {
        quotient += highestPowerOfTwo;
        dividend -= highestDouble;
      }

      highestPowerOfTwo >>= 1;
      highestDouble >>= 1;
    }

    if (negatives != 1) {
      return -quotient;
    }

    return quotient;
  }

  public int divideMinus(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int negatives = 2;

    if (dividend > 0) {
      negatives--;
      dividend = -dividend;
    }

    if (divisor > 0) {
      negatives--;
      divisor = -divisor;
    }

    int quotient = 0;
    while (dividend - divisor <=0 ) {
      quotient++;
      dividend = dividend - divisor;
    }                       

    if (negatives != 1) {
      return -quotient;
    }

    return quotient;
  }
}
