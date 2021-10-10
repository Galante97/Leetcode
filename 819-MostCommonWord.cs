// 819. Most Common Word

public class Solution {
    public string MostCommonWord(string paragraph, string[] banned) {
        paragraph = paragraph.ToLower();
        
        Array.Sort(banned);
        Array.Reverse(banned);
        
        //word, count
        Dictionary<string, int> map = new Dictionary<string, int>();
        
        paragraph = paragraph.Replace(",", " ");
        paragraph = paragraph.Replace("!"," ");
        paragraph = paragraph.Replace("\'"," ");
        paragraph = paragraph.Replace("?"," ");
        paragraph = paragraph.Replace(";"," ");
        paragraph = paragraph.Replace("."," ");
    
        foreach (string word in banned) {
            paragraph = paragraph.Replace(word.ToLower()," ");
        }
                
        foreach (string word in paragraph.Split(' ')) {
            if (!map.ContainsKey(word.Trim())) {
                map.Add(word.Trim(), 1);
            } else {
                map[word]++;
            }
        
        }
                
        map.Remove(""); //remove banned word replacement which is nothing

        var maxWord = map.FirstOrDefault(x => x.Value == map.Values.Max()).Key;
        
        return maxWord;
    }
} .  . 