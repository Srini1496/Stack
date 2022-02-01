/*
1124. Longest Well-Performing Interval
Medium

870

92

Add to List

Share
We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.

 

Example 1:

Input: hours = [9,9,6,0,6,6,9]
Output: 3
Explanation: The longest well-performing interval is [9,9,6].
Example 2:

Input: hours = [6,6,6]
Output: 0
 

Constraints:

1 <= hours.length <= 104
0 <= hours[i] <= 16
*/
class Solution {
	public int longestWPI(int[] hours) {
		int res = 0;
		int curr = 0;
        int n=hours.length;
        Map<Integer,Integer> map=new HashMap<>();
		for(int i = 0 ; i<n;i++){
            if(hours[i]>8)
                curr++;
            else
                curr--;
            if(curr>0)
                res=Math.max(res,i+1);
            else{
                if(map.containsKey(curr)){
                    if(hours[map.get(curr)]>8)
                        res=Math.max(res,i-map.get(curr)+1);
                    else{
                        res=Math.max(res,i-map.get(curr)-1);
                         map.put(curr,i);
                    }
                        
                }else{
                    map.put(curr,i);
                }
            }
			
		}
		return res;
	}
}
