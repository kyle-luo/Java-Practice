import java.util.*;

public class FibonacciPartialSum {
//    private static long getFibonacciPartialSumNaive(long from, long to) {
//        long sum = 0;
//
//        long current = 0;
//        long next  = 1;
//
//        for (long i = 0; i <= to; ++i) {
//            if (i >= from) {
//                sum += current;
//            }
//
//            long new_current = next;
//            next = next + current;
//            current = new_current;
//        }
//
//        return sum % 10;
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

    private static long getFibonacciPartialSumNaive(long from, long to){
        long sum = 0;
        for (long i = from; i <= to; i++) {
            sum += getFibonacciLastDigitNaive(i);
        }
        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

