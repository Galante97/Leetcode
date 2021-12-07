/*
409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters, return the length of the
 longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Example 1:
    Input: s = "abccccdd"
    Output: 7
    Explanation:
    One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

class Solution {
    public int longestPalindrome(String s) {        
        int[] count = new int[128];
        
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        
        int total = 0;
        
        // for-each loop
        for(int v : count) {
            //this will always round down, making even matches
            total += v / 2 * 2;
            
        }
        //means there is atleast one unmatched char, which can be the center 
        if( total<s.length() ) total++;
        
        return total;
    }
}