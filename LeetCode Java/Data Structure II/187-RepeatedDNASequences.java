/*
187. Repeated DNA Sequences
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences 
(substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

Example 1:
    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    Output: ["AAAAACCCCC","CCCCCAAAAA"]

*/

class Solution {
    //Time Complexity: O(N), where N is the length of s.
    //Space Complexity: O(N) for the hashsets
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) { new ArrayList<String>(); }
        
        //This will add everything
        HashSet<String> singleDNA = new HashSet<String>();   
        //this will only hold things that already occurred
        HashSet<String> doubleDNA = new HashSet<String>();   
        
        for (int i=0; i<s.length() - 10 + 1; i++) {
            //new string from i to i+10
             String currDNA = s.substring(i, i + 10);

            if (singleDNA.contains(currDNA)) {
                doubleDNA.add(currDNA);
            }
            singleDNA.add(currDNA);
            
        }
        
        return new ArrayList<String>(doubleDNA);
    }
}