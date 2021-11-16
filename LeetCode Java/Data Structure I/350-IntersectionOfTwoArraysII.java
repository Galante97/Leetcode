/*
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.
Constraints:
    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //If nums1 is larger than nums2, swap the arrays.
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        
        //For each element in nums1
        for (int n : nums1) {
            //Add it to the hash map m.
            //Increment the count if the element is already there.
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0; //Initialize the insertion pointer (k) with zero.
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            //If the current number is in the hash map and count is positive
            if (cnt > 0) {
                nums1[k++] = n; //Copy the number into nums1[k], and increment k.
                m.put(n, cnt - 1); //Decrement the count in the hash map.
            }
        }
        //Return first k elements of nums1.
        return Arrays.copyOfRange(nums1, 0, k);
    }

}