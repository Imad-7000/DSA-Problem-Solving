import java.util.ArrayList;
import java.util.List;
import Stacks.*;
import Stacks.NextGreater.SmallerElement.NextGreaterElement;
public class Tester {

    public static void main(String[] args) { 
        List<Integer> students = new ArrayList<>();
        students.add(1);
        students.add(1);
        students.add(1);
        students.add(0);
        students.add(0);
        students.add(1);

        List<Integer> sandwich = new ArrayList<>();
        sandwich.add(1);
        sandwich.add(0);
        sandwich.add(0);
        sandwich.add(0);
        sandwich.add(1);
        sandwich.add(1);

        String infix = "3+4*5+(2+3)/5";
        //System.out.println(EvaluateExpression.evaluate(infix));


        int[] arr = new int[]{1,3,2,0,0,1,4, 10, 9};
        arr = NextGreaterElement.nextGreater(arr);
        for(int num: arr)
            System.err.print(num + " ");

    }
}
