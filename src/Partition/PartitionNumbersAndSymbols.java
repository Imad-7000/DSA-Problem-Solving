import java.util.ArrayList;

public class PartitionNumbersAndSymbols {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("6");
        arrayList.add("+");
        arrayList.add("-");
        arrayList.add("/");
        arrayList.add("5");

        partitionDigits(arrayList, arrayList.size());
    }

    public static void partitionDigits(ArrayList<String> arrayList, int n) {
        int i = -1;
        int j = 0;

        while (j < n) {
            if (Character.isDigit(arrayList.get(j).charAt(0))) {
                i++;
                swap(arrayList, i, j);

            }
            j++;
        }
        swap(arrayList, i + 1, n - 1);

        for (int k = 0; k < arrayList.size(); k++)
            System.out.print(arrayList.get(k) + " ");
    }

    public static void swap(ArrayList<String> arrayList, int i, int j) {
        String temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }
}
