import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x: a) {
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }
        for (int y: counts.keySet()) {
            if (counts.get(y) > a.length / 2) return y;
        }
        return -1;
    }

    private static int getMajorityElementNaive(int[] a) {
        for (int x: a) {
            int count = 0;
            for (int y: a) {
                if (y == x) count++;
                if (count > (a.length/2)) {
                    return x;
                }
            }
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
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
}

