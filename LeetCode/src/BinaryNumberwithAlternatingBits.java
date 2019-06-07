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

    public boolean hasAlternatingBits2(int n) {
        if (n == 1) return true;
        String bi = Integer.toBinaryString(n);
        char[] bic = bi.toCharArray();
        char pre = bic[0];
        for (int i = 1; i < bic.length; i++) {
            if (bic[i] == pre) return false;
            pre = bic[i];
        }
        return true;
    }
}
