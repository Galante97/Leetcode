/*
15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
Solution:
    So, we essentially need to find three numbers x, y, and z such that they add up to the given value.
    If we fix one of the numbers say x, we are left with the two-sum problem at hand!
*/

class Solution {
    //Time Complexity: O(n^2)
    //Space Complexity O(n) for hashset/hashmap
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            
            if (dups.add(nums[i])) {
                
                for (int j = i + 1; j < nums.length; ++j) {
                    
                    int complement = -nums[i] - nums[j];
                    
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                        
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList(res);
    }
}