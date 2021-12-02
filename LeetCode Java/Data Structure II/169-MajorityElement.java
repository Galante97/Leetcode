/*
169. Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
/*
Approach 3: Sorting
Intuition
If the elements are sorted in monotonically increasing (or decreasing) order, the majority element can be found at index n/2 and (n/2)+1 incidentally, if n is even).

Algorithm
For this algorithm, we simply do exactly what is described: sort nums, and return the element in question. 
*/

class Solution {
    //Time complexity : O(nlogN)
    //Sorting the array costs O(nlgn) time in Python and Java, so it dominates the overall runtime.
    //Space complexity : O(1) or O(n)
    //We sorted nums in place here - if that is not allowed, then we must spend linear additional space on a copy of nums and sort the copy instead.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}