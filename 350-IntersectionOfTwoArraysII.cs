//350. Intersection of Two Arrays II

public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
            List<int> num1_list = nums1.ToList();
            List<int> num2_list = nums2.ToList();
        
             var result = num1_list.Where(t => num2_list.Remove(t));

            return result.ToArray();
    }
}