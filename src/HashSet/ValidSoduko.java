/*
 * 
 * 36. Valid Soduko
 * https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 * 
 */
package HashSet;


public class ValidSoduko {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.' && !isValidPlacement(board, board[row][column], row, column))
                    return false;
            }
        }
        return true;
    }

    private boolean isNumberInRow(char[][] board, char number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (column != i && board[row][i] == number) return true;
        }
        return false;
    }

    private boolean isNumberInColumn(char[][] board, char number, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (row != i && board[i][column] == number) return true;
        }
        return false;
    }

    private boolean isNumberInBox(char[][] board, char number, int row, int column) {
        int boxRow = row - row % 3;
        int boxColumn = column - column % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxColumn; j < boxColumn + 3; j++) {
                if (row != i && column != j && board[i][j] == number) return true;
            }
        }
        return false;
    }

    private boolean isValidPlacement(char[][] board, char number, int row, int column) {
        return !isNumberInRow(board, number, row, column) &&
                !isNumberInColumn(board, number, row, column) &&
                !isNumberInBox(board, number, row, column);
    }
}
