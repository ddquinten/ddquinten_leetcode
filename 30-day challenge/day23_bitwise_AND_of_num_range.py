# Leetcode 30-day Day 23
"""Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive."""

#leetcode samples

""" Input: [5,7]
    Output: 4

    Input: [0,1]
    Output: 0 """

m = int(input("Enter a number m: "))
n = int(input("Enter a number n: "))
x = n

""" when we take the bitwise & of n and it's 2's compliment, we get the lsb
    by substracting the lsb from n, we get a new number
    if that number is <= m, we have our bitwise sum
    otherwise, keep trying until we find it"""

while(m < x): 
    x -= (x & -x)

print ("Bitwise AND of all numbers in range " + str(m) + " to " + str(n) + " is: " + str(x)) 
