public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String bi = Integer.toBinaryString(n);
        if (bi == "1") return true;
        char[] bic = bi.toCharArray();
        for (int i = 0; i < bic.length; i += 2) {
            if (bic[i] != '1') return false;
        }
        for (int i = 1; i < bic.length; i += 2) {
            if (bic[i] != '0') return false;
        }
        return true;
    }
}
