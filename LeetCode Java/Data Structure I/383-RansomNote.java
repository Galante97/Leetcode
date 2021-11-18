/*
383. Ransom Note
Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
    Input: ransomNote = "a", magazine = "b"
    Output: false
Example 2:
    Input: ransomNote = "aa", magazine = "ab"
    Output: false
Example 3:
    Input: ransomNote = "aa", magazine = "aab"
    Output: true
*/

class Solution {
    //Time Complexity : O(m+r) where r and m are the lengths of ransomNot and magazine
    //Space Complexity : O(k) -> O(1) where k is never more then 26 which is a constant 
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
             
        for (int i=0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (count.containsKey(c)) {
                int val = count.get(c);
                count.put(c, ++val);
            } else {
                count.put(c, 1);
            }
        }
        
        for (int j=0; j<ransomNote.length(); j++) {
            char c = ransomNote.charAt(j);
            if (!count.containsKey(c)) {
                return false;
            } else { //contains letter
                if (count.get(c) >= 1) {
                    int val = count.get(c);
                    count.put(c, --val);
                } else {
                    return false;
                }
            }
        }
        return true; 
    }
}