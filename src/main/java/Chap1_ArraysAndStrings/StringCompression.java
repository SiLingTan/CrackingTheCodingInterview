package Chap1_ArraysAndStrings;

public class StringCompression {

    public static void main(String[] args){
        System.out.println(compressAString("aabcccccaaa"));
    }

    private static String compressAString (String s1){
        int charCounter = 1;
        char prevChar = s1.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<s1.length(); i++){
            if(prevChar == s1.charAt(i)){
                charCounter++;
            }else{
                sb.append(String.valueOf(prevChar));
                sb.append(String.valueOf(charCounter));
                charCounter = 1;
                prevChar = s1.charAt(i);
            }
        }

        sb.append(String.valueOf(prevChar));
        sb.append(String.valueOf(charCounter));
        if(sb.toString().length() < s1.length()){
            return sb.toString();
        }

        return s1;
    }
}
