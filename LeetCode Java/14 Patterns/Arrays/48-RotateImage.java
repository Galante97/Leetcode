/*
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 */
class Solution {
    // let M be the number of cells in the matrix.
    // Time complexity : O(M), as each cell is getting read once and written once.
    // Space complexity : O(1) because we do not use any other additional data
    // structures.
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < (len + 1) / 2; i++) {
            for (int j = 0; j < len / 2; j++) {

                // 4 number rotate
                int temp = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - j - 1];
                matrix[len - 1 - i][len - j - 1] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }

    }
}