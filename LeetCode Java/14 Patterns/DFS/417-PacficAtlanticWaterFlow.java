/*
 * 417. Pacific Atlantic Water Flow
 * There is an m x n rectangular island that borders both the Pacific Ocean and
 * Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
 * and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n
 * integer matrix heights where heights[r][c] represents the height above sea
 * level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring
 * cells directly north, south, east, and west if the neighboring cell's height
 * is less than or equal to the current cell's height. Water can flow from any
 * cell adjacent to an ocean into the ocean.*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                // check pacific
                boolean reachedPacific = canReachPacific(heights, i, j);
                // check atlantic
                boolean reachedAtlantic = canReachAtlantic(heights, i, j);
                if (reachedPacific && reachedAtlantic) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    res.add(coord);
                }
                checked.clear();
                checked2.clear();
            }
        }
        return res;
    }
    HashSet<String> checked = new HashSet<>();
    public boolean canReachPacific(int[][] heights, int i, int j) {
        checked.add(Integer.toString(i) + Integer.toString(j));
        if (i <= 0 || j <= 0) { // reached pacific
            return true;
        }
        boolean reached1 = false;
        boolean reached2 = false;
        boolean reached3 = false;
        boolean reached4 = false;

        if (i - 1 >= 0 && !checked.contains(Integer.toString(i - 1) + Integer.toString(j))
                && heights[i][j] >= heights[i - 1][j]) {
            reached1 = canReachPacific(heights, i - 1, j); // up
        }
        if (i + 1 < heights.length && !checked.contains(Integer.toString(i + 1) + Integer.toString(j))
                && heights[i][j] >= heights[i + 1][j]) {
            reached2 = canReachPacific(heights, i + 1, j); // down
        }
        if (j - 1 >= 0 && !checked.contains(Integer.toString(i) + Integer.toString(j - 1))
                && heights[i][j] >= heights[i][j - 1]) {
            reached3 = canReachPacific(heights, i, j - 1); // left
        }
        if (j + 1 < heights[0].length && !checked.contains(Integer.toString(i) + Integer.toString(j + 1))
                && heights[i][j] >= heights[i][j + 1]) {
            reached4 = canReachPacific(heights, i, j + 1); // right
        }
        if (reached1 || reached2 || reached3 || reached4) {
            return true;
        } else {
            return false;
        }
    }
    HashSet<String> checked2 = new HashSet<>();
    public boolean canReachAtlantic(int[][] heights, int i, int j) {
        checked2.add(Integer.toString(i) + Integer.toString(j));
        if (i >= heights.length - 1 || j >= heights[0].length - 1) { // reached atlantic
            return true;
        }
        boolean reached1 = false;
        boolean reached2 = false;
        boolean reached3 = false;
        boolean reached4 = false;
        if (i - 1 >= 0 && !checked2.contains(Integer.toString(i - 1) + Integer.toString(j))
                && heights[i][j] >= heights[i - 1][j]) {
            reached1 = canReachAtlantic(heights, i - 1, j); // up
        }
        if (i + 1 < heights.length && !checked2.contains(Integer.toString(i + 1) + Integer.toString(j))
                && heights[i][j] >= heights[i + 1][j]) {
            reached2 = canReachAtlantic(heights, i + 1, j); // down
        }
        if (j - 1 >= 0 && !checked2.contains(Integer.toString(i) + Integer.toString(j - 1))
                && heights[i][j] >= heights[i][j - 1]) {
            reached3 = canReachAtlantic(heights, i, j - 1); // left
        }
        if (j + 1 < heights[0].length && !checked2.contains(Integer.toString(i) + Integer.toString(j + 1))
                && heights[i][j] >= heights[i][j + 1]) {
            reached4 = canReachAtlantic(heights, i, j + 1); // right
        }
        if (reached1 || reached2 || reached3 || reached4) {
            return true;
        } else {
            return false;
        }
    }
}