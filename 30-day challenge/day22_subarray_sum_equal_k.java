// Leetcode 30-day day 22
// Description from leetcode
/* Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].*/

// just solution method
public class day22_subarray_sum_equal_k
{
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> allSums = new HashMap<>();
        int running = 0; // current sum of the array
        int subarrays = 0;
        int i = 0; // index of array
        
        while(i < nums.length)
        {
            running += nums[i]; // adding sum of array for each iteration
            
            if (running == k) // is running is equal to k, obviously a subarray
                subarrays++;
            
            // finding running-k in the hash means that there was a previous subarray
            // with sum of k, so add the numbers found
            if (allSums.containsKey(running - k)) 
                subarrays += allSums.get(running - k);
            
            Integer counts = allSums.get(running);
            if(counts == null) // doesn't exist in hash yet
                allSums.put(running, 1);
            else
                allSums.put(running, counts + 1); // update value in hash
            i++;
        }
        return subarrays;
    }
}