/*
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
    * Input: s = "abcabcbb"
    * Output: 3
    * Explanation: The answer is "abc", with the length of 3.
 */
class Solution {
    // O(n) space and time complexity
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        HashSet<Character> unq = new HashSet<Character>();

        int largest = 0; // output
        int i = 0; // leftside slider
        int j = 0; // right side slider

        // iterate through each letter
        while (j < s.length()) {
            if (!unq.contains(s.charAt(j))) { // add unique characters
                unq.add(s.charAt(j++)); // move right side of the slider
                largest = Math.max(largest, j - i); // take the max seqeuence

            } else {
                unq.remove(s.charAt(i++)); // remove first left side, and move slider
            }

        }

        return largest;
    }
}