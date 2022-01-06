/*
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 */
class Solution {
    // Time complexity : O(Nlogk) if k < Nk<N and O(N) in the particular case of
    // N=k. That ensures time complexity to be better than O(NlogN).
    // Space complexity : O(N+k) to store the hash map with not more NN elements and
    // a heap with k elements.
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        // 1. build hash map : character and how often it appears
        // O(N) time
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }
        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> counts.get(n1) - counts.get(n2));
        // Queue<Integer> heap = new PriorityQueue<>(); - this would be most frequent

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n : counts.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
