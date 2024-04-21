/*
 * 
 * 
 * Word Correction
Tuntun is very upset that many people on the Net mix uppercase and lowercase letters in one word.
 That's why he decided to invent an extension for his browser that would change the letter's register 
 in every word so that it either only consisted of lowercase letters or, vice versa, only of uppercase ones.
  At that as little as possible letters should be changed in the word. For example, the word HoUse must be replaced with house,
   and the word ViP — with VIP. If a word contains an equal number of uppercase and lowercase letters,
    you should replace all the letters with lowercase ones. For example, maTRIx should be replaced by matrix.
     Your task is to use the given method on one given word.

Input Format
The first line contains a word s — it consists of uppercase and lowercase Latin letters and possesses the length from 1 to 100.
Ouput Format
Print the corrected word s. If the given word s has strictly more uppercase letters, make the word written in the uppercase register, otherwise -
 in the lowercase one.
Sample Input
HoUse
Sample Output
house
Explanation
In this example, the word "HoUse" contains 2 uppercase letters ('H', 'U') and 3 lowercase letters ('o', 's', 'e'). Therefore, the output is "house".
Constraints
- The length of the word 's' is between 1 and 100 (1 ≤ |s| ≤ 100).
- The word 's' consists of uppercase and lowercase Latin letters.
 */

package HeyCoach.SessionTest.LevelTest;

public class WordCorrection {
    public String wordCorrection(String str) {
        //Write your code here 
        int countUpper = 0;
        int countLower = 0;

        for(int i = 0 ; i < str.length(); i++){
            if(Character.isLowerCase(str.charAt(i)))
                countLower++;
            else
                countUpper++;
        }

        if(countUpper > countLower)
            return str.toUpperCase();
        return str.toLowerCase();

  
    }
}
