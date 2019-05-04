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
//
//    code about is original

//    private static long getFibonacciSumNaive(long n) {
//        if (n <= 1) return n;
//        long sum1 = 0;
//        long sum2 = 1;
//        for (int i = 2; i <= n + 2; i++) {
//            long trans = sum2;
//            sum2 = (sum2 + sum1) % 10;
//            sum1 = trans;
//        }
//        return sum2 - 1;
//    }
//
//    private static long getFibonacciPartialSumNaive(long from, long to){
//        return Math.abs(getFibonacciSumNaive(to) - getFibonacciSumNaive(from - 1));
//    }
//    code above has problems

    private static long PisanoPeriod(long num) {
        long a = 0;
        long b = 1;
        long c;
        for (long i = 0; i <= num * num; i++) {
            c = (a + b) % num;
            a = b;
            b = c;
            if (a == 0 && b == 1) return i + 1;
        }
        return num;
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        long new_n = n % PisanoPeriod(m);
        long a = 0;
        long b = 1;
        long res = new_n;
        for (int i = 1; i < new_n; i++) {
            res = (a + b) % m;
            a = b;
            b = res;
        }
        return res;
    }
    private static long getFibonacciPartialSumNaive(long from, long to) {
        return ((getFibonacciHugeNaive(to + 2, 10) - 1) - ((getFibonacciHugeNaive(from + 1, 10) - 1)) + 10) % 10;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

