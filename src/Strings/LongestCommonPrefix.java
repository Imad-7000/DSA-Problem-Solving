/*
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */

package Strings;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
       String common = strs[0];

       for(int i = 1; i < strs.length; i++){
        common = findCommon(common, strs[i]);
       }
       return common;
    }

    public static String findCommon(String s1, String s2){
        String common = "";

        for(int i =0 ; i < Math.min(s1.length(), s2.length()) ; i++){
            if(s1.charAt(i) == s2.charAt(i))
                common += s1.charAt(i);
            else
                break;
        }
        return common;
    }
}
