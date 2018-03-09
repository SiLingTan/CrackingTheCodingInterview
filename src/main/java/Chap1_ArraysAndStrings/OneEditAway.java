package Chap1_ArraysAndStrings;

public class OneEditAway {

    public static void main(String[] args){
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));
        System.out.println(isOneEditAway("e", "bake"));
    }

    private static boolean isOneEditAway(String s1, String s2){
        int faultCounter = 0;
        int idxS1 = 0;
        int idxS2 = 0;
        char charAtS1;
        char charAtS2;
        String temp;

        //Ensure that s1 is larger than s2
        if(s1.length() < s2.length()){
            temp = s1;
            s1 = s2;
            s2 = temp;
        }
        if(s1.length() > s2.length() +1){
            return false;
        }

        while((idxS1 <= s1.length() -1) && (idxS2 <= s2.length() -1)){
            charAtS1 = s1.charAt(idxS1);
            charAtS2 = s2.charAt(idxS2);
            if(charAtS1 == charAtS2){
                idxS1++;
                idxS2++;
            }else if((s1.length() == s2.length()+1) && (s1.charAt(idxS1 + 1) == charAtS2)){
                idxS1++;
                faultCounter++;
            }else if(s1.length() == s2.length()){
                idxS1++;
                idxS2++;
                faultCounter++;
            }else{
                return false;
            }
        }

        while(idxS1 != s1.length()){
            idxS1++;
            faultCounter++;
        }
        return faultCounter <= 1;
    }
}
