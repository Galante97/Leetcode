//Given an image represented by an NxN matrix, where each pixel
// in the image is 4bytes, write a method to rotate the image by
//90 degrees, can you do this in place

//0000


public class Program {

    public int[][] Rotate(int[][] matrix, int n) {

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                //save top as temp
                int top = matrix[first][i];
                // left -> top 
                matrix[first][i] = matrix[last-offset][first];
                //bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];
                //right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                //top -> right
                matrix[i][last] = top;

            }
        }

    }

}