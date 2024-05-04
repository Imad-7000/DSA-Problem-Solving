import Graphs.NumberOfProvinces;

public class Tester {

    public static void main(String[] args) {
        int[][] graph = new int[4][];
        graph[0] = new int[]{1,0,0,1};
        graph[1] = new int[]{0,1,1,0};
        graph[2] = new int[]{0,1,1,1};
        graph[3] = new int[]{1,0,1,1};

        NumberOfProvinces num = new NumberOfProvinces();

        System.out.println(num.findCircleNum(graph));

    }    

}
