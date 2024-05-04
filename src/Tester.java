import Graphs.CRUD.CreateGraph;
import HeyCoach.SessionTest.LevelTest.Removeduplicates;
public class Tester {

    public static void main(String[] args) {
          String str = "bcabc";
          Removeduplicates removeduplicates = new Removeduplicates();
          System.out.println(removeduplicates.removeDuplicateLetters(str));

          CreateGraph createGraph = new CreateGraph(5, 4);
          createGraph.add_edge(2, 1);
          createGraph.add_edge(3, 4);
          createGraph.add_edge(2, 4);
          createGraph.add_edge(0, 4);
          System.out.println();
          System.out.println();

          createGraph.bfs(true);
      }
}
