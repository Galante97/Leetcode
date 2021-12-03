/*
48. Rotate Image
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.

*/

class Solution {
    // let M be the number of cells in the matrix.
    // Time complexity : O(M), as each cell is getting read once and written once.
    //Space complexity : O(1) because we do not use any other additional data structures.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int i=0; i < (n + 1) / 2; i++) {
            for (int k=0; k < n / 2; k++) {
                
                //4 number rotate
                int temp = matrix[n - 1 - k][i];
                matrix[n - 1 - k][i] = matrix[n - 1 - i][n - k - 1];
                matrix[n - 1 - i][n - k - 1] = matrix[k][n - 1 -i];
                matrix[k][n - 1 - i] = matrix[i][k];
                matrix[i][k] = temp;

            }
        }
    
    }
}