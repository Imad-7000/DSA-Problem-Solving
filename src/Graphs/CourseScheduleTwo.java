/*
 * 210. course Schedule 2
 * https://leetcode.com/problems/course-schedule-ii/description/
 * 
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 *  You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, 
return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 * 
 * 
 * Intuition : Exact same code as cycle but just add in reverse order to list
 */
package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleTwo {
    List<Integer> list = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i< numCourses;i++)
            graph.add(new ArrayList<>());
        for(int i = 0 ; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] rec_stack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(has_cycle(graph, visited, rec_stack, i))
                    return new int[]{};
            }
        }
        int[] array =new int[numCourses];
        int j = 0;
        for(int i = list.size() - 1; i>= 0; i--)
            array[j++] = list.get(i);
        return array;
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
        list.add(src);
        rec_stack[src] = false;
        return false;
    }
}
