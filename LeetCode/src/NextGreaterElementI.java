//You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
//The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
//
//Example 1:
//    Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
//    Output: [-1,3,-1]
//    Explanation:
//    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//    For number 1 in the first array, the next greater number for it in the second array is 3.
//    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
//
//Example 2:
//    Input: nums1 = [2,4], nums2 = [1,2,3,4].
//    Output: [3,-1]
//    Explanation:
//    For number 2 in the first array, the next greater number for it in the second array is 3.
//    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> check = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int j = i + 1;
            while (j < nums2.length) {
                if (nums2[j] > nums2[i]) {
                    check.put(nums2[i], nums2[j]);
                    break;
                }
                j++;
            }
            check.put(nums2[i], check.getOrDefault(nums2[i], -1));
        }
        int[] output = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) output[i] = check.get(nums1[i]);
        return output;
    }
}
