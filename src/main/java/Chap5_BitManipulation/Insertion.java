package Chap5_BitManipulation;

public class Insertion {
    public static void main(String[] args) {
        // TODO: how to take in just the numbers
        int n = (int) Math.pow(2,10);
        int m = (int) Math.pow(2,4)+3;
        int i = 2;
        int j = 6;

        System.out.println(fitNumbers(n,m,i,j));
    }

    public static String fitNumbers(int n, int m, int i, int j){
        int modifiedM = padZeros(m, i);
        int combinedNum = n | modifiedM;
        return convertToBinary(combinedNum);
    }

    public static int padZeros(int m, int i){
        for(int k=0; k<i;k++){
            m<<=1;
        }
        return m;
    }

    public static String convertToBinary(int num){
        return Integer.toBinaryString(num);
    }
}
