package ChapVI_BigO;

public class IntegerDivision {

    public static void main(String[] args){
        System.out.println(div(6,2));
    }

    private static int div(int a, int b){
        int counter = 0;
        int sum = b;
        while(sum<= a){
            sum += b;
            counter++;
        }

        return counter;
    }
}
