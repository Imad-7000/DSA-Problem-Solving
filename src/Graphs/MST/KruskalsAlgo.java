/*

    1584. Minimum cost to Connect all Points
        https://leetcode.com/problems/min-cost-to-connect-all-points/description/

 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
 * 
 * 
 * 
 * Notes: We use the concept of Union find and Kruskal's algorithm to create a minimum spanning tree.
 *        
 * Implement Kruskals Algorithm 
 * 
 */
package Graphs.MST;
import java.util.*;

class Edge{
    public int src;
    public int dest;
    public int val;

    public Edge(int src, int des, int val){
        this.src = src;
        this.dest = des;
        this.val = val;
    }
}

public class KruskalsAlgo {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();

        for(int i = 0 ; i < points.length; i++){
            int[] a1 = points[i];
            for(int j = i + 1; j < points.length; j++){
                int[] a2 = points[j];
                int val = Math.abs(a2[0] - a1[0]) + Math.abs(a2[1] - a1[1]);
                Edge temp = new Edge(i, j, val);
                edges.add(temp);
            }
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e1.val,e2.val);  
            }
        });

        int[] parent = new int[points.length];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        
        int count = 0;
        int i = 0;
        int finalAns = 0;
        while (count < points.length - 1) {
            Edge e = edges.get(i);
            int src_parent = root(e.src, parent);
            int des_parent = root(e.dest, parent);

            if(src_parent != des_parent){
                finalAns += e.val;
                parent[src_parent] = des_parent;
                count++;
            }

            i++;
        }

        return finalAns;
    }

    public int root(int node, int[] parent){
        while(parent[node] != node)
            node = parent[node];
        return node;
    }
}
