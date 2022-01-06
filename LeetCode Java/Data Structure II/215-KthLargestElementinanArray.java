/*
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example 1:
    * Input: nums = [3,2,1,5,6,4], k = 2
    * Output: 5
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
         * O(NLogN) solution
         * O(1) space
         * Arrays.sort(nums);
         * return nums[nums.length - k];
         */

        /*
         * Time complexity : O(Nlogk).
         * Space complexity: O(k) to store the heap elements.
         */
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }
}