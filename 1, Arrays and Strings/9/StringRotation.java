// Assume you have a method isSubstring which checks if one word is a substring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring

class StringRotation{
    public static boolean stringRotation(String s1, String s2){
        int length2 = s2.length();
        // if lengths aren't even equal, then there is no way s2 is a rotation of s1
        if(s1.length() != length2){
            return false;
        }
        String build = "";
        char firstChar = s1.charAt(0);
        for(int i=0; i<length2; i++){
            char currentChar = s2.charAt(i);
            if(currentChar == firstChar){
                String comparer = s2.substring(i, length2) + build;
                // System.out.println("found character in s2 that's the same as the first char of s1.\n The built string is:\n"+comparer+"\n"+s1+" <-- s1");
                if(comparer.equals(s1)){
                    return true;
                }
                // System.out.println("they are not the same");
            }
            build += currentChar;
        }
        return false;
    }

    public static void main(String[] args){
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println(stringRotation(s1, s2));
        s1 = "waterbottle";
        s2 = "rbottlewat";
        System.out.println(stringRotation(s1, s2));

    }
}