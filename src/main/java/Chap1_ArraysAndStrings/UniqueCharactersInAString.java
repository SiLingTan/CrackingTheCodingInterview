package Chap1_ArraysAndStrings;

public class UniqueCharactersInAString {

    public static void main(String[] args){
        System.out.println("Answer:" + uniqueCharacters("abdd"));
    }

    private static boolean uniqueCharacters(String s){
        int currChar;
        // It is initialised to false at the start.
        boolean[] alphebets = new boolean[128];

        for(int i=0; i<s.length(); i++){
            currChar = s.charAt(i);
            if(alphebets[currChar]){
                return false;
            }else{
                alphebets[currChar] = true;
            }
        }

        return true;
    }
}
