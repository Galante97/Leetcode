/*
136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
    Input: nums = [2,2,1]
    Output: 1
*/
/*
Approach: Bit Manipulation

If we take XOR of zero and some bit, it will return that bit
    a ⊕ 0 = a
If we take XOR of two same bits, it will return 0
    a ⊕ a = 0
 
    a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
So we can XOR all bits together to find the unique number.
*/
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        //even occurence will nullify except unique number
        for(int i=0;i<nums.length;i++){
            result ^= nums[i];
        }
        return result;
    }
}