import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DigitsvsSymbols {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("3");
        arrayList.add("2");
        arrayList.add("+");
        arrayList.add("4");
        arrayList.add("*");
        arrayList.add("-");
        arrayList.add("$");
        arrayList.add("5");

        sortCards(arrayList, arrayList.size());

        for (String card : arrayList)
            System.out.print(card + " ");
    }

    public static void sortCards(ArrayList<String> cards, int n) {
        Queue<String> queue = new ArrayDeque<>();

        int i = -1;
        int j = 0;

        while (j < cards.size()) {
            if (Character.isDigit(cards.get(j).charAt(0))) {
                i++;
                swap(cards, i, j);
            } else {
                queue.add(cards.get(j));
            }
            j++;
        }
        swap(cards, i + 1, cards.size() - 1);

        for (int k = i + 1; k < cards.size(); k++)
            cards.set(k, queue.poll());
    }

    public static void swap(ArrayList<String> cards, int i, int j) {
        String temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }
}
