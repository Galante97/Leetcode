//125. Valid Palindrome

using System.Text.RegularExpressions;

public class Solution {
    public bool IsPalindrome(string s) {
            Regex rgx = new Regex("[^a-zA-Z0-9]");
            s = rgx.Replace(s, "");
            s = s.ToLower();

            char[] s_arr = s.ToCharArray();
            char[] s_arr_rev = s.Reverse().ToArray();

            bool isEqual = Enumerable.SequenceEqual(s_arr, s_arr_rev);

            return isEqual;
    }
}