// Leetcode 30-day day 
// Description from leetcode
/*Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        letters = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++)
        {
            char temp = magazine.charAt(i);
            if (letters.containsKey(temp)) // we have seen letter before
                letters.replace(temp, letters.get(temp) + 1);
            else // add letter the hash
                letters.put(temp, 1);
        }
        
        for (int i = 0; i < ransomNote.length(); i++)
        { 
            char temp = ransomNote.charAt(i);
            if (!letters.containsKey(temp) || letters.get(temp) == 0)
            // if we dont have the letter in magazine or run out of letters, cant make note
                return false;
            else // use a letter of magazine
                letters.replace(temp, letters.get(temp) - 1);
        }
        return true; // if we get here, made a ransom note
    }
    
    private HashMap<Character, Integer> letters; // bin of letters from magazine
}

// leetcode fastest solution not mine
/*
class Solution {
    public boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) return false;
        int caps[] = new int[26];
        for (char c : ransom.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }
}
*/