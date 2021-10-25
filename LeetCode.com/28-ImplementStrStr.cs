// 28. Implement strStr()

public class Solution {
    public int StrStr(string haystack, string needle) {
            if (String.IsNullOrEmpty(needle))
                return 0;

            var index = haystack.IndexOf(needle);

            return index;
    }
}