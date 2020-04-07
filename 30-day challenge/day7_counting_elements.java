// Leetcode 30-day day 7
// Given int array, find x st x+1 is also in array

// Example [1,2,3]
// Output  2

// Array length 1 <= arr.length <= 1000
// 0 < arr[i] <= 1000

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class day7_counting_elements
{
	public static void main(String[] args)
	{
		int[] nums1 = new int[] {1, 2, 3};
		System.out.println(countElements(nums1));

		int[] nums2 = new int[] {1, 1, 3, 3, 5, 5, 7, 7};
		System.out.println(countElements(nums2));

		int[] nums3 = new int[] {1, 3, 2, 3, 5, 0};
		System.out.println(countElements(nums3));

		int[] nums4 = new int[] {1, 1, 2, 2};
		System.out.println(countElements(nums4));
	}

	public static int countElements(int[] arr)
	{
		HashMap<Integer, Boolean> HashTable = new HashMap<>();

		for (int i = 0; i < arr.length; i++)
		{
			if (!HashTable.containsKey(arr[i]))
			{
				boolean exists = true;
				HashTable.put(arr[i], exists);
			}
		}

		int count = 0;

		for (int i = 0; i < arr.length; i++)
		{
			if (HashTable.containsKey(arr[i] + 1))
			{
				count++;
			}
		}

		return count;
	}
}