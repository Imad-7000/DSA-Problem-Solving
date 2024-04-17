/*
 * 
 * 
 * Help the governor
RBI wants to introduce currency of new denominations,so for this, the Governor conducts a poll about the among N banks. 
Governor imposed a restriction on the denomination of the currency that is the denomination can be in the range of ==[1,N]==.
Votes of all the banks have been stored in the votes array and the RBI will release currency of only those denominations which have got more than 1 vote.
 So you have been provided with the votes array and you need to return the array which will contain the denominations of the currency which is 
 going to be released by the RBI sorted in increasing order. If no denominations got more than 1 vote then simply return an empty array.

Note: Can you wirte an algorithm that runs in O(N) Time complexity and O(1) space complexity if we exclude the space used by the answer array?

Example 1
Input
votes = [4,3,2,1,2,1]
Output
[1,2]
Explanation:
Currency of denominations 1 and 2 got more than 1 vote so they are going to be released by the RBI

Example 2
Input

votes = [3,4,3,1]
Output
[3]
Explanation:
only currency of denomination 3 got more than 1 vote.

Constraints:
1 <= n= 10000
1 <= votes[i] <= N
 */

package HeyCoach.SessionTest.LevelTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HelpGovernor {

    public static List<Integer> findCurrency(List<Integer> votes){
        Collections.sort(votes);
        List<Integer> finalList = new ArrayList<>();
        int count = 0;
        for(int i = 0; i <  votes.size() ; i++){
            for(int j = i + 1; j < votes.size(); j++){
                if(votes.get(i) == votes.get(j)){
                    count++;
                }
                else{
                    if(count > 0)
                        finalList.add(votes.get(i));
                    i = j - 1;
                    break;
                }
            }
            count = 0;
        }
        return finalList;
    }

    public static List<Integer> findCurrencyv2(List<Integer> votes){
        List<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i = 0; i < votes.size(); i++){
            hash.put(votes.get(i), hash.getOrDefault(votes.get(i), 0) + 1);
        }

        Iterator<Map.Entry<Integer,Integer>> itr = hash.entrySet().iterator(); 

        while (itr.hasNext()) {
            Map.Entry<Integer,Integer> entry = itr.next(); 
            if(entry.getValue() > 1)
                list.add(entry.getKey());
        }
        Collections.sort(list);
        return list;
    }
}
