// Leetcode 30-day day 6
// Description from leetcode
/*Given an array of size n, find the majority element. The majority element is the element that appears more than (n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2*/

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> table = new HashMap<>();
        int n = nums.length;
        int major = nums[0];
        for (int i = 0; i < n; i++)
        {
            if (!table.containsKey(nums[i]))
                table.put(nums[i], 1);
            else if ((table.get(nums[i]) + 1) > (n/2))
            {
                major = nums[i];
                break;
            }
            else
                table.replace(nums[i], table.get(nums[i]) + 1);
        }
        
        return major;
    }
}

// leetcode fastest solutions - not mine
/*
class Solution {
    public int majorityElement(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return majorityElement(nums, 0);
    }
    private int majorityElement(int[] nums, int start){
        int count = 1;
        int num = nums[start];
        for(int i = start+1;i<nums.length;i++){
            if(num == nums[i]) count++;
            else count--;
            if(count == 0) return majorityElement(nums,i+1);
        }
        return num;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int leader=nums[0],leader_count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==leader) leader_count++;
            else{
                leader_count--;
                if(leader_count==0){
                    if(i<nums.length-1){
                        leader=nums[i+1];
                        leader_count=1;
                        i++;
                    }
                }
            }
        }
        return leader;
                   
    }
}
*/