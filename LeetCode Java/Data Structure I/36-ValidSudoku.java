/*
36. Valid Sudoku
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
*/
class Solution {
    //O(n^2) space complexity
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> currRow = new HashSet<Character>();
        HashSet<Character> currCol = new HashSet<Character>();
        HashSet<Character> currBox = new HashSet<Character>(); 
        for (int r = 0; r<board.length; r++) {
            for (int c = 0; c<board.length; c++) {
                if (board[r][c] != '.') { //rows
                    if (!currRow.contains(board[r][c])) {
                        currRow.add(board[r][c]);
                    } else { return false; }
                }
                //columns - just flip r and c
                if (board[c][r] != '.') {
                    if (!currCol.contains(board[c][r])) {
                        currCol.add(board[c][r]);
                    } else { return false; }
                }
                //will only occur once for each box (top left of each box)
                if (r % 3 == 0 && c % 3 == 0) { 
                    currBox.removeAll(currBox);

                    for (int i = 0; i < 3; i++) {
                        for (int k = 0; k < 3; k++) {
                            if (board[i+r][k+c] != '.') {
                                if (!currBox.contains(board[i+r][k+c])) {
                                    currBox.add(board[i+r][k+c]);
                                } else {
                                    return false;
                                }
                            }   
                        }
                    }
                }
            }
            currCol.removeAll(currCol);
            currRow.removeAll(currRow);
        }
        return true;
    }
}