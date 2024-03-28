import java.util.ArrayList;
import java.util.List;
import Arrays.PrefixSum.*;
public class Tester {

    public static void main(String[] args) { 

        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(2);
        list1.add(-3);
        list1.add(1);
        list1.add(6);

        list1 = IndicesWith0Sum.solve(list1);
        for(int num : list1)
            System.out.print(num + " ");
    }
}
