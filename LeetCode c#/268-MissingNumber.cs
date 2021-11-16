//268. Missing Number

public class Solution {
    public int MissingNumber(int[] nums) {
        int xor = nums.Length;    

        for (int i=0;i<nums.Length;i++)
            xor = xor^i^nums[i];

        return xor;
    }
    
}