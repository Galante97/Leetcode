// 220. Contains Duplicate III
public class Solution {
    public bool ContainsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        SortedSet<long> set = new SortedSet<long>();
        
        for (int i = 0; i <  nums.Length; i++) {
            if (set.GetViewBetween((long)nums[i] - t, (long)nums[i] + t).Count > 0) return true;
            set.Add(nums[i]);
            if (i >= k) set.Remove(nums[i - k]);
        }
        return false;
        
    }
}


