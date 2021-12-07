/*
290. Word Pattern
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
Example 1:
    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true
Example 2:
    Input: pattern = "abba", s = "dog cat cat fish"
    Output: false   

*/
class Solution {
    // Time complexity : O(N) where NN represents the number of words in s or the number of characters in pattern.
    // Space complexity : OO(M) where MM represents the number of unique words in s. Even though we have two hash maps, the character to word hash map has space complexity of O(1) since there can at most be 26 keys.
    public boolean wordPattern(String pattern, String s) {
        //both chars and string have to be unqiue so two hashmaps are required
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> revMap = new HashMap<>();

        String[] words = s.split(" ");
        
        if (words.length != pattern.length()) { return false; }
        
        for (int i=0; i<pattern.length(); i++) {
            Character currLetter = pattern.charAt(i);
            String currWord = words[i];
                               
            if (map.containsKey(currLetter)) { //check map 1
                if (!map.get(currLetter).equals(currWord)) {
                    return false;
                }
                
            } else if (revMap.containsKey(currWord)) { //check map 2
                if (!revMap.get(currWord).equals(currLetter)) {
                    return false;
                }
                
            } else {
                //put to both hashmaps
                map.put(pattern.charAt(i), currWord);
                revMap.put(currWord, pattern.charAt(i));
            }
            
        }
        return true;
    }
}