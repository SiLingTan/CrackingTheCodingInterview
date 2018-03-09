package Chap1_ArraysAndStrings;

public class StringRotation {

    public static void main(String[] args){
        System.out.println(isS2ARotationOfS1("waterbottle", "erbottlewat"));
        //System.out.println(isS2ARotationOfS1("treestops", "stopstree"));
        //System.out.println(isS2ARotationOfS1("treestops", "tree"));
    }

    private static boolean isS2ARotationOfS1 (String s1, String s2){
        if(s1.length() != 0 && s1.length() == s2.length()){
            String temp = s2 + s2;

            return isSubString(s1,temp);
        }
        return false;
    }

    // Checks if s1 is a substring of s2
    private static boolean isSubString (String s1, String s2){
        return s2.contains(s1);
    }
}
