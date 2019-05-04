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

// code above is original code

//    private static int getFibonacciSumNaive(long n) {
//        if (n <= 1) return (int)n;
//        int sum1 = 0;
//        int sum2 = 1;
//        for (long i = 2; i <= n + 2; i++) {
//            int trans = sum2;
//            sum2 = (sum2 + sum1) % 10;
//            sum1 = trans;
//        }
//        return Math.abs(sum2 - 1);
//    }
//
//    code about is not fast enough

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
    private static long getFibonacciSumNaive(long n) {
        return Math.abs(getFibonacciHugeNaive(n + 2, 10) - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

