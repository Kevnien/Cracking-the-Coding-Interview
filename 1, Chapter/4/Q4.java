//Palindrome Permutation: Given a string, write a function to check
//if it is a permutation of a palindrome.
//The palindrome does not need to be limited to just dictionary words.

import java.util.Hashtable;
import java.util.Set;

public class Q4
{
    public static boolean checkPalindromePermutation(String astring)
    {
        String string = astring.toLowerCase();
        Hashtable<Character, Integer> hashtable = populateHashTable(string);
        int amountOfSingles = 0;
        Set<Character> keySet = hashtable.keySet();
        for(Character key : keySet)
        {
            if(hashtable.get(key)%2!=0)
            {
                amountOfSingles++;
            }
        }
        //decided to do this check after the for loop instead of inside
        //because in my mind, most cases will be palindrome permutations
        //so it would be wasteful to do n checks, where n is the amount of unique chars
        //the downside of this is that some strings will not terminate early
        if(amountOfSingles>1)
        {
            return false;
        }
        return true;
    }

    public static Hashtable<Character, Integer> populateHashTable(String string)
    {
        Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
        for(int i=0; i<string.length(); i++)
        {
            Character character = string.charAt(i);
            Integer integer = hashtable.get(character);
            if(character == ' ')
            {
                continue;
            }
            if(integer == null)
            {
                hashtable.put(character, 1);
            }
            else
            {
                hashtable.put(character, integer+1);
            }
        }
        return hashtable;
    }

    public static void print(String string)
    {
        System.out.print("\"" + string + "\" is a permutation of a");
        System.out.print(" palindrome: ");
        System.out.println(checkPalindromePermutation(string));
    }
}
