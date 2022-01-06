/*
 * 1861. Rotating the Box
 * You are given an m x n matrix of characters box representing a side-view of a
 * box. Each cell of the box is one of the following:
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall
 * due to gravity. Each stone falls down until it lands on an obstacle, another
 * stone, or the bottom of the box. Gravity does not affect the obstacles'
 * positions, and the inertia from the box's rotation does not affect the
 * stones' horizontal positions.
 * 
 * It is guaranteed that each stone in box rests on an obstacle, another stone,
 * or the bottom of the box.
 * 
 * Return an n x m matrix representing the box after the rotation described
 * above.
 * Example 2:
    * Input: box = [["#",".","*","."],
    * ["#","#","*","."]]
    * Output: [["#","."],
    * ["#","#"],
    * ["*","*"],
    * [".","."]]
 */
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; // height
        int n = box[0].length; // width
        char[][] res = new char[n][m]; // output

        for (int i = 0; i < m; i++) { // iterate down (on matrix)
            for (int j = n - 1, k = n - 1; j >= 0; j--) { // iterate left to right (on matrix)

                res[j][m - 1 - i] = '.'; // equalivalent spot on roated matrix

                if (box[i][j] != '.') { // check to see if current spot is not empty
                    if (box[i][j] == '*') { // see if its a blocker
                        k = j; // setting a new local bottom, moving it up each time a blocker is found
                    }
                    // Set new matrix equalivalent to either # or *
                    res[k--][m - 1 - i] = box[i][j];
                }
            }
        }
        return res;
    }
}