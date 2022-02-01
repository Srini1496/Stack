/*
402. Remove K Digits
Medium

4355

182

Add to List

Share
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
*/
class Solution {
    public String removeKdigits(String num, int k) {
        int a='9'-'0';
        int[] lastIndex=new int[10];
        int n=num.length();
        for(int i=0;i<n;i++){
            lastIndex[num.charAt(i)-'0']=i;
        }
        int len=n-k;
        if(len==0)
            return "0";
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty () && (st.peek()-'0') > (num.charAt(i)-'0') && k>0){
                k--;
                st.pop();
            }
           st.push(num.charAt(i));
        }
        while(k-->0)
            st.pop();
        StringBuilder sb=new StringBuilder();
        
        while(!st.isEmpty())
            sb.append(st.pop());
        String ans=sb.reverse().toString();
        int i=0;
        for(;i<ans.length();i++){
            if(ans.charAt(i)!='0')
                break;
        }
        if(i==ans.length())
            return "0";
        ans=ans.substring(i,ans.length());
        return ans;
    }
}
