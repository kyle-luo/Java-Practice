import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
//    private static int getMaxPairwiseProduct(int[] numbers) {
//        int max_product = 0;
//        int n = numbers.length;
//
//        for (int first = 0; first < n; ++first) {
//            for (int second = first + 1; second < n; ++second) {
//                max_product = Math.max(max_product, numbers[first] * numbers[second]);
//            }
//        }
//
//        return max_product;
//    }
    private static long max;
    private static long max2;

    private static long getMaxPairwiseProduct(int[] numbers) {
        max = Math.max(numbers[0], numbers[1]);
        max2 = Math.min(numbers[0], numbers[1]);
        for (int i = 2; i < numbers.length; i++) {
            if (numbers[i] > max2) {
                if (numbers[i] > max)
                {
                    max2 = max;
                    max = numbers[i];
                }
                else max2 = numbers[i];
            }
        }
        return max * max2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
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