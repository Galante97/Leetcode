/*
 * Rotate 2d Array
 * Note: Try to solve this task in-place (with O(1) additional memory), since
 * this is what you'll be asked to do during an interview.
 * 
 * You are given an n x n 2D matrix that represents an image. Rotate the image
 * by 90 degrees (clockwise).
 */
int[][] solution(int[][] a) {
    int len = a.length - 1;
    for (int i=0; i<(a.length + 1) / 2; i++) {
        for (int j = 0; j<a.length / 2; j++) {
            // 4 number rotate
            int temp = a[len - j][i];
            a[len - j][i] = a[len - i][len - j];
            a[len - i][len - j] = a[j][len- i];
            a[j][len - i] = a[i][j];
            a[i][j] = temp;
        
        }
        
    }
    return a;
}
