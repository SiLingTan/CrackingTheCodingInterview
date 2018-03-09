/*
    Name: Tan Si Ling
    Date: 22 Feb 2018
    Check if a given string s1 is a permutation of string s2.

    Assume that the string can only use ASCII 128 characters.
 */

package Chap1_ArraysAndStrings;

public class CheckPermutation {

    public static void main(String[] args){
        boolean isAPermutation = isPermutationOfAnother("ABCDX", "AXDCB");
        System.out.println(isAPermutation);
    }

    private static boolean isPermutationOfAnother (String s1, String s2){
        int currCharacter;
        int[] alphabets = new int[128];

        if(s1.length() != s2.length()){
            return false;
        }

        for(int i = 0; i<s1.length(); i++){
            currCharacter = s1.charAt(i);
            alphabets[currCharacter] ++;
        }

        for(int j = 0; j<s2.length(); j++){
            currCharacter = s2.charAt(j);
            if(alphabets[currCharacter] == 0){
                return false;
            }else{
                alphabets[currCharacter] --;
            }
        }

        return true;
    }

}
