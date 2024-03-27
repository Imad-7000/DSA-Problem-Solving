/*
 * Only K Strings
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. 
Each of the words consists of only uppercase and lowercase English letters (no punctuation).

For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​ such that it contains only the first k​​​​​​ words. Return s​​​​​​ after truncating it.

Input Format:

First line takes a string 's' as input which represents the sentence which is to be truncated.

Second line takes an integer 'k' as input which denotes the the first k​​​​​​ words that are to be truncated from s.

Output format:

Return s​​​​​​ after truncating it.

Example 1
Input
 s = "Hello how are you Contestant", k = 4
Output
"Hello how are you"
Explanation -
The words in s are ["Hello", "how" "are", "you", "Contestant"]. The first 4 words are ["Hello", "how", "are", "you"]. Hence, you should return "Hello how are you".

Example 2
Input
 s = "What is the solution to this problem", k = 4
Output
"What is the solution"
 */

package HeyCoach.SessionTest.LevelTest;

public class OnlyKStrings {

    public String onlyKString(String s, int k){
        s = s.trim();
        String[] ans = s.split(" ");
        StringBuilder st = new StringBuilder();

        for(int i = 0 ; i < k; i++){
            st.append(ans[i]);
            st.append(" ");
        }
        return st.toString().trim();
    }
}
