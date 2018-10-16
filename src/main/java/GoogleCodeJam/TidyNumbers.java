package GoogleCodeJam;

import java.util.*;
import java.io.*;

public class TidyNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String t = in.nextLine();
        for (int i = 1; i <= Integer.valueOf(t); ++i) {
            String n = in.nextLine();
            System.out.println("Case #" + i + ": " + TidyNumbers(n));
        }
    }


    private static String TidyNumbers(String n){

        int[] numbers = arraySplitter(n);
        int[] lastTidy = lastTidyNumber(numbers);
        String tidyNum = arrayJoiner(lastTidy);

        return tidyNum;
    }

    private static int[] lastTidyNumber(int[] numbers) {
        int nineIdx = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (!isTidy(numbers[i], numbers[i + 1])) {
                numbers[i] -= 1;
                nineIdx = i + 1;
            }
        }
        if (nineIdx != -1) {
            for (int j = nineIdx; j < numbers.length; j++) {
                numbers[j] = 9;
            }
        }

        return numbers;
    }

    private static boolean isTidy(int x, int y) {
        return (x <= y);
    }

    private static int[] arraySplitter(String n) {
        int[] splitNum = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            splitNum[i] = n.charAt(i) - '0';
        }
        return splitNum;
    }

    private static String arrayJoiner(int[] n) {
        StringBuilder x = new StringBuilder();

        for(int i=0; i<n.length; i++){
            if (n[i] != 0){
                x.append(n[i]);
            }
        }
        return x.toString();
    }

}

