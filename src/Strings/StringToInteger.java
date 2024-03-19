/*
8. String to Integer (atoi)
https://leetcode.com/problems/string-to-integer-atoi/description/

 */
package Strings;
public class StringToInteger {

    public static int myAtoi(String s){
            
         s = s.trim();
         if(s.length() == 0)
             return 0;
             int index = 0;
             boolean isNegative = false;
             String full = "";
             if (s.charAt(index) == '-') {
                 index++;
                 isNegative = true;
             }
             else if(s.charAt(index) == '+')
                 index++;
 
             for(int i = index; i < s.length(); i++){
                 if(Character.isDigit(s.charAt(i)))
                     full += s.charAt(i);
                 else break;
             }
 
             if(full == "")
                 return 0;
             double answer = Double.valueOf(full);
 
             if(isNegative)
                 answer = answer * (double) -1;
             
             if(answer < Math.pow(-2, 31))
                 answer = (double)Math.pow(-2, 31);
             else if (answer > Math.pow(2, 31) - 1)
                 answer = (double) Math.pow(2, 31) - 1;
             return (int) answer;
    }
}