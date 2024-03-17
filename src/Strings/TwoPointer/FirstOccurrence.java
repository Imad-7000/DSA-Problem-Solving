/*
 * 28. Index of First Occurrence in String 
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * 
 */


package Strings.TwoPointer;

public class FirstOccurrence {


    public static int firstOcc(String haystack, String needle){

        if(needle.length() > haystack.length())
            return -1;
        int i = 0;
        while( i < haystack.length()){
            int j = 0;
            int k = i;
            while(j < needle.length() && k < haystack.length()){
                if(needle.charAt(j) == haystack.charAt(k)){
                    k++;
                    j++;
                }
                else{
                    break;
                }
            }

            if(j == needle.length())
                return k - j;
            i++;

        }
        return -1;
    }
}
