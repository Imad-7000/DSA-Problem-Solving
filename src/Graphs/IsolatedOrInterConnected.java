/*
 * 
 * 
 * 
 * 
 * Isolated or Interconnected
You've landed on a mysterious island inhabited by two distinct tribes, cloaked in secrecy and suspicion.
 Each tribe occupies a hidden village within the island's lush jungle, connected by ancient trails (represented by the graph array). 
 Your mission? Determine if any path exists between the two villages, revealing whether the tribes are truly separate or secretly intertwined.

You're given an array graph, where each element graph[u] represents the villages neighbouring village u. Imagine these as hidden pathways through the jungle.
The island possesses these unique characteristics:
No village resides alone (every graph[u] has at least one element).
No loop exists within a village (a village cannot have a path back to itself).
Two villages are truly separate if no hidden path connects them (graph is not connected).
Your mission is to identify if the two tribes live in complete isolation (the graph is not bipartite) or if, somewhere within the jungle,
 a hidden path unites them (the graph is bipartite). Remember, uncovering this secret connection paves the way for peaceful interaction and 
 understanding between the tribes.

Input/Output Format:
Input:
A nested array graph representing the village connections (each element graph[u] contains integers representing connected villages). i.e. 
the graph is in the form of an adjacency list.

Output:
A boolean value indicates whether the two tribes are fully isolated (False) or interconnected (True).

Examples:
Input:
[[0,1],[0,2],[1,2]] (Island map with separate villages)

Output:
False (No path connects the villagers, making the tribes remain divided.)

Input:
[[0,1],[1,2]] (Another island map with a hidden connection)

Output:
True (A hidden path exists between villages 1 and 2, hinting at a potential connection between the tribes.)

Constraints:
1 <= n (number of villages on the island) <= 100
Each element graph[u] has at least one value but less than n values.
graph[u] does not contain u (villages have no loop paths).
If v is in graph[u], then u is in graph[v] (graph is undirected).

TODO
 */
package Graphs;

public class IsolatedOrInterConnected {

}
