//217. Contains Duplicate
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
    Input: nums = [1,2,3,1]
    Output: true

Example 2:
    Input: nums = [1,2,3,4]
    Output: false

Constraints:
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109

*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        
        //unique hashset
        HashSet<Integer> set = new HashSet<Integer>();
        
        //iterate
        for (int num: nums) {
            if (set.contains(num)) { //constant time O(1)
                return true;
            } else {
                set.add(num); //constant time O(1)
            }
        }
        
        return false;
        
    }
}