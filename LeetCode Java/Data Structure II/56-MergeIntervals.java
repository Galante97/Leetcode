/*
56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        //sort by first value in inner list
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                // interval does not overlap with the previous, simply append it.
                merged.add(interval);
            }
            else {
                // there is overlap, so we merge the current and previous intervals.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}