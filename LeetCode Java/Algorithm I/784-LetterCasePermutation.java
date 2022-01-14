/*
 * 784. Letter Case Permutation
 * Given a string s, you can transform every letter individually to be lowercase
 * or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in
 * any order.
 * 
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 */
class Solution {
    // Time Complexity: O(2^{N} * N), where N is the length of S. This reflects the
    // cost of writing the answer.
    // Space Complexity: O(2^N * N)
    public List<String> letterCasePermutation(String s) {

        List<StringBuilder> output = new ArrayList();
        output.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            int n = output.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    output.add(new StringBuilder(output.get(i))); // duplicate the string
                    output.get(i).append(Character.toLowerCase(c)); // add lower case
                    output.get(n + i).append(Character.toUpperCase(c)); // add upper case to the end
                }

            } else { // number
                for (int j = 0; j < n; ++j) {
                    output.get(j).append(c);
                }
            }
        }

        // convert to string list
        List<String> finalans = new ArrayList();
        for (StringBuilder sb : output)
            finalans.add(sb.toString());

        return finalans;
    }
}