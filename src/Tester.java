import Recursion.Backtracking.*;
public class Tester {

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        boolean val =  NQueens.nQueens(0, board); 
        System.out.println(val);
    }
}
