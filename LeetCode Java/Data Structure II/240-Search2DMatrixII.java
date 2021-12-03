/*
240. Search a 2D Matrix II
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

//Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom, respectively), we can prune O(m) or O(n) elements when looking at any particular value.
class Solution {
    //Time complexity : O(n+m)
    //Space complexity : O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        //pointer starts at bottom left
        int col = 0;
        int row = matrix.length - 1;
        
        while (row >= 0 && col < matrix[0].length) {
            
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { //found it
                return true;
            }         
        }    

        return false;
    }
}