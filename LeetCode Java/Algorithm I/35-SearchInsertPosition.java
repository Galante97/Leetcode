/*
 * 35. Search Insert Position
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
    * Input: nums = [1,3,5,6], target = 5
    * Output: 2
 */
class Solution {
    // Time complexity : O(log(N)) since it's a standard binary search
    // Space complexity : O(1)
    public int searchInsert(int[] nums, int target) {
        int tail = 0;
        int head = nums.length - 1;

        while (tail <= head) {
            int pivot = (tail + head) / 2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                tail = pivot + 1;
            } else if (nums[pivot] > target) {
                head = pivot - 1;
            }
        }
        // returns leftmost of where binary search finishes
        return Math.max(tail, head);
    }
}