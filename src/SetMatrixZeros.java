/*
 * 
 * 
 * 
 * 
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

import java.util.*;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{0,1,2,0};
        matrix[1] = new int[]{3,4,5,2};
        matrix[2] = new int[]{1,3,1,5};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        List<List<Integer>> zeroPos = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0 ; j < matrix.length; j++){
                if(matrix[i][j] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    zeroPos.add(temp);
                }
            }
        }
        System.out.println(zeroPos.size());
        for(int i = 0 ; i < zeroPos.size(); i++){
            makeZeros(matrix, zeroPos.get(i).get(0), zeroPos.get(i).get(1));
        }
    }

    public static void makeZeros(int[][] matrix, int i, int j){
        int t = i + 1;
        while(t < matrix.length){
            matrix[t][j] = 0;
            t++;
        }
        t = i -1;
        while (t >= 0) {
            matrix[t][j] = 0;
            t--;
        }
        t = j + 1;
        while (t< matrix[0].length) {
            matrix[i][t] = 0;
            t++;
        }
        t = j - 1;
        while (t>= 0) {
            matrix[i][t] = 0;
            t--;
        }
    }
}   
