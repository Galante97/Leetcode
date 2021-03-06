/*
1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //value, index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) { //O(N);
            int complement = target - nums[i]; 
            
            if (map.containsKey(complement)) { //constant time O(1);
                return new int[]{map.get(complement), i}; //constant time O(1);
            } else {
                map.put(nums[i], i); //constant time O(1);
            }
        }
                                      
      return new int[]{-1, -1};
        
    }
}