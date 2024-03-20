//In the lively town of Main Street, two HeyCoach students, Ram and Shyam, embarked on an intriguing challenge
//Tasked by their mentor, they ventured onto a straight road lined with an even number of buildings
//Each building held a stash of gold coins, but here's the twist – certain buildings were occupied by cunning thieves
//who could pilfer coins from their pockets.
//Ram kicked off the adventure from the 0th building, while Shyam began at the (n-1)th building,
//both determined to maximize their gold haul. Guided by their mentor's strategy, they aimed to visit n/2 buildings,
//ensuring they'd eventually meet in the middle.
//
//You have to return an array of size `n/2` where ith index would denote who has the maximum number
// of coins collected at ith time.
//
//1 if Ram has maximum coins, -1 if Shyam has maximum coins, 0 if both have same number of coins.
//
//Example 1
//Input: [1,2,-1,4,-1,1]
//Output: [0,1,-1]
//
//Example 2
//Input: [1,-1]
//Output:  [1]


import java.util.ArrayList;

public class MaximiseCoin {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> maxWinner(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        int i = 0;
        int j = arrayList.size() - 1;
        while (i <= j) {
            if (arrayList.get(i) > arrayList.get(j))
                arrayList1.add(1);
            else if (arrayList.get(i) < arrayList.get(j)) {
                arrayList1.add(-1);
            } else
                arrayList1.add(0);
        }
        return arrayList1;
    }
}
