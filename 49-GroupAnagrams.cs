//49. Group Anagrams

public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        if (strs.Length == 0)
            return new List<IList<string>>();
        
        //holds the result
        List<IList<string>> res = new List<IList<string>>();

        //holds <sorted string, anagrams>
        Dictionary <string, List<string>> dict = new Dictionary<string, List<string>>();
        
        foreach (string s in strs) {
            //sort current string
            string sorted = new string(s.OrderBy(x => x).ToArray());
            
            //if key doesn't exist, add it
            if (!dict.ContainsKey(sorted)) {
                dict.Add(sorted, new List<string>());
            } 
            
            //add the word to the proper key
            dict[sorted].Add(s);
            
        }
        
        foreach (var item in dict.Values)
            res.Add(item);
        
        return res;
    }
}