//189. Rotate Array

public class Solution {
    public void Rotate(int[] nums, int k) {
        int[] shiftNums = new int[nums.Length];
            
            while (k >= nums.Length) {
                k -= nums.Length;
            } 
        
            if (nums.Length > 1) {
        
                for (int i = 0; i < k; i++) {
                   shiftNums[i] = nums[nums.Length - k + i];
                }

                for (int j = k; j < nums.Length; j++) {
                    shiftNums[j] = nums[j - k];
                }

                shiftNums.CopyTo(nums, 0);
            }
    }
}