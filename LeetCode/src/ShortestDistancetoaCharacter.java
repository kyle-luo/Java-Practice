public class ShortestDistancetoaCharacter {
    public static int[] shortestToChar(String S, char C) {
        int[] output = new int[S.length()];
        char[] newS = S.toCharArray();
        int lastC = -newS.length;
        for (int i = 0; i < newS.length; i++) {
            if (newS[i] == C) {
                output[i] = 0;
                lastC = i;
            }
            else {
                output[i] = i - lastC;
            }
        }

        lastC = newS.length * 2;
        for (int i = newS.length - 1; i >= 0; i--) {
            if (newS[i] == C) {
                lastC = i;
            }
            else {
                if (lastC - i < output[i]) output[i] = lastC - i;
            }

        }
        return output;
    }
    public static void main(String[] args) {
        String input1 = "loveleetcode";
        char input2 = 'e';
        System.out.println(shortestToChar(input1, input2));
        System.out.println("[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]");
    }
}
