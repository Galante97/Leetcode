/*
763. Partition Labels
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Return a list of integers representing the size of these parts.

Example 1:
    Input: s = "ababcbacadefegdehijhklij"
    Output: [9,7,8]
    Explanation:
    The partition is "ababcbaca", "defegde", "hijhklij".
    This is a partition so that each letter appears in at most one part.
    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
*/

class Solution {
    //Time Complexity: O(N), where N is the length of s.
    //Space Complexity: O(1) to keep data structure last of not more than 26 characters.
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        //get last apperence (index) of each letter
        for (int i = 0; i < s.length(); ++i) {
            //'a' - 'a' will return 0 index, 'z'-'a' will reuturn 25th index 
            last[s.charAt(i) - 'a'] = i;
        }
        
        int anchor = 0; //start of current partition
        int j = 0; //end of currurt partition
        List<Integer> ans = new ArrayList();
        
        //split up partitions
        for (int i = 0; i < s.length(); ++i) {
            //max of previous j OR last index of current letter
            j = Math.max(j, last[s.charAt(i) - 'a']);
            //if current index matches with current max last index, end partion
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;

    }
}