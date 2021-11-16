//283. Move Zeroes

public class Solution {
    public void MoveZeroes(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.Length; cur++) {
            if (nums[cur] != 0) {
                (nums[lastNonZeroFoundAt], nums[cur]) = (nums[cur], nums[lastNonZeroFoundAt]);
                lastNonZeroFoundAt++;
            }
        } 
    }
}