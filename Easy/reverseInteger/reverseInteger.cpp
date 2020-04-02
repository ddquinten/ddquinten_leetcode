/* Program used to solve the reverse integer problem on LeetCode. Function will prompt
   for an integer and will return the reversed order of that integer. If the reversed
   integer results in an integer overflow, the program will print Overflow*/

#include <iostream>
#include <climits> 
// includes limits for all variables in c++. Using for Int min and max
using namespace std;

int reverse(int, bool&);

int main()
{
    int input, output;
    bool overflow;
    cout << "Enter number to be reversed: ";

    cin >> input;

    output = reverse(input, overflow);

    cout << "\nInput integer:   " << input;
    if (overflow)
        cout << "\nOutput interger: Overflow!" << endl << endl;
    else
        cout << "\nOutput interger: " << output << endl << endl;        

    return 0;
}

int reverse(int x, bool& overflow) 
// function excepts an integer to reverse and a bool value by referance to determine overflow.
{
/*     bool neg = false;
    if (x < 0)
    {    
        neg = true;
        x = x * -1;
    }*/
    overflow = false;
    long long total = 0;
    while (x != 0) // Using != allows negative numbers as opposed to >
    {   
        total = total * 10;
        total += (x % 10);
        x = x / 10;
        if (total < INT_MIN or total > INT_MAX)
        {
            overflow = true;
            return 0;
        }
    }

    return total;
    /*if (neg == true)
        return -1 * total;
    else
        return total;*/
}