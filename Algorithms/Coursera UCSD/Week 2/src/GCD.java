import java.util.*;

public class GCD {
//  private static int gcd_naive(int a, int b) {
//    int current_gcd = 1;
//    for(int d = 2; d <= a && d <= b; ++d) {
//      if (a % d == 0 && b % d == 0) {
//        if (d > current_gcd) {
//          current_gcd = d;
//        }
//      }
//    }
//    return current_gcd;
//  }

  private static long gcd_naive(long a, long b) {
    long big = Math.max(a, b);
    long small = Math.min(a, b);
    while (small != 0) {
      long trans = small;
      small = big % small;
      big = trans;
    }
    return big;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}

//1564
//8763
//23