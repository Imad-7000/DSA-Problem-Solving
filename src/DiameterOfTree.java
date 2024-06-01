import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DiameterOfTree {
      static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
    
    
    public static int findMinimumDiameter(int n, int k, List<List<Integer>> edges) {
       List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        //-utlising graph concepts
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int minAns = Integer.MAX_VALUE;
        for (int root = 1; root <= n; root++) {
            int kc = k;
            Stack<Integer> bfsStack = new Stack<>();
            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.add(root);
            boolean[] visited = new boolean[n + 1];
            while (!bfsQueue.isEmpty()) {
                int currentNode = bfsQueue.poll();
                bfsStack.push(currentNode);
                visited[currentNode] = true;
                for (int i : tree.get(currentNode)) {
                    if (!visited[i]) {
                        bfsQueue.add(i);
                    }
                }
            }
            visited = new boolean[n + 1];
            while (kc-- > 0) {
                int node = bfsStack.pop();
                visited[node] = true;
            }
            Pair<Integer, Integer> x = diameter(tree, root, visited);
            minAns = Math.min(minAns, x.first);
        }
        return minAns - 1;
        
    }
     private static Pair<Integer, Integer> diameter(List<List<Integer>> tree, int root, boolean[] visited) {
        visited[root] = true;
        int maxDia = 0;
        int max1 = 0;
        int max2 = 0;
        boolean isLeaf = true;
        for (int i : tree.get(root)) {
            if (!visited[i]) {
                isLeaf = false;
                Pair<Integer, Integer> x = diameter(tree, i, visited);
                maxDia = Math.max(maxDia, x.first);
                if (x.second + 1 >= max1) {
                    max2 = max1;
                    max1 = x.second + 1;
                } else if (x.second + 1 >= max2) {
                    max2 = x.second + 1;
                }
            }
        }
        if (isLeaf) {
            return new Pair<>(0, 0);
        } else {
            return new Pair<>(Math.max(maxDia, Math.max(max1, 2 + max2)), 1 + Math.max(max1, max2));
        }
    }

    public static void main(String[] args) {
      List<List<Integer>> edges  = new ArrayList<>();
      List<Integer> l = new ArrayList<>();
      l.add(1);
      l.add(2);
      edges.add(l);
      l = new ArrayList<>();
      l.add(1);
      l.add(3);
      edges.add(l);
      l = new ArrayList<>();
      l.add(2);
      l.add(4);
      edges.add(l);
      l = new ArrayList<>();
      l.add(2);
      l.add(5);
      edges.add(l);

      System.out.println(findMinimumDiameter(5, 2, edges));
    }
}
