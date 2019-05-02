public class NumberofLinesToWriteString {
    public static int[] numberOfLines(int[] widths, String S) {
        int[] output = {1 , 0};
        for (char c: S.toCharArray()) {
            output[1] += widths[c - 97];
            if (output[1] > 100) {
                output[0]++;
                output[1] = widths[c - 97];
            }
        }
        return output;
    }
}
