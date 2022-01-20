/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 

Follow up: Can you solve it in O(n) time and O(1) space?
*/

//O(n) and O(1) complexity
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        while(i>=0 && j>=0){
            
            if(s.charAt(i)=='#')
                i=findIndex(s,i);
            
            if(t.charAt(j)=='#')
                j=findIndex(t,j);
            if(i>=0 && j>=0 && s.charAt(i)==t.charAt(j)){
                i--;
                j--;
            }else if(i>=0 && j>=0)
                return false;                
        }
        
        i=findIndex(s,i);
        j=findIndex(t,j);
        
        if(i<0 && j<0)
            return true;
        
        return false;
    }
    
    public int findIndex(String str,int index){
        if(index<0)
            return index;
        int backspaceCount=0;
        for(int i=index;i>=0;i--){
            if(str.charAt(i)=='#'){
                backspaceCount++;
            }else if(backspaceCount>0){
                backspaceCount--;
            }else
                return i;
                
        }
        
        return -1;
    }
}
