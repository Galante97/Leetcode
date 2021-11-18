/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true
Example 2:
    Input: s = "rat", t = "car"
    Output: false
 
Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.
*/

class Solution {
    //Time complexity : O(n). because accessing the counter table is a constant time operation.
    //Space complexity : O(1). Although we do use extra space, the table's size stays constant no matter how large n is.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        //string are the same length, add and subtract counts
        int[] counter = new int[26];
        for (int i=0; i<s.length(); i++) {
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(i) - 'a'); //'a' = 0, 'z' = 25
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
                        
        }
        
        //iterate through to make sure all 26 chars are numbers
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}