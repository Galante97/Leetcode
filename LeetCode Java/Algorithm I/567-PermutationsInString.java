/*
 * 567. Permutation in String
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * Example 1:
    * Input: s1 = "ab", s2 = "eidbaooo"
    * Output: true
    * Explanation: s2 contains one permutation of s1 ("ba").
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        // sort the smaller array
        Arrays.sort(ss1);

        for (int i = 0; i < ss2.length - ss1.length + 1; i++) {
            // get sub array and sort
            char[] sub = Arrays.copyOfRange(ss2, i, i + ss1.length);
            Arrays.sort(sub);

            // if equal return true
            if (Arrays.equals(sub, ss1)) {
                return true;
            }
        }

        return false;
    }
}