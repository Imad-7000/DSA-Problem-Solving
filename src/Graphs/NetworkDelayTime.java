/*
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/description/
 * 
 * 
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
 * where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
 If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
 * 
 */
package Graphs;
import java.util.*;
class Edge implements Comparable<Edge>{
    int d;
    int w;
    public Edge(int d, int w){
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o){
        return Integer.compare(this.w, o.w);
    }
}
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0 ; i <=n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time: times){
            Edge e = new Edge(time[1], time[2]);
            graph.get(time[0]).add(e);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[k]= 0;
        pq.add(new Edge(k, 0));
        while (!pq.isEmpty()) {
            int u = pq.poll().d;
            for(Edge e : graph.get(u)){
                int v = e.d;
                int wt = e.w;
                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }

        int min = -1;
        for(int i = 0; i < dist.length; i++){
            if(i == 0)
                continue;
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            min = Math.max(min, dist[i]);
        }
        return min;

    }
}   
