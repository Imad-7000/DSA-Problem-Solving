/* Leetcode Problem 65
https://leetcode.com/problems/valid-number/
 */


package Strings.ValidateStrings;

public class ValidNumbers {


    public static boolean isNumber(String s){
        if(!Character.isDigit(s.charAt(0)) && 
            s.charAt(0) != '+' && s.charAt(0) != '-'
                && s.charAt(0) != '.')
                return false;
        
        boolean isPointFound = false;

        if(s.charAt(0) == '.')
            isPointFound = true;

        boolean isNumber = true;
        for(int i = 1; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
                continue;
            else if(s.charAt(i) == '.'){
                if(isPointFound)
                    return false;
                isPointFound = true;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                i++;
                if(i == s.length())
                    return false;
                if(s.charAt(i) == '+' || s.charAt(i) == '-')
                    {
                        i++;
                        if(i == s.length())
                            return false;
                        if(!Character.isDigit(s.charAt(i)))
                            return false;
                        else
                            continue;
                    }
            }
            else
                return false;
            
        }
        return isNumber;
    }
}
