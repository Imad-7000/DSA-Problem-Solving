import java.util.ArrayList;
import java.util.Collections;

public class SortRhymingWords {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("bad");
        list.add("mad");
        list.add("lad");
        list.add("Money");
        list.add("Honey");
        list.add("tar");
        list.add("car");


        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            list.set(i, new StringBuilder(word).reverse().toString());
        }

        Collections.sort(list, Collections.reverseOrder());

        for (String word : list)
            System.out.print(new StringBuilder(word).reverse().toString() + " ");
    }
}
