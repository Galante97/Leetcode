//3. Longest Substring Without Repeating Characters

public class Solution {
    public int LengthOfLongestSubstring(string s) {

        if (s == null || s == String.Empty)
            return 0;

        HashSet<char> set = new HashSet<char>();
        int currentMax = 0;
        int i = 0;
        int j = 0;

        while (j < s.Length)
            if (!set.Contains(s[j]))  {
                set.Add(s[j++]);
                currentMax = Math.Max(currentMax, j - i);
            }
            else
                set.Remove(s[i++]);

        return currentMax;
    }
    
    
}