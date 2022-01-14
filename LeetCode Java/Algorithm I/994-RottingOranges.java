/*
 * 994. Rotting Oranges
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten  orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        // intial state (O(m*n))
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { // fresh
                    fresh.add("" + i + j);
                } else if (grid[i][j] == 2) { // rotten
                    rotten.add("" + i + j);
                }
            }
        }
        int minutes = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        // BFS
        while (fresh.size() > 0) {
            Set<String> infected = new HashSet<>();
            for (String s : rotten) {
                // get coords
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                // check 4 directions
                for (int[] direction : directions) {
                    int nextI = direction[0] + i;
                    int nextJ = direction[1] + j;
                    String nextOrange = "" + nextI + nextJ;
                    if (fresh.contains(nextOrange)) {
                        fresh.remove(nextOrange);
                        rotten.remove(nextOrange);
                        infected.add(nextOrange);
                    }
                }
            }
            // stand alone fresh oranges exist
            if (infected.size() == 0) {  return -1;  }
            rotten = infected;
            minutes++;
        }
        return minutes;
    }
}