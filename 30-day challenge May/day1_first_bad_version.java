// Leetcode 30-day day 1
// Description from leetcode
/* You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /*looping version
    public int firstBadVersion(int n) 
    {
        int start = 1, end = n, index = 0;
        while(start <= end)
        {
            index = start + (end-start) / 2; // set index to mid point of start and end
            if(!isBadVersion(index)) // everything before this is good
                start = index+1;
            else 
                end = index-1; // this and possibly something before is bad
        }
        if(!isBadVersion(index))  // exit loop when we've seen everything, if this isnt bad, then next one is
            return index+1;
        return index;
    }*/


    // recursive version
    public int firstBadVersion(int n) {
        return bad(1, n); // 1 is the first item, n is the last, pass the middle of them to start
    }
    
    public int bad(int start, int end)
    {
        int index = start+(end-start)/2; // <--- note to self, make sure to check proper parenthesis
        if (end <= start)
            return index;

        if (!isBadVersion(index)) // everything before this is good
            return bad(index+1, end);
        else // This and mabye something before it is bad
            return bad(start, index);
    }
}