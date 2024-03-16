import java.math.BigInteger;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GCDOfSmallest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);


        for (int num : arrayList)
            System.out.print(num + " ");

        System.out.println(GCDOfSmallest(arrayList));
    }


    public static int GCDOfSmallest(ArrayList<Integer> arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr);
        int i = 0;
        int cost = 0;
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.remove();
            int b = priorityQueue.remove();
            BigInteger b1 = new BigInteger(String.valueOf(a));
            BigInteger b2 = new BigInteger(String.valueOf(b));
            BigInteger gcdVal = b1.gcd(b2);
            cost += gcdVal.intValue();
            priorityQueue.add(a + b);
            i++;
        }
        return cost;
    }
}
