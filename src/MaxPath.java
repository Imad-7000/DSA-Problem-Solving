import java.util.ArrayList;
import java.util.List;



public class MaxPath {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,3,1,5};
        List<Integer> list = new ArrayList<>();
        for(int a : arr)
            list.add(a);
        System.out.println(maximum_path(list));
    }

    static int[] memo ;
    public static int maximum_path(List<Integer> node_values) {
    // Write your code here
        memo = new int[node_values.size() + 1];
        for(int i = 0 ; i < memo.length; i++)
            memo[i] = -1;
        int maxSum = maxPath(node_values, 0);
        return maxSum;
        
    }
    
    public static int maxPath(List<Integer> nodes, int i){
        if(i >= nodes.size())
            return 0;
        if(memo[i] != -1)
            return memo[i];
        int level = (int) (( -1 + Math.sqrt(1 + 8 * i))/ 2);
        int leftIdx = i + level + 1;
        int rightIdx = i + level + 2;
        int maxsum = Math.max(maxPath(nodes, leftIdx), maxPath(nodes, rightIdx));
        return memo[i] = nodes.get(i) + maxsum;
    }
}
