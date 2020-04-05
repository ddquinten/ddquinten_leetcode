# Leetcode 30-day Day 5
# Best time to buy and sell stock
# Find the greatest possible profit given array where each item represents 
# stock prices on that day. Can only buy one stock at a time

def maxProfit(prices) -> int:
	profit = 0;

	for i in range(1, len(prices)):
		if (prices[i] > prices[i - 1]):
			profit += (prices[i] - prices[i-1])
	return profit;
	
prices = [7, 1, 5, 3, 6, 4]; # given test data should output 7

print (maxProfit(prices));

prices = [1, 2, 3, 4, 5]; # given test data should output 4

print (maxProfit(prices));

prices = [7, 6, 4, 3, 1]; # given test data should output 0

print (maxProfit(prices));		

