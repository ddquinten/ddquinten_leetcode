// Leetcode 30-day Day 3
// move zeros in array to the end while keeping non-zero order
// Solution should be in-place
#include <iostream>
#include <vector>

int main()
{

	std::vector<int> nums;
    //sample output [0,1,0,3,12]
    nums.push_back(0);
    nums.push_back(1);
    nums.push_back(0);
    nums.push_back(3);
    nums.push_back(12);
	// should output [1,3,12,0,0]

	unsigned int j = 0; // iterator to track non-zeros
    for (unsigned int i = 0; i < nums.size(); i++)
    {
        if (nums[i] != 0) //non-zeros
        {
            nums[j] = nums[i]; // move to next free non-zero spot
            j++;
        }
    }
    
    if (j < nums.size()) 
    // once all non-zero entries moved to keep order fill rest of array with zeroes
        while (j < nums.size())
        {
            nums[j] = 0;
            j++;
        }

    // just to print out array
    std::cout << "[";
    for (unsigned int i = 0; i < nums.size(); i++)
    {
    	std::cout << nums[i];
    	if (i+1 == nums.size())
    		std::cout << "]\n";
    	else
    		std::cout << ",";
    }


}




