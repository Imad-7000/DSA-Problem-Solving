package HashSet;
import java.util.ArrayList;
import java.util.HashSet;

public class XOR {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();


    }

    public static int solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        int count = 0;
        HashSet<Integer> hashSet = new HashSet<>(a);
        for (int num : b) {
            if (hashSet.contains(num))
                count++;
        }
        return count;
    }

}
