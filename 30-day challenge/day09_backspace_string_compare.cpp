// Leetcode 30-day day 9
// Given two strings S and T, return if they are equal when both are typed into empty text editors. 
// # means a backspace character.
// 1 <= S.length <= 200
// 1 <= T.length <= 200
// S and T only contain lowercase letters and '#' characters.

#include <iostream>
#include <string>

void reduceString(std::string& s, int& length)
{
    int i = 0;
    length = 0;
    while (i < s.length())
    {
        // backspace
        if (s[i] == '#' && length != 0)
        {
            length--;
        }
        
        if(s[i] >= 'a' && s[i] <='z')
            s[length++] = s[i];
        
        i++;
    }
    return;
}

bool backspaceCompare(std::string S, std::string T) 
{
    int slength;
    int tlength;
    
    reduceString(S, slength);
    reduceString(T, tlength);
    
    if (slength != tlength)
        return false;
    for (int i = 0; i < slength; i++) // lengths are same so doesnt matter which one we pick
        if (S[i] != T[i])
            return false;
    return true;
}

int main()
{
	// input "ab#c" and "ad#c"
	// output true both reduce to "ac"
	std::string S = "ab#c";
	std::string T = "ad#c";

	if (backspaceCompare(S, T))
		std::cout << "True\n";
	else
		std::cout << "False\n";

	return 0;
}

