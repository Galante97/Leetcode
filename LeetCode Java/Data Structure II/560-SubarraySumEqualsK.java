/*
560. Subarray Sum Equals K
Given an array of integers nums and an integer k,
return the total number of continuous subarrays whose sum equals to k.
 
Example 1:
    Input: nums = [1,1,1], k = 2
    Output: 2

Example 2:
    Input: nums = [1,2,3], k = 3
    Output: 2

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // <sum, count>
        HashMap<Integer, Integer> map = new HashMap<>();
        //sum of zero has 1 count
        map.put(0, 1);
        
         for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
             if (map.containsKey(sum - k)) {
                 count += map.get(sum - k);
             }
             //add new or update count of existing
             map.put(sum, map.getOrDefault(sum, 0) + 1);
             
         }

        return count;
    }
}