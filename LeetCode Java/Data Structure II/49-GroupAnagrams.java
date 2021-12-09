/*
49. Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

class Solution {
    //Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. 
    //The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string O(KlogK) time.
    //Space Complexity: O(NK), the total information content stored in ans.
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        
        //Sorted word, list of unsorted words
        Map<String, List> ans = new HashMap<String, List>();
        
        for (String s: strs) {
            char[] ca = s.toCharArray();
            //sort word
            Arrays.sort(ca);
            //back to string
            String key = new String(ca);
            //update hashmap
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
            
        }
        
        return new ArrayList(ans.values());
    }
}