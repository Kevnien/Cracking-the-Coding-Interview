//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
import java.util.*;

public class Q1
{
    public static boolean isUnique(String string)
    {
        Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
        for(int i=0; i<string.length(); i++)
        {
            char character = string.charAt(i);
            if(hash.get(character) != null)
            {
                return false;
            }
            else
            {
                hash.put(character,1);
            }
        }
        return true;
    }

    public static void print(String string)
    {
        System.out.println("Is the string \"" + string + "\" have only unique letters: " + isUnique(string));
    }

}
