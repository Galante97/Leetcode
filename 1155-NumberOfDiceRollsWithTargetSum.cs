//1155. Number of Dice Rolls With Target Sum

public class Solution {
    public int NumRollsToTarget(int d, int f, int target) {
        int MOD = 1_000_000_007;
        Dictionary<string, int> map = new Dictionary<string, int>();
        
        if (target < d || target>d*f)
            return 0;
        
        if (d==1) return (target<=f)? 1:0;
        
        string key = ""+d+f+target;
        
        if (!map.ContainsKey(key)) {
            int sum = 0;
            for (int i = 1; i <= f; i++) {
                sum += NumRollsToTarget(d-1, f, target-i);
                sum%=MOD;
            }
            map.Add(key, sum);
        }
        
        return map[key];
    
        
    }
}