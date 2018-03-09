/*
    Possible ways to improve the code:
    1. Need to handle invalid characters like *
    2. Can modularize the code
    3. Another possible solution method is using Bit Manipulation.

 */

package Chap1_ArraysAndStrings;

public class PalindromePermutation {

    public static void main(String[] args){
        System.out.println(isAPalindromePermutation("Tact CoA"));
    }

    private static boolean isAPalindromePermutation(String input){
        int counter = 0;
        int currCharIdx;
        char currChar;
        boolean[] characters = new boolean[26]; // initialised to false

        for(int i=0; i<input.length(); i++){
            currChar = Character.toLowerCase(input.charAt(i));
            if(!Character.isWhitespace(currChar)){
                currCharIdx = currChar - 'a';
                characters[currCharIdx] = !characters[currCharIdx];
            }
        }

        for(boolean character : characters){
            if(character){
                counter ++;
            }
        }

        return counter <= 1;
    }
}
