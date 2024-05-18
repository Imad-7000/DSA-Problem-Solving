/*
 * 
 * 1545. find the kth Bit in Nth Binary String 
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/
 * 
 * 
 * Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x)
 inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.

 

Example 1:

Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:

Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".
 

Constraints:

1 <= n <= 20
1 <= k <= 2n - 1

NOTES::

Observation 1: We can make some observations regarding length of the string as
Length of string Si = Math.pow(2, i) - 1
Length 0f S1 = 1 => 2 - 1
Length of S2 = 3 => 4 - 1
Length of S3 = 7 => 8 - 1

Observation2: Length of all the strings are odd numbers.

Observe S3 and S2
S2 = "011"
S3 = "0111001"
Split S3 nto 3 parts as per the given equations S2 + "1" + reverse(invert(S2))
If we were to find kth bit in S3 then we can limit our search by observing where the kth bit came from by using the equation.

length of S3 = 7
mid = length of S3 / 2 => 3
end = 2

Split the String S3 from indexes 1 to mid, mid + 1 and mid +2 to end => String from 1 to 3, String at 4 and String from 5 to 7.

In S3 first 3 characters(k=1,2,3) are same as the characters in S2

This means if we want to find a character among the first partition (1 to mid) the we can get it from the character
 at same index from the previous string(in this case S2).
Next character(k = 4) is the "1" added while generating the string S3

The remaining 3 characters(k = 5,6,7) are the inverse of reversed character of S2 i.e

5th character in S3 is inverse of 3rd character in S2
6th character in S3 in inverse of 2nd character in S2
7th character in S3 is inverser of 1st character in S2.
If we observe the numbers those sum up to 8 which is the length of String S3 + 1.

This means if we want to find a character among the last partition with index k then we can get the character by inverting the character 
at index length + 1 - k in the prevous string(in this case S2).

The same observations can be made for strings S4, S3 and S2, S1. By using these repeated patterns we can solve the problem.
 */
package Recursion;

public class ReverseInvert {
    public char findKthBit(int n, int k) {
        if(n==1 && k==1) return '0';
       int length = (int)Math.pow(2,n) - 1;
       int mid = length / 2;
       if(k <= mid) return findKthBit(n-1, k);
       else if(k > mid + 1) return invert(findKthBit(n-1, length + 1 - k));
       else return '1';
   }
public char invert(char c) {
       if(c == '0') return '1';
       else return '0';
   }
}   
