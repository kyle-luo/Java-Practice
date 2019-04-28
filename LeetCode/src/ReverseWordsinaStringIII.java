//Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//Example 1:
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"

public class ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        String[] splited = s.split(" ");
        StringBuilder output = new StringBuilder();
        for (String x: splited){

            output += StringBuffer(x).reverse.toString() + " ";

            output += " ";
        }
        output = output.substring(0, output.length() -1);
        return output;
    }

    public static void main(String[] args){
        String input = "Let's take LeetCode contest";
        System.out.println(reverseWords(input));
    }
}
