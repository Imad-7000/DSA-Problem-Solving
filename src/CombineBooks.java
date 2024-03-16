import java.util.ArrayList;
import java.util.List;

public class CombineBooks {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("book");
        a.add("enchanted");
        a.add("spell");
        a.add("wand");

        List<String> b = new ArrayList<>();
        b.add("ancient");
        b.add("dragon");
        b.add("magic");
        b.add("scroll");

        List<String> fL = solve(a, b);

        for (String str : fL)
            System.out.print(str + " ");
    }

    public static List<String> solve(List<String> a, List<String> b) {
        List<String> finalList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).compareTo(b.get(j)) < 0) {
                finalList.add(a.get(i));
                i++;
            } else {
                finalList.add(b.get(j));
                j++;
            }
        }

        while (i <= a.size() - 1) {
            finalList.add(a.get(i));
            i++;
        }
        while (j <= b.size() - 1) {
            finalList.add(b.get(j));
            j++;
        }

        return finalList;
    }
}
