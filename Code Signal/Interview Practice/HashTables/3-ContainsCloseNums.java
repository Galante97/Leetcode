/*
 * 3 - containsCloseNums
 * Given an array of integers nums and an integer k, determine whether there are
 * two distinct indices i and j in the array where nums[i] = nums[j] and the
 * absolute difference between i and j is less than or equal to k.
 * 
 * Example
 * 
 * For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
 * solution(nums, k) = true.
 * 
 * There are two 2s in nums, and the absolute difference between their positions
 * is exactly 3.
 */
boolean solution(int[] nums, int k) {
    //value, index
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i=0; i<nums.length; i++) {
        if (map.containsKey(nums[i])) {
            //duplicate see if true            
            int dupIndex = map.get(nums[i]);
            
            if (i - dupIndex <= k) {
                return true;
            } 
        } 
        map.put(nums[i], i);
    }  
    return false; 
    
}
