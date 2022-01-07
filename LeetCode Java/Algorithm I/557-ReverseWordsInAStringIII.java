/*
 * 557. Reverse Words in a String III
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 * 
 * Example 1:
    * Input: s = "Let's take LeetCode contest"
    * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
    * Input: s = "God Ding"
    * Output: "doG gniD"
 */
class Solution {
    // Time complexity : O(n). where n is the length of the string.
    // Space complexity : O(n). output of size n is used.
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String output = "";

        for (String word : words) { // iterate each word
            char[] s_arr = word.toCharArray();
            for (int i = 0; i < s_arr.length / 2; i++) { // rotate each word
                char temp = s_arr[s_arr.length - 1 - i];
                s_arr[s_arr.length - 1 - i] = s_arr[i];
                s_arr[i] = temp;
            }

            // concat
            output += new String(s_arr) + " ";

        }

        return output.trim();
    }
}