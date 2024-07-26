/*
 * 
 * 
 * Row Wars
A learner at heycoach goes to a parallel world by some magic, upon reaching there he saw that a war is going on between two nations, 
the soldiers are protecting the civilians, as he was one of the civilian there he saw that soldiers had create a grid like structure 
formation in which there are m rows and n columns and in which the soldiers are represented by 1 and civilians are represented by 0,
 all the soldiers are on left of civilians your task is to find out k weakest rows indexes out of those m rows. A row i is weaker than a row j if one of the following is true:

1). The number of soldiers in row i is less than the number of soldiers in row j.

2). Both rows have the same number of soldiers and i < j.

Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
Example 1

Input :  

matrix =    
[[1,1,0,0,0],  
 [1,1,1,1,0],  
 [1,0,0,0,0],  
 [1,1,0,0,0],  
 [1,1,1,1,1]],   

 k = 3

Output : [2,0,3]
Constraints

2 <= n, m <= 100 , elements of the matrix are either 0 or 1
 */
package General;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RowWars {
    public List<Integer> kWeakestRows(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<int[]> rows = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            int soldierCount = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    soldierCount++;
                }
            }
            rows.add(new int[] {i, soldierCount});
        }
        
        rows.sort((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(rows.get(i)[0]);
        }
        
        return result;
    }
}
