/*
 * 
 * Implement the N queens problems for a chess board of size N x N and N queens such that, no Queen kills the other 
 * 
 * Template Code For Backtracking : This code works for all backtracking problems
 * 
 * boolean find_the_solution(level, ...other args...){
 *      if found_solution:
 *          return true;
 *      
 *      is_valid = false;
 *      for ( all possibilities at current level){
 *          if constraints are satisfies{
 *              save current possibility
 *              if(find_the_solution(level+1,...other args...)){
 *                  is_valid = true;
 *                  return true; //if you want to show all possibilites, dont return here
 *
 *              }
 *              remove current possibility
 *          }
 *     }
 *      return is_valid
 * }
 */

package Recursion.Backtracking;

public class NQueens {

    public static void print(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + "       ");
            }
            System.out.println();
        }
    }

    public static boolean is_safe(int row, int col, int[][] board){

        //check if any queen in same row
        for(int j = 0 ; j < board[0].length; j++){
            if(board[row][j] == 1)
                return false;
        }
        //check if any queen in upper diagnol
        for(int i = row, j = col; i >= 0 && j >=0; i--, j--){
            if(board[i][j] == 1)
                return false;
        }
        //check if any queen in lower diagnol
        for(int i = row, j = col; i < board.length && j>=0; i++, j--){
            if(board[i][j] == 1)
                return false;
        }

        return true;
    }


    public static boolean nQueens(int col, int[][] board){
        //if we go out of range of cols, we have exhausted and found sol
        if(col >= board.length){
            print(board);
            return true;
        }

        boolean is_valid = false;

        for(int i = 0; i < board.length; i++){

            if(is_safe(i, col, board)){
                board[i][col] = 1;
                if(nQueens(col + 1, board)){
                    is_valid = true;
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return is_valid;
    }
}
