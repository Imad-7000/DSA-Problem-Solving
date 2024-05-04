import java.util.List;

import Graphs.CRUD.CreateGraph;
import HeyCoach.SessionTest.LevelTest.Removeduplicates;
public class Tester {

    public static void main(String[] args) {
        

          CreateGraph createGraph = new CreateGraph(7, 4);
          createGraph.add_edge(2, 1);
          createGraph.add_edge(3, 4);
          createGraph.add_edge(2, 4);
          createGraph.add_edge(0, 4);
          createGraph.add_edge(4, 5);
          System.out.println();
          System.out.println();

          if(createGraph.pathExists(0, 1)){
            System.out.println("DFS PROVIDED PATH : ");
            System.out.println();
            List<Integer> list = createGraph.findPath(0, 1);
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + "  ");
            }
            System.out.println();
            System.out.println("BFS PROVIDED PATH");
            System.out.println();
            List<Integer> list1 = createGraph.get_path_BFS(0, 1);
            for(int i = 0; i < list1.size(); i++){
                System.out.print(list1.get(i) + "  ");
            }
          }
          else{
            System.out.println("No Path!");
          }

      }
}
