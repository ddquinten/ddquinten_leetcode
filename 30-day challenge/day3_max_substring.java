public class day3_max_substring
// find the highest contiguous substring sum
{
	public static void main(String[] args) 
	{
		// Given test array - output should be 6 --> [4,-1,2,1]
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

		int highest = nums[0], running = 0; // assume the first num is the highest
		for(int i = 0; i < nums.length; i++) // n-time
		{
			running = running + nums[i];

			// check highest < running first for the case of all negative nums
			if (highest < running) // if running is higher than are highest sum, change the highest
				highest = running;

			if (running < 0) // if the running ever gets negative we womnt consider it
				running = 0; // reintialize to continue running sum

		}
		System.out.println(highest);
	}
}
