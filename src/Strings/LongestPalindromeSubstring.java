package Strings;

public class LongestPalindromeSubstring {

    public String longest(String s){
        return helper(s, 0, s.length() - 1);
    }

    public String helper(String s, int i, int j){
        String best = "";
        

        if(s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }




        return best;
    }
}
