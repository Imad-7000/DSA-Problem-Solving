
import java.util.ArrayList;
import java.util.List;

import Strings.SlidingWindow.*;
import Strings.TwoPointer.FindPatternIndices;
import SlidingWindow.*;
public class Tester {

    public static void main(String[] args) { 
        //System.out.println(LongestSubstringWithKUniqueCharacters.longestUniqueSubstring("aabacbebebe", 3));

      /// List<Integer> list = FindPatternIndices.findPatternIndices("aaabaaab", "aaab");

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(-1);
        list1.add(-7);
        list1.add(8);
        list1.add(-15);
        list1.add(30);
        list1.add(16);
        list1.add(28);

        FirstNegativeElement.printFirstNegativeInteger(list1, 3);
    }
}
