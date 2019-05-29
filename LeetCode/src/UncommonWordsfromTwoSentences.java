//We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
//
//A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
//Return a list of all uncommon words.
//
//You may return the list in any order.
//
//
//
//Example 1:
//
//Input: A = "this apple is sweet", B = "this apple is sour"
//Output: ["sweet","sour"]
//
//Example 2:
//
//Input: A = "apple apple", B = "banana"
//Output: ["banana"]

public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap<String, Integer>();
        for (String word: A.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word: B.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        ArrayList<String> output = new ArrayList<String>();
        for (String key: count.keySet()) {
            if (count.get(key) == 1) {
                output.add(key);
            }
        }
        String[] result = new String[output.size()];
        int i = 0;
        for (String word: output) {
            result[i] = word;
            i++;
        }
        return result;
    }
}
