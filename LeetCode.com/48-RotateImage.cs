//48. Rotate Image

public class Solution {
    public void Rotate(int[][] matrix) {
        int n = matrix.GetLength(0);
            double nHalf = n / 2;

            for (int i = 0; i < Math.Floor(nHalf) + n % 2; i++) { //iterate each row
                for (int j = 0; j < Math.Floor(nHalf); j++) //iterate each column
                {
                 

                      var temp = matrix[n - 1 - j][i]; 
                      matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                      matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                      matrix[j][n - 1 - i] = matrix[i][j];
                      matrix[i][j] = temp;
                   
                }

      
            }
    }
}