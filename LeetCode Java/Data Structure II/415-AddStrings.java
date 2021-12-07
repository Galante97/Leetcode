/*
415. Add Strings

Given two non-negative integers, num1 and num2 represented as string, 
return the sum of num1 and num2 as a string.
You must solve the problem without using any 
built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:
    Input: num1 = "11", num2 = "123"
    Output: "134"
Example 2:
    Input: num1 = "456", num2 = "77"
    Output: "533"

*/
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        
        int carry = 0;
        //pointers at each end of num1 and num2
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        
        while(p1 >= 0 || p2 >= 0) {
            // - '0' will convert char to int 
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            //will get rid of carry value i.e 18 will be 8
            int value = (x1 + x2 + carry) % 10;
            //new carry
            carry = (x1 + x2 + carry) / 10;
            
            res.append(value);
            p1--;
            p2--;   
        }
        
        if (carry != 0)
            res.append(carry);
        
        //must reverse the string
        return res.reverse().toString();

    }
}