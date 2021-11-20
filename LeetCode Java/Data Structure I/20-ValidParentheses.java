/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
Example:
    Input: s = "()[]{}"
    Output: true
*/

class Solution {
    // Time complexity : O(n) because we simply traverse the given string one character
    // at a time and push and pop operations on a stack take O(1) time.
    // Space complexity : O(n) as we push all opening brackets onto the stack and in 
    // the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
    public boolean isValid(String s) {
        if (s.length() <= 1) { return false; }
        
        //odd number scenario
        if (s.length() % 2 != 0) { return false; } 
        
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        
        while (count < s.length()) {
            //open case - push
            if (s.charAt(count) == '(' || s.charAt(count) == '{' || s.charAt(count) == '[')  {
                stack.push(s.charAt(count));  
            } else { //close case peek and pop
                if (stack.empty()) return false;
                
                if (stack.peek() == '(' && s.charAt(count) == ')' ) {
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(count) == '}' ) {
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(count) == ']' ) {
                    stack.pop();
                } else { //invalid scenario
                    return false;
                }

            }
            count++;
        }
        if (!stack.empty()) return false;
        return true;
        
    }
}