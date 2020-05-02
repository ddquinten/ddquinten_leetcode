// Leetcode 30-day day 6 - This was a non-hash solution
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

public class day6_group_anagrams
{
	public static void main(String[] args)
	{
		String[] listOfWords = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}; // given test array
		List<List<String>> anagrams = new ArrayList<List<String>>();
		int anagramIndex = 0;

		for (int i = 0; i < listOfWords.length; i++)
		{
			char tempArray[] = listOfWords[i].toCharArray();
			Arrays.sort(tempArray); // sort all strings to easily compare
			String temp = new String(tempArray);

			if (anagrams.isEmpty()) // no groups of anagrams
			{
				List<String> list = new ArrayList<>(); // create first group of anagrams and add to list of groups.
				anagrams.add(list);
				anagrams.get(anagramIndex).add(temp); // add sorted string for searching
				anagrams.get(anagramIndex).add(listOfWords[i]); // original string from given input
				anagramIndex++;
			}
			else // a group exist
			{
				for (int k = 0; k < anagrams.size(); k++) // search groups
					if (anagrams.get(k).contains(temp)) // matching anagram group found
					{
						anagrams.get(k).add(listOfWords[i]); // add original string
						break;
					}
					else if (k + 1 >= anagrams.size()) // end of list, no matches found make a new group
					{
						List<String> list = new ArrayList<>(); // create another group, getting here assumse groups exist but no match found
						anagrams.add(list);
						anagrams.get(anagramIndex).add(temp); // add sorted string for searching
						anagrams.get(anagramIndex).add(listOfWords[i]); // add original string
						anagramIndex++;
						break;
					}
			}
		}

		for (int i = 0; i < anagramIndex; i++) // remove the temp string from all groups of anagrams
			anagrams.get(i).remove(anagrams.get(i).get(0));

		System.out.println(anagrams);
	}
}
