/*
856. Score of Parentheses
Medium

2914

85

Add to List

Share
Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 

Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
*/
class Solution {
    public int scoreOfParentheses(String s) {       
        Stack<Integer> answer=new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch=='(')
                answer.push(0);
            else{
                if(answer.peek()==0){
                    answer.pop();
                    answer.push(1);
                }                    
                else{
                    int temp=0;
                    while(answer.peek()!=0){
                        temp+=answer.pop();
                    }
                    answer.pop();
                    answer.push(2*temp);
                }
            }
        }
        int ans=0;
        while(!answer.isEmpty())
            ans+=answer.pop();
        return ans;
    }
}
