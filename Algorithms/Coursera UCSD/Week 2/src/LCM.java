import java.util.*;

public class LCM {
//  private static long lcm_naive(int a, int b) {
//    for (long l = 1; l <= (long) a * b; ++l)
//      if (l % a == 0 && l % b == 0)
//        return l;
//
//    return (long) a * b;
//  }
  private static long lcm_naive(long a, long b) {
    long big = Math.max(a, b);
    long small = Math.min(a, b);
    while (small != 0) {
      long trans = small;
      small = big % small;
      big = trans;
    }
    return a * b / big;
  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextInt();
    long b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}

//155
//168
//26040