/*
 * 
 * HeyCOACH
 * 
 * Tour of all Petrol Pump
Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.

The amount of petrol that every petrol pump has.
Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
 If no such path exists return -1.

Note : Assume for 1 liter petrol, the truck can go 1 unit of distance.

For example:

N = 4 (No. of petrol pumps), Petrol = 4 6 7 4, Distance = 6 5 3 5

Output: 1

Explanation: There are 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. 

The first point from where truck can make a circular tour is 2nd petrol pump. Output in this case is 1 (index of 2nd petrol pump).

Sample Input:

3

6 3 7

4 6 3

Sample Output:

2

Constraints:

2 ≤ N ≤ 10000

1 ≤ petrol, distance ≤ 1000
 */
package Arrays;

import java.util.*;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}
public class GasStation {
    public int solve(PetrolPump[] p, int n) {
        //Write your code here
        List<Integer> startPoints = new ArrayList<>(); 
        for(int i = 0 ; i < p.length; i++){
            if(p[i].petrol >= p[i].distance)
                startPoints.add(i);
        }
        
        for(int i = 0 ; i < startPoints.size(); i++){
            int count = 0;
            int j = startPoints.get(i);
            int petrolAvailable = 0;
            while(count < p.length){

                if(j >= p.length)
                    j =0;
                petrolAvailable += p[j].petrol;
                petrolAvailable = petrolAvailable - p[j].distance;
                if(petrolAvailable < 0)
                    break;
                count++;
                j++;
            }
            if(count == p.length)
                return startPoints.get(i);
        }
        return -1;
    }
}
