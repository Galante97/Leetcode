/*
59. Spiral Matrix II
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Example:
    Input: n = 3
    Output: [[1,2,3],[8,9,4],[7,6,5]]
*/
class Solution {
    // Time Complexity: O(n ^ 2)
    // Space Complexity: O(1) We use constant extra space
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        
        int x = 0;
        int y = 0;
        
        int counter = 1;
        int layer = 0;
        int len = n - 1;
        
        //start going right
        int x_flipper = 1;
        int y_flipper = 0;
        
        //if 3x3, less then 8
        while(counter < n * n + 1) {
            arr[y][x] = counter;
            if (x == len - layer && y == layer) { //switch to down
                x_flipper = 0;
                y_flipper = 1;
            } else if (x == len - layer && y == len - layer) { //switch to left
                x_flipper = -1;
                y_flipper = 0;
            } else if (x == layer && y == len - layer) { //switch to up
                x_flipper = 0;
                y_flipper = -1;
                layer++; //new layer for next spiral
            } else if (x == layer - 1 && y == layer) { //switch to right
                x_flipper = 1;
                y_flipper = 0;
            }
            
            counter++;
            // always add, but might be adding negative number
            x += x_flipper;
            y += y_flipper;    
        }
        return arr;
    }
}