//One Away: There are three types of edits that can be performed on strings:
//insert a character, remove a character, or replace.
//Given two strings, write a function to check if they are one edit (or zero edits) away.

public class Q5
{
    public static boolean checkIfOneAway(String one, String two)
    {
        int oneLength = one.length();
        int twoLength = two.length();
        int lengthDifference = oneLength-twoLength;
        int differences = 0;
        if(lengthDifference==1)
        {
            int twoIndex = 0;
            for(int i=0; i<twoLength; i++)
            {
                if(one.charAt(i) == two.charAt(twoIndex++))
                {
                    continue;
                }
                if(differences==1)
                {
                    return false;
                }
                differences++;
                i++;
            }
            if(differences==0)
            {
                return true;
            }

        }
        else if(lengthDifference==-1)
        {
            int oneIndex = 0;
            for(int i=0; i<oneLength; i++)
            {
                if(one.charAt(oneIndex++) == two.charAt(i))
                {
                    continue;
                }
                if(differences==1)
                {
                    return false;
                }
                differences++;
                i++;
            }
            if(differences==0)
            {
                return true;
            }
        }
        else if(lengthDifference==0)
        {
            for(int i=0; i<oneLength; i++)
            {
                if(one.charAt(i)==two.charAt(i))
                {
                    continue;
                }
                if(differences==1)
                {
                    return false;
                }
                differences++;
            }
        }
        return true;
    }

    public static void print(String one, String two)
    {
        System.out.print(one + " is one edit away from " + two + ": ");
        System.out.println(checkIfOneAway(one , two));
    }
}
