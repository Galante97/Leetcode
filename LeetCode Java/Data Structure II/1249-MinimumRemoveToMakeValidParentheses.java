/*
 * 1249. Minimum Remove to Make Valid Parentheses
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * 
 * Example 1:
    * Input: s = "lee(t(c)o)de)"
    * Output: "lee(t(c)o)de"
    * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 */
class Solution {
    // Time complexity : O(n)
    // Space complexity : O(n), where nn is the length of the input string.
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // add parathesis to a stack, if stack is empty when ) then bad indices
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }

        }
        // any remaining indexes are bad indexes, add to remove set
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // build a string that does not include bad indexes
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
