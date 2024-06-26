/*
 * 2209. Minimum white tiles after covering carpets
 * https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/description/
 * 
 * 
 * You are given a 0-indexed binary string floor, which represents the colors of tiles on a floor:

floor[i] = '0' denotes that the ith tile of the floor is colored black.
On the other hand, floor[i] = '1' denotes that the ith tile of the floor is colored white.
You are also given numCarpets and carpetLen. You have numCarpets black carpets, each of length carpetLen tiles. 
Cover the tiles with the given carpets such that the number of white tiles still visible is minimum. Carpets may overlap one another.

Return the minimum number of white tiles still visible.

 

Example 1:


Input: floor = "10110101", numCarpets = 2, carpetLen = 2
Output: 2
Explanation: 
The figure above shows one way of covering the tiles with the carpets such that only 2 white tiles are visible.
No other way of covering the tiles with the carpets can leave less than 2 white tiles visible.
Example 2:


Input: floor = "11111", numCarpets = 2, carpetLen = 3
Output: 0
Explanation: 
The figure above shows one way of covering the tiles with the carpets such that no white tiles are visible.
Note that the carpets are able to overlap one another.
 

Constraints:

1 <= carpetLen <= floor.length <= 1000
floor[i] is either '0' or '1'.
1 <= numCarpets <= 1000
 */
package Recursion.DP;

public class MinWhiteTiles {
    int[][] memo;
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        memo = new int[numCarpets + 1][floor.length() + 1];
        for(int i = 0 ; i < memo.length; i++){
            for(int j = 0; j < memo[i].length; j++){
                memo[i][j] = -1;
            }
        }
        return min(floor, numCarpets, carpetLen,0);
    }

    public int min(String floor, int numCarpets, int carpetLen, int i){
        if(i >= floor.length())
            return 0;
        if(memo[numCarpets][i] != -1)
            return memo[numCarpets][i];
        if(numCarpets == 0){
            int white = 0;
            for(int j = i; j < floor.length(); j++){
                if(floor.charAt(j) == '1')
                    white++;
            }
            memo[numCarpets][i] = white;
            return  memo[numCarpets][i];
        }
        else{
            if(floor.charAt(i) == '0')
                return memo[numCarpets][i] = min(floor, numCarpets, carpetLen, i + 1);
            
            int skip = 1 + min(floor, numCarpets, carpetLen, i + 1);
            int pick = min(floor, numCarpets - 1, carpetLen, i+ carpetLen);

            return memo[numCarpets][i] = Math.min(skip,pick);
        }

    }
}
