/*
 * 
 * 1334. Find City With Smallest Number Of Neighbours at Threshold
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * 
 * 
 * eighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.

Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold,
 If there are multiple such cities, return the city with the greatest number.

Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

 

Example 1:


Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
Output: 3
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -> [City 1, City 2] 
City 1 -> [City 0, City 2, City 3] 
City 2 -> [City 0, City 1, City 3] 
City 3 -> [City 1, City 2] 
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
Example 2:


Input: n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
Output: 0
Explanation: The figure above describes the graph. 
The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -> [City 1] 
City 1 -> [City 0, City 4] 
City 2 -> [City 3, City 4] 
City 3 -> [City 2, City 4]
City 4 -> [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.
 

Constraints:

2 <= n <= 100
1 <= edges.length <= n * (n - 1) / 2
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti, distanceThreshold <= 10^4
All pairs (fromi, toi) are distinct.
 * 
 */
package Graphs;
import java.util.*;
class Edge implements Comparable<Edge>{
    int dest;
    int weight;

    public Edge(int d, int w){
        this.dest = d;
        this.weight = w;
    }

    @Override
    public int compareTo(Edge other){
        return Integer.compare(this.weight, other.weight);
    }
}

public class CityWithSmallestNeighbours {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0 ; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge: edges){
            Edge e = new Edge(edge[1], edge[2]);
            Edge e1 = new Edge(edge[0], edge[2]);
            graph.get(edge[0]).add(e);
            graph.get(edge[1]).add(e1);
        }

        int max = -1;
        int cur = -1;

        for(int i = 0 ; i < n ; i++){
            int val = shortestPath(i, graph, distanceThreshold);
            if( val < max){
                max = Math.min(max,val );
                cur = i;
            }
        }
        return cur;
    }

    public int shortestPath(int src, List<List<Edge>> graph, int t){
        List<Integer> ans = new ArrayList<>();
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(src, 0));
        boolean[] visited = new boolean[graph.size()];
        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            if(visited[u])
                continue;
            visited[u] = true;

            for(Edge e: graph.get(u)){
                int v = e.dest;
                int w = e.weight;

                if(!visited[v] && w + dist[src] > t)
                    continue;
                
                if(!visited[v] && dist[src] + w < dist[v]){
                    ans.add(v);
                    dist[v] = dist[u] + w;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }
        return ans.size();
    }
}
