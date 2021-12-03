/*
435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of
intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
    Output: 1
    Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
*/

class Solution {
    //Time complexity : O(nlog(n)). Sorting takes O(nlog(n)) time.
    //Space complexity : O(1). No extra space is used.
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort by second value in inner list O(N log N) 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int low = intervals[0][0];
        int high = intervals[0][1];
        int overlaps = 0;
        
        //O(N) 
        for (int i=1;i<intervals.length; i++) {
            if (intervals[i][0] < high) { //overlap scenario
                overlaps++;
            } else if (intervals[i][1] > high) { //increase high scenario
                high = intervals[i][1];
            }
        }
        
        return overlaps;
    }
}