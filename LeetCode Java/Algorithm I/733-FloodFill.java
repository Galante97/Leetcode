/*
 * 733. Flood Fill
 * An image is represented by an m x n integer grid image where image[i][j]
 * represents the pixel value of the image.
 * 
 * You are also given three integers sr, sc, and newColor. You should perform a
 * flood fill on the image starting from the pixel image[sr][sc].
 * 
 * To perform a flood fill, consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color), and so on. Replace the color of all of the
 * aforementioned pixels with newColor.
 * 
 * Return the modified image after performing the flood fill.
 */
class Solution {
    // Time Complexity: O(N), where N is the number of pixels in the image. We might
    // process every pixel.
    // Space Complexity: O(N), the size of the implicit call stack when calling dfs.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        image[sr][sc] = newColor;

        // go down
        if (sr + 1 < image.length) {
            if (image[sr + 1][sc] == originalColor && image[sr + 1][sc] != newColor) {
                floodFill(image, sr + 1, sc, newColor);
            }
        }
        // go up
        if (sr - 1 >= 0) {
            if (image[sr - 1][sc] == originalColor && image[sr - 1][sc] != newColor) {
                floodFill(image, sr - 1, sc, newColor);
            }
        }
        // go right
        if (sc + 1 < image[0].length) {
            if (image[sr][sc + 1] == originalColor && image[sr][sc + 1] != newColor) {
                floodFill(image, sr, sc + 1, newColor);
            }
        }
        // go left
        if (sc - 1 >= 0) {
            if (image[sr][sc - 1] == originalColor && image[sr][sc - 1] != newColor) {
                floodFill(image, sr, sc - 1, newColor);
            }
        }
        return image;
    }
}