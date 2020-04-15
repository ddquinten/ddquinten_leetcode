// Leetcode 30-day day 12
// Description from leetcode
//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.


//  [1,2,3,4]
// say i = 1, then we are looking at the products before '2' and after '2', then output[i]
// will equal the product of the two sides.
// the products left of '2' is 1 and right is 3*4. We can iterate through the nums array and 
// find the running product up to nums[i] = '2'. This can be done for all i's leading to '2'
// simutaneously.
import java.util.ArrayList;
import java.util.Arrays;

public class day15_product_array_except_self
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,2,3,4}; // given test array -> output is [24,12,8,6]
        day15_product_array_except_self d = new day15_product_array_except_self();
        int[] output = d.productExceptSelf(arr);

        for (int i = 0; i < output.length; i++)
            System.out.print(output[i] + " ");
        System.out.print("\n");
		
        return;
	}

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) // initialize output array to 1
            output[i] = 1;
        
        int temp = 1; // temp is used to carry the product of the left/right sides of nums[i]
         
        // used to calculate products left of nums[i]
        for (int i = 0; i < nums.length; i++)
        {
            output[i] *= temp;
            temp *= nums[i];
        }
            
        temp = 1; // reinitialzie
        
        //used to calculate products right of nums[i]
        for (int i = nums.length-1; i >= 0; i--)
        {
            output[i] *= temp;
            temp *= nums[i];
        }
        
        return output;
    }
}
