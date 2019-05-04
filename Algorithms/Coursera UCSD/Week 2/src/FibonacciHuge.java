import java.util.*;

public class FibonacciHuge {
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

    private static long PisanoPeriod(long m) {
        long a = 0;
        long b = 1;
        long c = 0;
        long d = 1;
        for (int i = 0; i <= m * m; i++) {
            long trans = b;
            b += a;
            a = trans;
            c = d;
            d = b % m;

        }
    }

    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

