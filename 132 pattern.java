/*
456. 132 Pattern
Medium

2990

168

Add to List

Share
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109
*/
class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;
        int[] minLeft=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            minLeft[i]=min;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(minLeft[i]==nums[i]){
                st.push(nums[i]);
                continue;
            }else{
                while(!st.isEmpty() && st.peek()<=minLeft[i])
                    st.pop();
                if(st.isEmpty()){
                    st.push(nums[i]);
                }else{
                    if(st.peek()<nums[i])
                        return true;
                    else
                        st.push(nums[i]);
                }
            }
                
        }
        return false;
            
    }
}
