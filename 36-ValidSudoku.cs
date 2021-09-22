//36. Valid Sudoku

public class Solution {
    public bool IsValidSudoku(char[][] board) {
        // iterate through rows, then columns
            for (int i = 0; i < 9; i++)
            {
                //is valid columns 1-9, every row
                if (!isParticallyValid(board, i, 0, i, 8))
                    return false;

                //is valid rows 1-9, every column
                if (!isParticallyValid(board, 0, i, 8, i))
                    return false;
            }

            //iterate through subboxes
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (!isParticallyValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2))
                        return false;
                }
            }
        
        return true;
    }
    
    
    public bool isParticallyValid(char[][] board, int x1, int y1, int x2, int y2)
        {
            var set = new HashSet<char>(); //do not have duplicates
            for (int row = x1; row <= x2; row++)
            {
                for (int col = y1; col <= y2; col++)
                {
                    if (board[row][col] != '.') //ignore blanks
                    {
                        if (!set.Add(board[row][col])) //if not added, invalid board
                            return false;
                    }
                }
            }

            return true;
        }
    
}