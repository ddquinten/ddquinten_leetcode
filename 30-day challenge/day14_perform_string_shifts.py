# Leetcode 30-day Day 14
"""You are given a string s containing lowercase English letters, and a matrix shift, 
where shift[i] = [direction, amount]:
	direction can be 0 (for left shift) or 1 (for right shift). 
	amount is the amount by which string s is to be shifted.
	A left shift by 1 means remove the first character of s and append it to the end.
	Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations."""

# Thought process - find the total shift amount, left being a negative number 
# and right being positive. Since right and left shift cancel each other out
# we can add and subtract respectively. Then shift that many times until 
# shift amount is equal to 0.

def stringShift(s, shift) -> str:
	totalShift = 0; # positive is right/ neg is left

	for i in range(0, len(shift)): # finding total shift amount
		if shift[i][0] == 0: # if left shift, subtract amount
			totalShift -= shift[i][1]
		else: # if right shift add that amount
			totalShift += shift[i][1]

	# the shift is done by taking the first or last char and 
	# appending it to the end or beginning, respectfully per shift amount
	
	while (totalShift != 0): # dont shift, b/c right and left cancelled out
		if (totalShift < 0): # left 
			s = s[1:len(s)] + s[0]
			totalShift += 1
		elif (totalShift > 0): # right
			s = s[len(s)-1] + s[0:len(s)-1] 
			totalShift -= 1

	return s


word = "abc" # output should be "cab"
shiftListofList = [[0,1],[1,2]]

print (stringShift(word, shiftListofList))

word = "abcdefg" # output should be "efgabcd"
shiftListofList = [[1,1],[1,1],[0,2],[1,3]]

print (stringShift(word, shiftListofList))

