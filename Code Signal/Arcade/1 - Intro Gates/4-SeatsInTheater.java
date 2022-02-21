/*
 * 4 - Seats in Theater
 * Given the total number of rows and columns in the theater (nRows and nCols,
 * respectively), and the row and column you're sitting in, return the number of
 * people who sit strictly behind you and in your column or to the left,
 * assuming all seats are occupied.
 * 
 * Example
 * 
 * For nCols = 16, nRows = 11, col = 5, and row = 3, the output should be
 * solution(nCols, nRows, col, row) = 96.
 */
int solution(int nCols, int nRows, int col, int row) {
    int seatsToExit = nCols - col + 1;
    int seatsBehind = nRows - row;
    
    return seatsToExit * seatsBehind;
}
