//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//Note:
//
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

//Example 1:
//
//Input: [2,2,1]
//Output: 1

//Example 2:
//
//Input: [4,1,2,1,2]
//Output: 4

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int output = 0;
        for (int key: count.keySet()) {
            if (count.get(key) == 1) {
                output = key;
            }
        }
        return output;
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }
}
