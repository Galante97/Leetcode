/*
 * 695. Max Area of Island
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
class Solution {
    // Depth-First Search (Recursive)
    // Time Complexity: O(R∗C), where RR is the number of rows in the given grid,
    // and C is the number of columns. We visit every square once.
    // Space complexity: O(R∗C), the space used by seen to keep track of visited
    // squares, and the space used by the call stack during our recursion.
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = countIsland(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int countIsland(int[][] grid, int sr, int sc) {
        int count = 1;
        grid[sr][sc] = 0; // flood cell, i.e seen
        // go down
        if (sr + 1 < grid.length && grid[sr + 1][sc] == 1) {
            count += countIsland(grid, sr + 1, sc);
        }
        // go up
        if (sr - 1 >= 0 && grid[sr - 1][sc] == 1) {
            count += countIsland(grid, sr - 1, sc);
        }
        // go right
        if (sc + 1 < grid[0].length && grid[sr][sc + 1] == 1) {
            count += countIsland(grid, sr, sc + 1);
        }
        // go left
        if (sc - 1 >= 0 && grid[sr][sc - 1] == 1) {
            count += countIsland(grid, sr, sc - 1);
        }
        return count;
    }
}