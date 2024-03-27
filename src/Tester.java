import java.util.ArrayList;
import java.util.List;
import Stacks.*;
import Stacks.NextGreater.SmallerElement.NextGreaterElement;
import Stacks.NextGreater.SmallerElement.StockSpanner;
import Strings.SlidingWindow.*;
import HeyCoach.SessionTest.LevelTest.*;
public class Tester {

    public static void main(String[] args) { 
        List<Integer> dict = new ArrayList<>();
        dict.add(4);
        dict.add(3);
        dict.add(2);
        dict.add(1);
        dict.add(2);
        dict.add(1);

       // List<Integer> fin = HelpGovernor.findCurrency(dict);
       // for(int num : fin)
        //    System.out.println(num);

            int[] nums = {44, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = DuplicateElements.findDuplicates(nums);
        System.out.println("Duplicate elements: " + duplicates);

    }
}
