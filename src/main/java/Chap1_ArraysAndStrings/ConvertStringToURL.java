package Chap1_ArraysAndStrings;

public class ConvertStringToURL {

    public static void main(String[] args){
        String outputURL = convertToURL("AB CD    ", 5);
        System.out.println(outputURL);
    }

    private static String convertToURL(String input, int lengthOfInput){
        char[] inputArray = input.toCharArray();
        int spaceCounter = 0;
        int lengthOfOutput;

        for(int j=0; j<lengthOfInput; j++){
            if(input.charAt(j) == ' '){
                spaceCounter++;
            }
        }
        lengthOfOutput = lengthOfInput + spaceCounter * 2;
        int currIndex = lengthOfOutput - 1;

        for(int i = lengthOfInput-1 ; i>=0; i--){
            if(inputArray[i] != ' '){
                inputArray[currIndex--] = inputArray[i];
            }else {
                inputArray[currIndex--] = '0';
                inputArray[currIndex--] = '2';
                inputArray[currIndex--] = '%';
            }
        }

        return String.valueOf(inputArray);
    }
}
