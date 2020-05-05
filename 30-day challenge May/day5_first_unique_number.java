// Leetcode 30-day day 5
// Description from leetcode
/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/

class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0)
            return -1;
        
        seen = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++)
            char temp = s.charAt(i);
            if(seen.containsKey(temp)) // exist in hash so add to total
                seen.replace(temp, seen.get(temp) + 1); 
            else
                seen.put(temp, 1); // new in hash, total equal 1
        
        for (int i = 0; i < s.length(); i++)
            if(seen.get(s.charAt(i)) == 1) // first encounter in hash == 1 is first unique
                return i;
        return -1; // nothing in hash is unique
    }
    
    private HashMap<Character, Integer> seen;
}

// leetcode fastest solution not mine
/*
class Solution {
    public int firstUniqChar(String s) {
        int res = Integer.MAX_VALUE;
        
        for(char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);
            
            if(index != -1 && index == s.lastIndexOf(c))
                res = Math.min(res, index);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
*/