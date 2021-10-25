// 17. Letter Combinations of a Phone Number

public class Solution {
    private IList<string> oList = new List<string>();
    private Dictionary<char, List<char>> map = new Dictionary<char, List<char>>();
    
    public IList<string> LetterCombinations(string digits) {
        if (digits == null || digits == string.Empty)
            return oList;
        
        map.Add('2', new List<char>() { 'a', 'b', 'c' });
        map.Add('3', new List<char>() { 'd', 'e', 'f' });
        map.Add('4', new List<char>() { 'g', 'h', 'i' });
        map.Add('5', new List<char>() { 'j', 'k', 'l' });
        map.Add('6', new List<char>() { 'm', 'n', 'o' });
        map.Add('7', new List<char>() { 'p', 'q', 'r', 's' });
        map.Add('8', new List<char>() { 't', 'u', 'v' });
        map.Add('9', new List<char>() { 'w', 'x', 'y', 'z' });
        
        builder(digits, 0, new StringBuilder());
        
        return oList;
    
    }
    
    private void builder(string digits, int i, StringBuilder cur)
    {
        
        if (i == digits.Length)
            oList.Add(cur.ToString());
        else
            foreach (var item in map[digits[i]])
            {
                cur.Append(item);
                
                builder(digits, i + 1, cur);
                
                cur.Remove(cur.Length - 1, 1);
            }
    }
}