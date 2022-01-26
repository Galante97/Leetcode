/*
 * 243. Shortest Word Distance
 * Given an array of strings wordsDict and two different strings that already
 * exist in the array word1 and word2, return the shortest distance between
 * these two words in the list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1
 * = "coding", word2 = "practice"
 * Output: 3
 */

 class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        int index1 = -1;
        int index2 = -1;
        int output = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            }

            if (wordsDict[i].equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                output = Math.min(output, Math.max(index1, index2) - Math.min(index1, index2));
            }
        }

        return output;
    }
}