import java.util.ArrayList;

//There are n food stations along a circular route, where the amount of food at the ith station is food[i].
// You have a body with an unlimited storage capacity for food, and it costs cost[i] of food to travel
// from the ith station to its next (i + 1)th station.
// You begin your journey with an empty stomach at one of the food stations.
// Given two integer arrays food and cost, return the starting food station's index if you can travel around
// the circuit once in the clockwise direction without running out of food, otherwise return -1.
// If there exists a solution, it is guaranteed to be unique.
//
//        Example 1:
//
//        Input: food = [1,2,3,4,5],  cost = [3,4,5,1,2]
//
//        Output : 3
//        Example 2:
//
//        Input :  food = [2,3,4],  cost = [3,4,3]
//
//        Output: -1
//
//Constraints:
//
//        n == food.length() == cost.length()
//
//        2 <= n <= 200000
//
//        0 <= food[i], cost[i] <= 10000
public class Foodie {
    public static void main(String[] args) {
        int[] food = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};

        System.out.println("Cost = " + circuit(food, cost));
    }

    public static int circuit(int[] food, int[] cost) {
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < food.length; i++) {
            if (food[i] > cost[i])
                al.add(i);
        }

        int i = 0;
        while (i < al.size()) {
            int j = al.get(i);
            boolean flag = true;
            int container = 0;
            container = food[j] - cost[j];
            j++;

            if (j == food.length)
                j = 0;
            while ((j != al.get(i))) {
                container = container + food[j];
                if (container - cost[j] >= 0) {
                    container -= cost[j];
                    j++;
                    if (j == food.length)
                        j = 0;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return al.get(i);
            i++;
        }

        return -1;
    }
}
