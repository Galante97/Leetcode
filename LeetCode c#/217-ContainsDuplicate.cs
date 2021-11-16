//217. Contains Duplicate

public class Solution {
    public bool ContainsDuplicate(int[] nums) {
        Array.Sort(nums);
        for (int i = 0; i<nums.Length - 1; i++) {
            
            if (nums[i] == nums[i+1]) { //duplicate
                return true;
            }
        }
        
        return false;
    }
}