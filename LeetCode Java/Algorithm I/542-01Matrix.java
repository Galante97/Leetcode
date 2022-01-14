/*
 * 542. 01 Matrix
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * The distance between two adjacent cells is 1.
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j }); // add
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); // remove
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        mat[r][c] <= mat[cell[0]][cell[1]] + 1)
                    continue;
                queue.add(new int[] { r, c });
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }

        }
        return mat;
    }

}