// String Compression
// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2b1c5a3.
// If the "compressed" string would not become smaller than the original string, your method should return the original string.
// You can assume the string has only uppercase and lowercase letters.

class Q6{
    public static String stringCompression(String input){
        String answer = "";
        int length = input.length();
        char last = input.charAt(0);
        answer += last;
        int count = 1;
        for(int i=1; i<length; i++){
            char current = input.charAt(i);
            if(current == last){
                count++;
            }else{
                answer += count;
                count = 1;
                last = current;
                answer += last;
            }
        }
        answer += count;
        return answer;
    }

    public static void main(String[] args){
        System.out.println(stringCompression("aabcccccaaa"));
    }
}