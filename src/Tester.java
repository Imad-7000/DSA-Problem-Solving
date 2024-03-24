import java.util.ArrayList;
import java.util.List;
import Stacks.*;
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
        System.out.println(EvaluateExpression.evaluate(infix));

    }
}
