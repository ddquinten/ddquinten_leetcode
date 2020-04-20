// Leetcode 30-day day 19
// Description from leetcode
/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).*/

#include <iostream>
#include <vector>

int divdeAndDontConquer(std::vector<int>& nums, int beginIndex, int endIndex, int target)
{

// Original implementation
/*    std::cout << beginIndex << " " << endIndex << std::endl;
    if (target == nums[beginIndex])
        return beginIndex;
    if (target == nums[endIndex])
        return endIndex;
    if (beginIndex == endIndex || (endIndex - beginIndex) == 1)
        return -1;

    int middle = (endIndex + beginIndex)/2;

    if (nums[beginIndex] <= target && target < nums[middle]) // on the left side of middle
        return divdeAndDontConquer(nums, beginIndex, middle, target);
    else  // right side of middle
        return divdeAndDontConquer(nums, middle, endIndex, target);
}*/

// Reworked
    if (beginIndex > endIndex) // iterated too far and target not found, return-1
        return -1; 

    int middle = (beginIndex + endIndex)/2; 
    // if middle happens to land on target, we can return 
    if (nums[middle] == target) 
        return middle; 

    // check if 1st half is the sorted subarray
    if (nums[beginIndex] <= nums[middle]) 
    { 
        // Check if target is in 1st half
        if (nums[beginIndex] <= target && target < nums[middle]) 
            return divdeAndDontConquer(nums, beginIndex, middle-1, target); 
        // check 2nd half
        return divdeAndDontConquer(nums, middle+1, endIndex, target); 
    } 
  
    // if 1st half isnt sorted, 2nd half must be
    if (nums[middle] <= target && target <= nums[endIndex]) 
        return divdeAndDontConquer(nums, middle+1, endIndex, target); 
    else
        return divdeAndDontConquer(nums, beginIndex, middle-1, target);     
}

// given leetcode function
int search(std::vector<int>& nums, int target) 
{
    if (nums.size() == 0)
        return -1;
    return divdeAndDontConquer(nums, 0, nums.size() - 1, target);
}

int main()
{
    
    // Leetcode given test data
    int numsArray[] = {4,5,6,7,0,1,2};
    int searchNum = 0;
    std::vector<int> nums;
    for (size_t i = 0; i < (sizeof(numsArray)/sizeof(numsArray[0])); i++)
        nums.push_back(numsArray[i]);
    // leetcode output -> 4

    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums, searchNum) << std::endl;

    searchNum = 5; // leetcode output -> 1
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums, searchNum) << std::endl;

    searchNum = 3; // leetcode output -> -1
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums, searchNum) << std::endl;

    nums.push_back(3);
    searchNum = 3; // leetcode output -> 7
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums, searchNum) << std::endl;

    //failed cases 
    int numsArray2[] = {5,1};
    std::vector<int> nums2;
    for (size_t i = 0; i < (sizeof(numsArray2)/sizeof(numsArray2[0])); i++)
        nums2.push_back(numsArray2[i]);

    searchNum = 1; // leetcode output -> 1
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums2, searchNum) << std::endl;

    nums2.push_back(2);
    searchNum = 1; // leetcode output -> 1
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums2, searchNum) << std::endl;

    nums2.push_back(3);
    searchNum = 2; // leetcode output -> 2
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums2, searchNum) << std::endl;

    nums2.push_back(4);
    searchNum = 2; // leetcode output -> 2
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums2, searchNum) << std::endl;

    int numsArray3[] = {4,5,6,7,8,1,2,3};
    std::vector<int> nums3;
    for (size_t i = 0; i < (sizeof(numsArray3)/sizeof(numsArray3[0])); i++)
        nums3.push_back(numsArray3[i]);

    searchNum = 8;
    std::cout << "The number " << searchNum << " exists in the list at index: " << search(nums3, searchNum) << std::endl;

	return 0;
}

