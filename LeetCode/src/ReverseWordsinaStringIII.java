//Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//Example 1:
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"

public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        String output = "";
        String[] a = s.split(" ");
        for (String x: a) {
            String reverse = "";
            for (int i = x.length() - 1; i >= 0; i--) {
                reverse += x.charAt(i);
            }

            output += reverse + " ";
        }
        return output.substring(0, output.length() - 1);
    }

    public static String reverseWordss(String s) {
        String output = "";
        String[] a = s.split(" ");
        for (String x: a) {
            output += new StringBuffer(x).reverse().toString() + " ";
        }
        return output.substring(0, output.length() - 1);
    }

    public static String reverseWordsss(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    public static void main(String[] args){
        String input = "Let's take LeetCode contest";
        System.out.println(reverseWords(input));
        System.out.println(reverseWordss(input));
        System.out.println(reverseWordsss(input));
    }
}
