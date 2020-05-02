// Leetcode 30-day day 12
// description from leetcode
/* We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  
The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.) */

// Method - use max heap to quickly retrieve two biggest rocks, is same weight, dont add to max, else add difference

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class day12_last_stone_weight
{
	public static void main(String[] args)
	{
		int[] stones = new int[] {2, 7, 4, 1, 8, 1}; // given test array -> output is 1
        day12_last_stone_weight d = new day12_last_stone_weight();


		System.out.println(d.lastStoneWeight(stones));

        return;
	}

    public int lastStoneWeight(int[] stones)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++)
            maxHeap.add(stones[i]);

        while(maxHeap.size() > 1)
        {
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();

            if (stone1 == stone2)
                continue;
            maxHeap.add(stone1 - stone2); // b/c max heap stone will always be greater
        }
        if (maxHeap.isEmpty())
            return 0;
        return maxHeap.remove();
    }
}

