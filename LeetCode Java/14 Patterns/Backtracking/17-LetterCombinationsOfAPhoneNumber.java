/*
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example 1:
    * Input: digits = "23"
    * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList(); // acting as a queue
        if (digits.length() == 0)
            return output;
        output.add("");

        String[] char_map = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));

            while (output.peek().length() == i) { // first element length vs i
                String permutation = output.remove(); // pop

                for (char c : char_map[index].toCharArray()) { // go through each letter
                    output.add(permutation + c); // re add to queue
                }
            }

        }

        return output;
    }
}