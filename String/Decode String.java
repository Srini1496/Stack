/*
394. Decode String
Medium

7362

312

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<Integer>();
        Stack<StringBuilder> alpha=new Stack<StringBuilder>();
        int temp=0;
        alpha.push(new StringBuilder());
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                temp=temp*10+ch-'0';
            }else if(ch=='['){
                nums.push(temp);
                temp=0;
                alpha.push(new StringBuilder());
            }else if(ch==']'){
                int count=0;
                if(!nums.isEmpty())
                    count=nums.pop();
                String sb=alpha.pop().toString();
                while(count-->0)
                    alpha.peek().append(sb);               
                
            }else{
                alpha.peek().append(ch);
            }
        }
        return alpha.pop().toString();
    }
}
