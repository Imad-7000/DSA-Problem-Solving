/*
 * 
 * 207. Course Schedule'
 * https://leetcode.com/problems/course-schedule/description/
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.


INTUITION : DIRECTED GRAPH - Check for a cycle
 */
package Graphs;
import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i< numCourses;i++)
            graph.add(new ArrayList<>());
        for(int i = 0 ; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] visited = new boolean[graph.size()];
        boolean[] rec_stack = new boolean[graph.size()];

        for(int i = 0; i < graph.size(); i++){
            if(!visited[i]){
                if(has_cycle(graph, visited, rec_stack, i))
                    return false;
            }
        }
        return true;
    }

    public boolean has_cycle(List<List<Integer>> graph, boolean[] visited, boolean[] rec_stack, int src){
        visited[src] = true;
        rec_stack[src] = true;

        for(int v : graph.get(src)){
            if(!visited[v] && has_cycle(graph, visited, rec_stack, v))
                return true;
            else if(rec_stack[v])
                return true;
        }
        rec_stack[src] = false;
        return false;
    }
}
