//Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
//
//We repeatedly make duplicate removals on S until we no longer can.
//
//Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
//
//
//Example 1:
//
//Input: "abbaca"
//Output: "ca"


public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        ArrayList<Character> output = new ArrayList<Character>();
        for (char x: S.toCharArray()) {
            if (output.size() == 0) output.add(x);
            else {
                if (output.get(output.size() - 1) != x) output.add(x);
                else output.remove(output.size() - 1);
            }
        }
        String result = "";
        for (char x: output) result += x;
        return result;
    }

    public String removeDuplicates2(String S) {
        String output = "";
        for (char x: S.toCharArray()) {
            if (output.length() == 0) output += x;
            else {
                if (output.charAt(output.length() - 1) != x) output += x;
                else output = output.substring(0, output.length() - 1);
            }
        }
        return output;
    }

    public String removeDuplicates3(String S) {
        char[] chars = S.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (j == 0 || chars[i] != chars[j - 1]) {
                chars[j++] = chars[i];
            }
            else {
                j--;
            }
        }
        return new String(chars, 0, j);
    }
}
