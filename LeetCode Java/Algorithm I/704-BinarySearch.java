/*
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
*/

class Solution {
    //Time complexity : O(log(N)) since it's a standard binary search
    //Space complexity : O(1)
    public int search(int[] nums, int target) {
        int tail = 0;
        int head = nums.length - 1;
        
        while (tail <= head) {
            int pivot = (tail + head) / 2;
            
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                tail = pivot + 1;
            } else if (nums[pivot] > target) {
                head = pivot  - 1;
            }         
        }    
        return -1;      
    }
}