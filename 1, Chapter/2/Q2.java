//Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.

import java.util.*;

public class Q2
{
    //Will add the characters of the first string into a hashtable
    //value of the table entry is the amount of that characters in the string
    //Then will check each letter in the second string with the hashtable
    //value will be decremented when character is checked so to keep track if the amount of letters
    //if letter isn't there at all or too many of one letter occurs then return false
    public static boolean checkPermutation(String first, String second)
    {
        Hashtable<Character,Integer> hash = new Hashtable<Character, Integer>();
        for(int i=0; i<first.length(); i++)
        {
            char current = first.charAt(i);
            Integer currentValue = hash.get(current);
            if(currentValue != null)
            {
                hash.put(current, currentValue+1);
            }
            else
            {
                hash.put(current, 1);
            }
        }
        for(int i=0; i<second.length(); i++)
        {
            char current = second.charAt(i);
            Integer currentValue = hash.get(current);
            if(currentValue == null || currentValue == 0)
            {
                return false;
            }
            else
            {
                hash.put(current, currentValue-1);
            }
        }
        return true;
    }

    public static void print(String first, String second)
    {
        System.out.print("Is " + first + " a permutation of the letters in " + second);
        System.out.println(": " + checkPermutation(first, second));
    }
}
