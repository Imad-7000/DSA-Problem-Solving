/*
 * 
 * 
 * 
 * 
 * Fractional knapsack - GREEDY
 * 
 * 
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 Note: Unlike 0/1 knapsack, you are allowed to break the item.

Example 1
Input
N = 3, W = 50
values = [60,100,120]
weight = [10,20,30]
Output
240.00
Explanation:
Initial W = 50. take item 1 with weight 10 and value 60 so W is now 50 - 10 = 40. take item 2 with weight 20 and value 100 so W is now 40 - 20 = 20.
 Now, we cannot take item 3 completely so we will just take W = 20 amount of it and the value we will get out of it is 80 and W becomes 20 - 20 = 0. 
 so total value is 60 + 100 + 80 = 240. So,Total maximum value of item we can have is 240.00 from the given capacity of sack.

Example 2
Input
N = 2, W = 50
values = [60,100]
weight = [10,20]
Output
160.00
Explanation:
Total maximum value of item we can have is 160.00 from the given capacity of sack.

Constraints:
1 <= Items.length <= 10000
1 <= Items.value , Items.weight <= 100000
 */
package HeyCoach.SessionTest.LevelTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Item{
    int val;
    int weight;
    public Item(int val, int weight){
        this.val = val;
        this.weight = weight;
    }
}
public class FractionalKnapsack {
    public double fractionalKnapsack(int N, int W, List<Integer> values, List<Integer> weight) {
      //Write your code here 
        Item[] items = new Item[values.size()];
        for(int i = 0 ; i < values.size(); i++)
            items[i] = new Item(values.get(i), weight.get(i));
        Comp comp = new Comp();
        Arrays.sort(items, comp);
        int curWt = 0;
        double finalVal = 0;
        for(Item item : items){
            if(curWt + item.weight <= W){
                finalVal += item.val;
                curWt += item.weight;
            }
            else{
                int temp = W - curWt;
                finalVal += item.val * ((double)temp/(double)item.weight);
                break;
            }
        }
        return finalVal;
    }

}

class Comp implements Comparator<Item>{
    @Override
    public int compare(Item a,Item b){
        double val1 = a.val/a.weight;
        double val2 = b.val/b.weight;
        
        if(val1 < val2)
            return 1;
        else if (val1 > val2)
            return -1;
        else 
            return 0;
    }
}
