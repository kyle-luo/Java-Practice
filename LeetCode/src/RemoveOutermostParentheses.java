//A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
//
//A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
//
//Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
//
//Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
//
//
//
//Example 1:
//
//Input: "(()())(())"
//Output: "()()()"
//Explanation:
//The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
//After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
//Example 2:
//
//Input: "(()())(())(()(()))"
//Output: "()()()()(())"
//Explanation:
//The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
//After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
//Example 3:
//
//Input: "()()"
//Output: ""
//Explanation:
//The input string is "()()", with primitive decomposition "()" + "()".
//After removing outer parentheses of each part, this is "" + "" = "".

public class RemoveOutermostParentheses {
    public static String removeOuterParentheses(String S) {
        int count = 0;
        String newString = "";
        for(char ch : S.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    newString += "(";
                }
                count++;
            }
            else{
                count--;
                if(!(count == 0)){
                    newString += ")";
                }
            }
        }
        return newString;
    }

    public static String removeOuterParenthesess(String S) {
        int count = 0;
        StringBuilder s = new StringBuilder();
        for(char ch : S.toCharArray()) {
            if (ch == '(') {
                if (count > 0) {
                    s.append("(");
                }
                count++;
            }
            else{
                count--;
                if(!(count == 0)){
                    s.append(")");
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args){
        String input = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(input));
        System.out.println(removeOuterParenthesess(input));
    }
}

