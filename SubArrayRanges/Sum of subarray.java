/*
2104. Sum of Subarray Ranges
Medium

344

12

Add to List

Share
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
*/
class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        Stack<Integer> prev = new Stack<Integer>();
        Stack<Integer> next = new Stack<Integer>();
        long[] leftMin=new long[n];
        long[] rightMin = new long[n];
        long[] leftMax=new long[n];
        long[] rightMax = new long[n];
        //prevMin
        for(int i=0;i<n;i++){
            while(!prev.isEmpty() && nums[prev.peek()]>nums[i])
                prev.pop();
            leftMin[i]=prev.isEmpty()?i+1:i-prev.peek();
            prev.push(i);
        }
        prev.clear();
        //rightMin
        for(int i=n-1;i>=0;i--){
            while(!next.isEmpty() && nums[next.peek()]>=nums[i])
                next.pop();
            rightMin[i]=next.isEmpty()?n-i:next.peek()-i;
            next.push(i);
        }
        next.clear();
        //leftMax
        for(int i=0;i<n;i++){
            while(!prev.isEmpty() && nums[prev.peek()]<nums[i])
                prev.pop();
            leftMax[i]=prev.isEmpty()?i+1:i-prev.peek();
            prev.push(i);
        }
        prev.clear();
        //rightMax
        for(int i=n-1;i>=0;i--){
            while(!next.isEmpty() && nums[next.peek()]<=nums[i])
                next.pop();
            rightMax[i]=next.isEmpty()?n-i:next.peek()-i;
            next.push(i);
        }
        
        long ans=0;
        for(int i=0;i<n;i++){
            ans=ans+(nums[i]*(leftMax[i]*rightMax[i] - leftMin[i]*rightMin[i]));
        }
        return ans;
    }
}
