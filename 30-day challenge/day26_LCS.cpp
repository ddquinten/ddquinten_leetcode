// Leetcode 30-day day 25
// Description from leetcode
/* Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. 
(eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.*/

// just solution class
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.size(), n = text2.size();
        int L[m + 1][n + 1];   
        
        /* build a 2d array where at any index we have the LCS for i postion
           in text1 and j position in text2 */
        for (int i = 0; i <= m; i++)  
            for (int j = 0; j <= n; j++)  
                if (i == 0 || j == 0) // beginning - set to 0 
                    L[i][j] = 0;  
                else if (text1[i - 1] == text2[j - 1])
                /* if match at i-1 position in text 2 and j-1 in text2
                   add 1 to LCS with said index and store to current */
                    L[i][j] = L[i - 1][j - 1] + 1;  
                else // no match, continue LCS by adding LCS thus far to current
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);  

        // when we reach the end, found LCS
        return L[m][n];  
    }
};

