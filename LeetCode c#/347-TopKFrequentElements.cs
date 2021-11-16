//347. Top K Frequent Elements

public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        // key: num, value: count
        Dictionary<int, int> counts = new Dictionary<int, int>(); 
        
        //add up the counts of each
        foreach (int x in nums)  {
            if (counts.ContainsKey(x)) {
                counts[x]++;
            } else {
                counts.Add(x, 1);
            }

        }
        
        //take the highest k in counts
        var sortedDict = counts.OrderByDescending(entry=>entry.Value)
                     .Take(k)
                     .ToDictionary(pair=>pair.Key,pair=>pair.Value);
        
        //var lines = sortedDict.Select(kvp => kvp.Key + ": " + kvp.Value.ToString());
        //Console.WriteLine(string.Join(", ", lines));
        
        return sortedDict.Keys.ToArray();
    }
}