/*
 * 451. Sort Characters By Frequency
 * Given a string s, sort it in decreasing order based on the frequency of the
 * characters. The frequency of a character is the number of times it appears in
 * the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 * Example 1:
    * Input: s = "tree"
    * Output: "eert"
    * Explanation: 'e' appears twice while 'r' and 't' both appear once.
    * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
    * answer.
 */
class Solution {
    // Time Complexity : O(nlogn).
    // Space Complexity : O(n).
    public String frequencySort(String s) {
        if (s == null || s.isEmpty())
            return s;

        // 1. Create a sorted Array of chars.
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // 2. Convert identical chars into single Strings.
        List<String> charStrings = new ArrayList<String>();
        StringBuilder currentString = new StringBuilder();
        currentString.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                charStrings.add(currentString.toString());
                currentString = new StringBuilder();
            }
            currentString.append(chars[i]);
        }
        charStrings.add(currentString.toString());

        // 3.
        // Our comparator is (a, b) -> b.length() - a.length().
        // If a is longer than b, then a negative number will be returned
        // telling the sort algorithm to place a first. Otherwise, a positive
        // number will be returned, telling it to place a second.
        // This results in a longest to shortest sorted list of the strings.
        Collections.sort(charStrings, (a, b) -> b.length() - a.length());

        // 4. Use StringBuilder to build the String to return.
        StringBuilder sb = new StringBuilder();
        for (String str : charStrings)
            sb.append(str);
        return sb.toString();
    }
}