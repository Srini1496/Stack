/*
1209. Remove All Adjacent Duplicates in String II
Medium

2342

48

Add to List

Share
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.
*/
class Solution {
    public String removeDuplicates(String s, int k) {
        char[] ch= new char[s.length()];
        int[] count=new int[s.length()];
        int i=0;
        for(int j=0;j<s.length();j++){
            ch[i]=s.charAt(j);
            if(i>0){
                count[i]=ch[i]==ch[i-1]?1+count[i-1]:1;
                if(count[i]==k)
                    i-=k;
                
            }else{
                count[i]=1;
            }
            i++; 
        }
        return new String(ch,0,i);
    }
}
