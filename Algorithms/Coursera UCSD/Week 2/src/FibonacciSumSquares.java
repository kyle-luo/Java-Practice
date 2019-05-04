import java.util.*;

public class FibonacciSumSquares {
//    private static long getFibonacciSumSquaresNaive(long n) {
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
//            sum += current * current;
//        }
//
//        return sum % 10;
//    }

/**    code above is original */

//    private static long getFibonacciLastDigitNaive(long n) {
//        if (n <= 1) return n;
//        long sum1 = 0;
//        long sum2 = 1;
//        for (int i = 2; i <= n; i++) {
//            long trans = sum2;
//            sum2 = (sum2 + sum1) % 10;
//            sum1 = trans;
//        }
//        return sum2;
//    }
//
//    private static long getFibonacciSumSquaresNaive(long n) {
//        long sum = 0;
//        for (long i = 0; i <= n; i++) {
//            sum += (getFibonacciLastDigitNaive(i) * getFibonacciLastDigitNaive(i)) % 10;
//        }
//        return sum % 10;
//    }

/**     code above is not fast enough */

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

    private static long getFibonacciSumSquaresNaive(long n) {
        return ((getFibonacciHugeNaive(n, 10) + getFibonacciHugeNaive(n - 1, 10)) * getFibonacciHugeNaive(n, 10)) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

