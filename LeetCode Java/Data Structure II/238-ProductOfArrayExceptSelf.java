/*
238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
*/
class Solution {
    //Time complexity : O(N) where N represents the number of elements in the input array
    //Space complexity : O(1) since don't use any additional array for our computations. The problem statement mentions that using the  answer array doesn't add to the space complexity.
    public int[] productExceptSelf(int[] nums) {
        int NoZerosTotal = -31; //out of constraint range, sudo null
        int zeroCount = 0;
        boolean zerosExist = false;
        int[] output = new int[nums.length];
        
        for (int n : nums) {
            if (n != 0) {
                if (NoZerosTotal == -31) { //initial set of NoZeros
                    NoZerosTotal = n;
                } else {
                    NoZerosTotal *= n;
                }
            } else {
                zeroCount++;
                zerosExist = true;
            }
        }
        
        //array will be all zeros
        if (zeroCount > 1) {return new int[nums.length]; }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zerosExist) {
                    output[i] = 0;
                } else {
                    output[i] = NoZerosTotal / nums[i];
                }
            } else {
                output[i] = NoZerosTotal;
            }            
        } 
        return output;
    }
}