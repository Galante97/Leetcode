//242. Valid Anagram


public class Solution {
    public bool IsAnagram(string s, string t) {
       
            if (s.Length != t.Length)
                return false;
        
            char[] charArray_S = s.ToCharArray();
            char[] charArray_T = t.ToCharArray();

            Array.Sort(charArray_S);
            Array.Sort(charArray_T);

            bool isEqual = Enumerable.SequenceEqual(charArray_S, charArray_T);
            return isEqual;
            
    }
}