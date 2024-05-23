/*
 * 76. Minimum Window substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 * 
 * 
 * TODO
 */

package Strings;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
    
    public static String minimumWindowSubstring(String s, String t){
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            int count = hash.getOrDefault(t.charAt(i), 0) + 1;
            hash.put(t.charAt(i), count);
        }
        
        String mString = "";

        HashMap<Character, Integer> seen = new HashMap<>();
        int i = 0;
        int j = 0;

        while(j < s.length()){
            if(hash.containsKey(s.charAt(j))){

                int count = seen.getOrDefault(s.charAt(j), 0) + 1;
                seen.put(s.charAt(j), count);

                if(hash.equals(seen)){
                    if(mString == "")
                        mString = s.substring(i, j+1);
                    else{
                        if(s.substring(i, j + 1).length() < mString.length())
                            mString = s.substring(i,j+1);
                    }

                    while (seen.size() == hash.size()) {
                        if(seen.containsKey(s.charAt(i)) ){
                            if(seen.get(s.charAt(i)) - 1 != 0)
                                seen.put(s.charAt(i), seen.get(s.charAt(i)) - 1);
                            else
                                seen.remove(s.charAt(i));
                        }
                        if(s.substring(i, j + 1).length() < mString.length())
                         mString = s.substring(i,j+1);
                        i++;
                    }
                     while(!hash.containsKey(s.charAt(i)))
                         i++;
                }
            }
            j++;
        }
        return mString;
    }
}
