/*
387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:
    Input: s = "leetcode"
    Output: 0
Example 2:
    Input: s = "loveleetcode"
    Output: 2
Example 3:
    Input: s = "aabb"
    Output: -1
Constraints:
    1 <= s.length <= 105
    s consists of only lowercase English letters.
*/

class Solution {
    //Time complexity : O(N) since we go through the string of length N two times.
    //Space complexity : O(1) because English alphabet contains 26 letters.
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //add chars to to map with their counts
        for (int i = 0; i < s.length(); i++) { //O(n)
            char c = s.charAt(i);
            if (map.containsKey(c)) { //O(1) 
                int count = map.get(c);
                map.put(c, ++count);
            } else {
                map.put(c, 1); //O(1) 
            }
        }
        //find the first character with a count of 1
        for (int i = 0; i < s.length(); i++) { //O(n)
               if (map.get(s.charAt(i)) == 1) {
                   return s.indexOf(s.charAt(i));
               }
        }
        
        return -1;
    
    }
}