import java.util.*;

public class FibonacciHuge {

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
        long res = 1;
        for (int i = 1; i < new_n; i++) {
            res = (a + b) % m;
            a = b;
            b = res;
        }
        return res;
    }

//    private static long getFibonacciHugeNaive(long n, long m) {
//        if (n <= 1)
//            return n;
//
//        long previous = 0;
//        long current  = 1;
//
//        for (long i = 0; i < n - 1; ++i) {
//            long tmp_previous = previous;
//            previous = current;
//            current = tmp_previous + current;
//        }
//
//        return current % m;
//    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
//        System.out.println(PisanoPeriod(m));
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

