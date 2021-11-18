/*
74. Search a 2D Matrix

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Example:
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true

*/

class Solution {
    //Time complexity : O(log(mn)) since it's a standard binary search
    //Space complexity : O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search
        int m = matrix.length; //num columns
        int n = matrix[0].length; //num rows
        
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            //pivot if 1d array
            int pivot_idx = (left + right) / 2;
           
            //convert point for 2d array
            int row = pivot_idx / n;
            int col = pivot_idx % n; 
            int pivotElement = matrix[row][col];
            
            //check logic for pivot and reset
            if (pivotElement == target) {
                return true;
            } else if (pivotElement < target) {
                left = pivot_idx + 1;
            } else if (pivotElement > target) {
                right = pivot_idx - 1;
            }
            
            
        }
        return false;
    }
}