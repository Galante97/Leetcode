/*
566. Reshape the Matrix

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example:
    Input: mat = [[1,2],[3,4]], r = 1, c = 4
    Output: [[1,2,3,4]]
*/

class Solution {
    //Time complexity : O(m⋅n). We traverse the entire matrix of size m⋅n once only. 
    //Here, mm and nn refers to the number of rows and columns in the given matrix.
    //Space complexity : O(m⋅n). The resultant matrix of size m⋅n is used.
    
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length; //num columns
        int n = mat[0].length; //num rows
        
        if (m*n != r*c) {
            return mat;
        }
        
        int[][] reshapeMatrix = new int[r][c]; // 2D integer array with r rows and c columns

        int rTmp = 0;
        int cTmp = 0;
        
        for (int i=0; i< m; i++) { //iterate rows
            for (int k=0; k<n; k++) { //iterate columns
                if (cTmp == c) {
                    cTmp = 0;
                    rTmp++;

                }
                reshapeMatrix[rTmp][cTmp] = mat[i][k];
                
                cTmp++;
            }    
            
            
        }
        
        return reshapeMatrix;
        
        
    }
}