import java.util.*;

public class DotProduct {

    private static long maxDotProduct(int[] a, int[] b) {
        long sum = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < b.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }

    /** Below is test code
    private static long maxDotProduct2(int[] a, int[] b) {
        //write your code here
        long result = 0;
        bubblesort(a);
        bubblesort(b);
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    private static void bubblesort(int[] a) {
        int[] list = a;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    private static int[] gen(int length) {
        int[] output = new int[length];
        for (int i = 0; i < length; i++) {
            output[i] = (int) (Math.random()* 200000 + 1 - 100000);
        }
        return output;
    }

    private static void test() {
        while (true) {
            int length = (int) (Math.random()* 10 + 1);
            int[] a = gen(length);
            System.out.println("first row  " + a);
            int[] b = gen(length);
            System.out.println("second row " + b);
            if (maxDotProduct(a,b) == maxDotProduct2(a,b)) System.out.println("ok");
            else {
                System.out.println("Not match");
                System.out.println(maxDotProduct(a,b));
                System.out.println(maxDotProduct2(a,b));
            }
        }
    }

    private static void speedtest() {
        while (true) {
            int length = (int) (Math.random() * 100000 + 1);
            int[] a = gen(length);
            int[] b = gen(length);
            long tStart1 = System.currentTimeMillis();
            maxDotProduct(a, b);
            long tEnd1 = System.currentTimeMillis();
            maxDotProduct2(a, b);
            long tEnd2 = System.currentTimeMillis();
            long tDelta1 = tEnd1 - tStart1;
            long tDelta2 = tEnd2 - tEnd1;

            System.out.println("1 test " + tDelta1 / 1000);
            System.out.println("2 test " + tDelta2 / 1000);
        }
    }
     */
}

