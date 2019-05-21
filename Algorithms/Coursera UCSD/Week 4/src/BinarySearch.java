import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length - 1;
        return binary(a, x, left, right);
    }

    static int binary(int[] a, int key, int low, int high) {
        if (high < low) return -1;
        int mid = low + (high - low) / 2;
        if (key == a[mid]) return mid;
        else if (key > a[mid]) return binary(a, key, mid + 1, high);
        else return binary(a, key, low, mid - 1);
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    /** BLOW IS FOR TEST
    public static void main(String[] args) {
        while (true) {
            int[] Row = generator(100, 10);
            int find = (int) (Math.random() * 1000 + 1);
            if (linearSearch(Row, find) == binarySearch(Row, find)) System.out.println("ok");
            else {
                System.out.println("failed");
                System.out.println(Arrays.toString(Row));
                System.out.println(find);
                System.out.println(linearSearch(Row, find));
                System.out.println(binarySearch(Row, find));
                break;
            }
        }
    }

    private static int[] generator(int size, int max) {
        int[] output = new int[size];
        int pre = 0;
        for (int i = 0; i < size; i++) {
            output[i] = (int) (Math.random() * max + 1) + pre;
            pre = output[i];
        }
        return output;
    }
     */
}
