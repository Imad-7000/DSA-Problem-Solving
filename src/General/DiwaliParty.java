/*
 * 
 * 
 * DIWALI PARTY
On the festival of Diwali, people decorate their houses with colorful lights. Rahul wants to decorate his house in a unique way.
 He has a string s representing the pattern of lights he wants to use. Each character in the string represents a lightbulb ('*') 
 or an empty space ('.'). Rahul wants to know the maximum number of consecutive lightbulbs he can use without violating the following rule:

There should be at least one empty space ('.') between every two already present consecutive lightbulbs, meaning that let's say you were given

(* ... '*) these stars are already present and thus there needs to be atleast one space between them. So the largest sequence comes out to be
 (**** . *), remember that you have to check the condition add an empty space between the series of already present stars.

Write a function maxConsecutiveLights to help Rahul determine the maximum number of consecutive lightbulbs he can use in the given string. **

Example 1

Input

*.*.*

Output

1
Example 2

Input: 

*....*.*.....*

Output

5


Character 1: *

- currentConsecutive is reset to 0.
- maxConsecutive remains 0.

Character 2: .

- Increment currentConsecutive to 1.
- Update maxConsecutive to 1.

Character 3: .

- Increment currentConsecutive to 2.
- Update maxConsecutive to 2.

Character 4: .

- Increment currentConsecutive to 3.
- Update maxConsecutive to 3.

Character 5: .

- Increment currentConsecutive to 4.
- Update maxConsecutive to 4.

Character 6: *

- currentConsecutive is reset to 0.
- maxConsecutive remains 4.

Character 7: .

- Increment currentConsecutive to 1.
- maxConsecutive remains 4.

Character 8: *

- currentConsecutive is reset to 0.
- maxConsecutive remains 4.

Character 9: .

- Increment currentConsecutive to 1.
- maxConsecutive remains 4.

Character 10: .

- Increment currentConsecutive to 2.
- maxConsecutive remains 4.

Character 11: .

- Increment currentConsecutive to 3.
- maxConsecutive remains 4.

Character 12: .

- Increment currentConsecutive to 4.
- maxConsecutive remains 4.

Character 13: .

- Increment currentConsecutive to 5.
- Update maxConsecutive to 5 (since currentConsecutive > maxConsecutive).

Character 14: *

- currentConsecutive is reset to 0.
- maxConsecutive remains 5.


Final Output:

At the end of the string, the function finds that the longest sequence of consecutive spaces (.) is 5

Input Format

A single string s.
Output Format

An integer representing the maximum number of consecutive lightbulbs that can be used in the given string.
Constraints

1 <= |s| <= 10^4

s contains only '*' and '.' characters
 * 
 */
package General;

public class DiwaliParty {
    public int maxConsecutiveLights(String s) {
        int maxConsecutive = 0;
           int currentConsecutive = 0;
   
           for (char ch : s.toCharArray()) {
               if (ch == '*') {
                   currentConsecutive = 0;
               } else if (ch == '.') {
                   currentConsecutive++;
                   if (currentConsecutive > maxConsecutive) {
                       maxConsecutive = currentConsecutive;
                   }
               }
           }
   
           return maxConsecutive;
      }
}
