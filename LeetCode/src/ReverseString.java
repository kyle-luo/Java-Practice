public class ReverseString {
    public static void reverseString(char[] s) {
        int range = (int) (s.length / 2);
        for (int i = 0; i <= range; i++) {
            try {
                char a = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = a;
            }
            catch (Exception e) {

            }
        }
        System.out.println(s);
    }

    public static void reverseStringg(char[] s) {
        int front = 0;
        int back = s.length - 1;
        while (back > front) {
            char a = s[front];
            s[front] = s[back];
            s[back] = a;
            front++;
            back--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] input = {'h','e','l','l','o'};
        reverseString(input);
        char[] input2 = {'h','e','l','l','o'};
        reverseStringg(input2);

    }
}
