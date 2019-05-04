import java.util.*;

public class FibonacciLastDigit {
//    private static long getFibonacciLastDigitNaive(long n) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//
//        for (int i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous % 10;
//            previous = current % 10;
//            current = tmp_previous + current % 10;
//        }
//
//        return current  % 10;
//    }

    private static long getFibonacciLastDigitNaive(long n) {
        if (n <= 1) return n;
        long sum1 = 0;
        long sum2 = 1;
        for (int i = 2; i <= n; i++) {
            long trans = sum2;
            sum2 = (sum2 + sum1) % 10;
            sum1 = trans;
        }
        return sum2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

