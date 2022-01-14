/*
 * 120. Triangle
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
     * 2
    * 3 4
   * 6 5 7
  * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
 * above).
 */
class Solution {
    // O(n^2)
    // O(1)
    public int minimumTotal(List<List<Integer>> triangle) {
        // n array

        int total = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int sum = 0;
                if (j == 0) { // j = first in column
                    // sum of current plus one above first index (j)
                    sum = triangle.get(i).get(j) + triangle.get(i - 1).get(j);
                } else if (j == triangle.get(i).size() - 1) { // j = last in column
                    // current cell plus last cell of row above
                    sum = triangle.get(i).get(j) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1);
                } else {
                    // min of two above it
                    int min = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));

                    sum = min + triangle.get(i).get(j);
                }
                // update in place the min sum for every value
                triangle.get(i).set(j, sum);
            }
        }
        // min in last row
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}