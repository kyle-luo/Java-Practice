//Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
//
//        Example:
//
//        Input: ["Hello", "Alaska", "Dad", "Peace"]
//        Output: ["Alaska", "Dad"]
import java.util.regex.*;
import java.util.*;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        ArrayList<String> output = new ArrayList<String>();
        Pattern p = Pattern.compile("(?i)[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*");
        for (String word:words) {
            Matcher m = p.matcher(word);
            if (m.matches()) output.add(word);
        }
        String[] result = new String[output.size()];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
}