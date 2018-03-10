package Chap1_ArraysAndStrings;

public class SetRowsAndColsToZero {

    public static void main(String[] args){
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 4;
        matrix[0][3] = 5;
        matrix[1][0] = 6;
        matrix[1][1] = 2;
        matrix[1][2] = 1;
        matrix[1][3] = 2;
        matrix[2][0] = 1;
        matrix[2][1] = 2;
        matrix[2][2] = 0;
        matrix[2][3] = 3;
        matrix[3][0] = 4;
        matrix[3][1] = 2;
        matrix[3][2] = 2;
        matrix[3][3] = 9;
        setRowsAndColsZero(matrix);

        for(int row=0; row<matrix.length;row++){
            for(int col=0; col<matrix[0].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void setRowsAndColsZero(int[][] matrix){
        boolean setCurrRowZero = false;
        boolean[] setColToZero = new boolean[matrix.length];
        int row;
        int col;

        for(row=0; row<matrix.length; row++) {
            for (col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    setCurrRowZero = true;
                    setColToZero[col] = true;
                }
            }

            if (setCurrRowZero) {
                for (col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
                setCurrRowZero = false;
            }
        }

        for(col=0;col<setColToZero.length;col++){
            if(setColToZero[col]){
                for(row=0;row<matrix.length;row++){
                    matrix[row][col]=0;
                }
            }
        }
    }
}
