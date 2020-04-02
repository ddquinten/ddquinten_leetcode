class Solution:
    def romanToInt(self, s: str) -> int:
        dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        total = 0
        prev = 0
        for i in s:
            value = dict[i]
            if prev < value:
                total -= prev * 2
            total += value
            prev = value
        return total