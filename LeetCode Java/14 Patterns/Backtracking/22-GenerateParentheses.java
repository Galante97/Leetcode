/*
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
 class Solution {
    List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {

        Backtrack(new String(), 0, 0, n);
        return res;

    }
    public void Backtrack(String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            res.add(curr);
            return;
        }

        if (open < max) {
            // Backtrack
            Backtrack(curr + "(", open + 1, close, max);
        }

        if (close < open) {
            // Backtrack
            Backtrack(curr + ")", open, close + 1, max);
        }

    }
}