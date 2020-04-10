// Leetcode 30-day day 6
// This hash solution was from leetcode. I replicated to help better understand Java

// Group anagrams, given list of strings, group them by anagrams

// Example
// Given ["eat", "tea", "tan", "ate", "nat", "bat"]
// output
// ["ate", "eat", "tea"]
// ["nat", "tan"]
// ["bat"]


// Order of output does not matter
// assume all inputs are lowercase


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
//import java.util.LinkedList;

public class day6_group_anagrams_hash
{
	public static void main(String[] args)
	{
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}; // given test array
		HashMap<String, ArrayList> HashTable = new HashMap<>();

        for(int i = 0; i < strs.length; i++)
        {
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String tempString = new String(tempArray);

            if(HashTable.containsKey(tempString))
            {
                ArrayList<String> tempList = HashTable.get(tempString);
                tempList.add(strs[i]);
                HashTable.remove(tempString);
                HashTable.put(tempString, tempList);
            }
            else
            {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                HashTable.put(tempString, tempList);
            }
        }
        List<List<String>> anagrams = new ArrayList<List<String>>(); // new LinkedList<>();
        for(String s: HashTable.keySet())
        {
            List<String> tempList = HashTable.get(s);
            anagrams.add(tempList);
        }

		System.out.println(anagrams);
	}
}

