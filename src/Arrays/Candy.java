/*
 * 135. Candy
 * https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 * 
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
 */
package Arrays;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i = 0 ; i< candies.length; i++){
            candies[i] = 1;
        }

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
            
            else{
                if(ratings[i] == ratings[i - 1]){
                    if(candies[i] < candies[i - 1])
                        continue;
                    else{
                        candies[i] = candies[i - 1] + 1;
                    }
                }
                else{
                    
                    int k = i - 1;
                    int j = i;
                    if(candies[j] >= candies[k]){
                        while(k >= 0 && ratings[k] > ratings[j] && candies[j] >= candies[k]){
                            candies[k] = candies[j] + 1;
                            k--;
                            j--;
                        }
                    }    
                }
            }
        }

        System.out.println("Ratings" + " : " + "candies");
        for(int i  = 0 ; i < candies.length; i++)
            System.out.println(ratings[i] + "    :     " + candies[i]);

        candy2(ratings);
        return Arrays.stream(candies).sum();
    }

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        System.out.println("Ratings" + " : " + "candies");
        for(int i  = 0 ; i < candies.length; i++)
            System.out.println(ratings[i] + "    :     " + candies[i]);
        return totalCandies;
    }
}
