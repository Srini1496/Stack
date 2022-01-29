/*
1081. Smallest Subsequence of Distinct Characters
Medium

1353

136

Add to List

Share
Given a string s, return the lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/
class Solution {
    public String smallestSubsequence(String s) {
        boolean[] visited=new boolean[26];
        int[] lastIndex=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++)
            lastIndex[s.charAt(i)-'a']=i;
        Stack<Character> st=new Stack<Character>();
        st.push(s.charAt(0));
        visited[s.charAt(0)-'a']=true;
        for(int i=1;i<n;i++){
            if(!visited[s.charAt(i)-'a']){
                    while(!st.isEmpty() && st.peek()>s.charAt(i) && lastIndex[st.peek()-'a']>i)
                        visited[st.pop()-'a']=false;
                   
                    st.push(s.charAt(i));
                    visited[s.charAt(i)-'a']=true;              
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}
