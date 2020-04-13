// Leetcode 30-day day 12
// Description from leetcode
//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

// 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class day13_contiguous_array
{
	public static void main(String[] args)
	{
		int[] stones = new int[] {0,0,1,0,0,0,1,1}; // given test array -> output is 6
        day13_contiguous_array d = new day13_contiguous_array();

		System.out.println(d.findMaxLength(stones));

        return;
	}

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> HashTable = new HashMap<Integer, Integer>(); 
  
        int sum = 0;     // Initialize sum of elements 
        int max_len = 0; // Initialize result 
        int length = nums.length;
  
        for (int i = 0; i < length; i++)  
            nums[i] = (nums[i] == 0) ? -1 : 1; 
   
        for (int i = 0; i < length; i++)  
        {  
            sum += nums[i]; 
            
            // To handle sum=0 at last index 
            if (sum == 0) 
                max_len = i + 1; 
  
            // If this sum is seen before, then update max_len if better
            // by subtracting current positon by last seen position,
            // gives us number of items in substring
            if (HashTable.containsKey(sum + length))  
            {
                if (max_len < i - HashTable.get(sum + length)) 
                    max_len = i - HashTable.get(sum + length); 
            }
            else // Else put this sum in hash table 
            {
                HashTable.put(sum + length, i); //total number of 1's and 0's at position i
            }
        } 
        return max_len; 
    }
}
