import Strings.*;
import SlidingWindow.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import HashSet.FirstUniqueCharacter;
import HeyCoach.SessionTest.*;
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

        System.out.println(Sandwiches.countStudents(students, sandwich));
        

    }
}
