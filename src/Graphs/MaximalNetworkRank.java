/*
 * 1615. Maximal network Rank
 * https://leetcode.com/problems/maximal-network-rank/description/
 * 
 * There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

 

Example 1:



Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
Output: 4
Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
Example 2:



Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
Output: 5
Explanation: There are 5 roads that are connected to cities 1 or 2.
Example 3:

Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
Output: 5
Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.
 

Constraints:

2 <= n <= 100
0 <= roads.length <= n * (n - 1) / 2
roads[i].length == 2
0 <= ai, bi <= n-1
ai != bi
Each pair of cities has at most one road connecting them.
 * 
 */
package Graphs;
import java.util.*;
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> connections = new HashMap<>();
    
        for(int i = 0 ; i < roads.length; i++){

            if(connections.containsKey(roads[i][0])){
                connections.get(roads[i][0]).add(roads[i][1]);
            }

            else if (!connections.containsKey(roads[i][0])){
               HashSet<Integer> hash = new HashSet<>();
               hash.add(roads[i][1]);
               connections.put(roads[i][0], hash);
            }

            if(connections.containsKey(roads[i][1])){
                connections.get(roads[i][1]).add(roads[i][0]);
            }

            else if (!connections.containsKey(roads[i][1])){
               HashSet<Integer> hash = new HashSet<>();
               hash.add(roads[i][0]);
               connections.put(roads[i][1], hash);
            }
        }
        int max = 0;
        for(int i = 0; i < n ;i++){
            int node1 = i;
            if(!connections.containsKey(node1))
                continue;
            for(int j = i + 1; j < n; j++){
                int node2 = j;
                if(!connections.containsKey(node2))
                    continue;
                int sum = connections.get(node1).size() + connections.get(node2).size();
                if(connections.get(node1).contains(node2))
                    sum -=1;

                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
