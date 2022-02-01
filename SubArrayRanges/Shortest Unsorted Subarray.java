/*
907. Sum of Subarray Minimums
Medium

3019

187

Add to List

Share
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
*/
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long[] left=new long[n];
        long[] right=new long[n];
        Stack<int[]> prev= new Stack<int[]>();
        Stack<int[]> nle= new Stack<int[]>();
        //Previous
        for(int i=0;i<n;i++){
            while(!prev.isEmpty() && prev.peek()[0]>=arr[i])
                prev.pop();
            left[i]=prev.isEmpty()?i+1:i-prev.peek()[1];
            prev.push(new int[]{arr[i],i});
        }
        //Next Less
        for(int i=n-1;i>=0;i--){
            while(!nle.isEmpty() && nle.peek()[0]>arr[i])
                nle.pop();
            right[i]=nle.isEmpty()?n-i:nle.peek()[1]-i;
            nle.push(new int[]{arr[i],i});
        }
        
        long MOD = (long) 1e9 + 7;
        long ans = 0;
        for(int i=0;i<n;i++){
            ans=(ans+(arr[i]*left[i]*right[i]))%MOD;
        }
        return (int)ans;
    }
}
