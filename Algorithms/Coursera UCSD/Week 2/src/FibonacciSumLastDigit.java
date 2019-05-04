import java.util.*;

public class FibonacciSumLastDigit {
//    private static long getFibonacciSumNaive(long n) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//        long sum      = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//            sum += current;
//        }
//
//        return sum % 10;
//    }

//    private static long getFibonacciLastDigitNaive(long n) {
////        if (n <= 1) return n;
////        long sum1 = 0;
////        long sum2 = 1;
////        for (int i = 2; i <= n; i++) {
////            long trans = sum2;
////            sum2 = (sum2 + sum1) % 10;
////            sum1 = trans;
////        }
////        return sum2;
////    }

    private static long getFibonacciSumNaive(long n) {
        if (n <= 1) return n;
        long sum1 = 0;
        long sum2 = 1;
        for (int i = 2; i <= n + 2; i++) {
            long trans = sum2;
            sum2 = (sum2 + sum1) % 10;
            sum1 = trans;
        }
        return sum2 - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

