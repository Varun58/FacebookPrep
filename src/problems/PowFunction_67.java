package problems;

public class PowFunction_67 {

  public static void main(String[] args) {
  }

  public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    double ans = 1;
    double current_product = x;
    for (long i = N; i > 0; i /= 2) {
      if ((i % 2) == 1) {
        ans = ans * current_product;
      }
      current_product = current_product * current_product;
    }
    return ans;
  }

  public double myPowRecursive(double x, int n) {
    int N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    return myPowR(x, n);
  }

  public double myPowR(double x, int n) {
    if (n == 0) {
      return 1.0;
    }

    double half = myPowR(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }

  public double myPowBrute(double x, int n) {
    int N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }

    double ans = 1;
    for (int i = 0; i < N; i++) {
      ans = ans * x;
    }

    return ans;
  }
}
