import java.util.Scanner;

public class Fibonacci {
//  private static long calc_fib(int n) {
//    if (n <= 1)
//      return n;
//
//    return calc_fib(n - 1) + calc_fib(n - 2);
//  }

  private static long calc_fib(long n) {
    if (n <= 1) return n;
    long sum1 = 0;
    long sum2 = 1;
    for (int i = 2; i <= n; i++) {
      long trans = sum2;
      sum2 += sum1;
      sum1 = trans;
    }
    return sum2;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    long n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}


//45
//1134903170