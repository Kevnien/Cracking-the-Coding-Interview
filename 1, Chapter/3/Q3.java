//URLify: Write a method to replace all spaces in a string with '%20'.
//You are given a string with spaces at the end to have enough add in the '%20' and the length.
//A character array is called to be used so that the solution would be in place.

public class Q3
{
    public static String URLify(String string, int trueLength)
    {
        char[] charArray = new char[string.length()];
        int index = 0;
        for(int i=0; i<trueLength; i++)
        {
            char current = string.charAt(i);
            if(current != ' ')
            {
                charArray[index++] = current;
            }
            else
            {
                charArray[index++] = '%';
                charArray[index++] = '2';
                charArray[index++] = '0';
            }

        }
        string = new String(charArray);
        return string;
    }

    public static void print(String string, int trueLength)
    {
        System.out.println("\"" + string + "\" URLifyed: " + URLify(string, trueLength));
    }
}
