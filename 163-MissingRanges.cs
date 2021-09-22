//163. Missing Ranges

public class Solution {
    public IList<string> FindMissingRanges(int[] nums, int lower, int upper) {
        if (nums.Length == 0) {
            return new List<string>() { CreateRange(lower, upper) };
        }
        
        
        var oList = new List<string>();
            
        //lower
        if (lower + 1 <= nums[0]) {
            string range = CreateRange(lower, nums[0]-1);
            oList.Add(range);
        }
        
        //mid
        for (int i = 0; i < nums.Length - 1; i++) {
            if (nums[i]+1 != nums[i+1]) {
                string range = CreateRange(nums[i]+1, nums[i+1]-1);
                oList.Add(range);
            }
        } 
        
        //upper
        if (nums[nums.Length-1] + 1 <= upper) {
            string range = CreateRange(nums[nums.Length-1] + 1, upper);
            oList.Add(range);
        }
        
        return oList;    
    }
    
    public string CreateRange(int lower, int upper) {
        if (lower == upper) {
            return lower.ToString();
        } else {
            return lower.ToString() + "->" + upper.ToString();
        }
    }
}