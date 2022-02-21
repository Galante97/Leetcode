/*
 * 361. Bomb Enemy
 * Given an m x n matrix grid where each cell is either a wall 'W', an enemy 'E' or empty '0', return the maximum enemies you can kill using one bomb. You can only place the bomb in an empty cell.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since it is too strong to be destroyed.
 */
class Solution {
    // Let WW be the width of the grid and HH be the hight of the grid.
    // Time Complexity: O(W*H*(W+H))
    // Space Complexity: O(1)
    public int maxKilledEnemies(char[][] grid) {

        int maxKill = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '0') {
                    int localKill = 0;

                    localKill += Kills(grid, i, j);
                    maxKill = Math.max(maxKill, localKill);
                }
            }
        }
        return maxKill;
    }

    // DFS
    public int Kills(char[][] grid, int i, int j) {
        int goLeft = j - 1;
        int goRight = j + 1;

        int killCount = 0;

        while (goRight < grid[0].length && goRight >= 0) {
            if (grid[i][goRight] == 'W') {
                break;
            } else if (grid[i][goRight] == 'E') {
                killCount++;
            }
            goRight++;

        }

        while (goLeft >= 0 && goLeft < grid[0].length) {
            if (grid[i][goLeft] == 'W') {
                break;
            } else if (grid[i][goLeft] == 'E') {
                killCount++;

            }
            goLeft--;
        }

        int goUp = i - 1;
        int goDown = i + 1;

        while (goDown < grid.length && goDown >= 0) {
            if (grid[goDown][j] == 'W') {
                break;
            } else if (grid[goDown][j] == 'E') {
                killCount++;
            }
            goDown++;

        }

        while (goUp >= 0 && goUp < grid.length) {
            if (grid[goUp][j] == 'W') {
                break;
            } else if (grid[goUp][j] == 'E') {
                killCount++;

            }
            goUp--;
        }

        return killCount;
    }

}
