# Leetcode 30-day Day 16
"""Given a string containing only three types of characters: '(', ')' and '*', 
   write a function to check whether this string is valid. We define the validity of a string by these rules:

	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
	An empty string is also valid."""

# track smallest Possible open Brackets (guareented '(') and highest possible (those including '*')
# ')' close off smallest and highest possible

def checkValidString(s) -> bool:
    if (len(s) == 0):
        return True
    # smallest and highest possible open brackets currently
    smallestOpen = highestOpen = i = 0
    while (i < len(s)):
        if (s[i] == '('): 
            smallestOpen += 1
            highestOpen += 1
        elif (s[i] == ')'): # closing the brackets
            if (smallestOpen > 0):
                smallestOpen -= 1
            highestOpen -= 1
        else: # '*' could possibly be an open or closed bracket, so track both
            if (smallestOpen > 0):
                smallestOpen -= 1
            highestOpen += 1
        if (highestOpen < 0): # if negative, more right then left brackets
            return False
        i += 1

    return smallestOpen == 0 # 0 only if closed parens


string = "*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)" # output should be false

print (checkValidString(string))

string = "(*))" # output should be true

print (checkValidString(string))