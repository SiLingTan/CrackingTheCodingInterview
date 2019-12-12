package Chap1_ArraysAndStrings;

public class OneEditAwaySolution2 {
    public static void main(String[] args) {
        String x1 = "pale";
        String y1 = "ple";

        String x2 = "pales";
        String y2 = "pale";

        String x3 = "pale";
        String y3 = "bale";

        String x4 = "pale";
        String y4 = "bake";

        System.out.println(oneAway(x1,y1));
        System.out.println(oneAway(x2,y2));
        System.out.println(oneAway(x3,y3));
        System.out.println(oneAway(x4,y4));
    }

    public static boolean oneAway(String x, String y){

        int length = Math.abs(x.length() - y.length());
        if (length>=1){
            return compareString(x,y);
        }else if (length == 0){
            return compareEqualLengthString(x,y);
        }

        return false;
    }


    public static boolean compareEqualLengthString(String x, String y){

        int diff = 0;
        for(int i=0; i<x.length(); i++){
            if(x.charAt(i) != y.charAt(i)){
                diff++;
            }

            if(diff >1){
                return false;
            }
        }

        return true;

    }

    public static boolean compareString(String x, String y){

        int j=0;
        int diff =0;
        String longer = y;
        String shorter = x;
        if (x.length() - y.length()>=1){
            longer = x;
            shorter = y;
        }

        for(int i= 0; i<shorter.length(); i++){
            while(shorter.charAt(i) != longer.charAt(j)){
                j++;
                diff++;

                if(diff>1){
                    return false;
                }
            }
            j++;
        }

        return true;
    }
}
