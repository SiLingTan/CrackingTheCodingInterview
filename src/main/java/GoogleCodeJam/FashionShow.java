package GoogleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Cell {
    public boolean mustP;
    public boolean mustC;
    public boolean isChanged;
    public String value;
    public int row;
    public int col;

    public Cell(boolean mustP, boolean mustC, boolean isChanged, String value, int row, int col){
        this.mustP = mustP;
        this.mustC = mustC;
        this.isChanged = isChanged;
        this.value = value;
        this.row = row;
        this.col = col;
    }
}


public class FashionShow {

    public static void main (String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i<=t; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            Cell[] models = new Cell[m];

            for(int r =0; r<m; r++){
                String c = in.next();
                int row = in.nextInt()-1;
                int col = in.nextInt()-1;
                Cell model = new Cell(false, false, false, c, row, col);
                models[r] = model;
            }
            Cell[][] modelsBoard = createModelsBoard(models, n);
            Cell[][] optimisedBoard = optimiseModelBoard(modelsBoard);
//            printOutput(optimisedBoard);
            output(optimisedBoard, i);
        }

        return;
    }

    private  static Cell[][] createModelsBoard(Cell[] models, int n){
        int m = models.length;
        Cell[][] modelBoard = new Cell[n][n];

        for(int row=0;row<n; row++) {
            for (int col = 0; col < n; col++) {
                modelBoard[row][col] = new Cell(false, false, false, " ",row, col);
            }
        }

        for(int i=0; i<m; i++){
            int row = models[i].row;
            int col = models[i].col;
            String val = models[i].value;

            modelBoard[row][col] = models[i];
            if (val.equals("x")){
                modelBoard = setPlus(modelBoard, row, col);
            }else if (val.equals("+")){
                modelBoard = setCross(modelBoard, row, col);
            }
        }

        return modelBoard;
    }


    private static Cell[][] optimiseModelBoard (Cell[][] modelsBoard){
        for(int row=0;row<modelsBoard.length; row++){
            for(int col=0; col<modelsBoard[0].length; col++){

                    String value = modelsBoard[row][col].value;
                    boolean mustP = modelsBoard[row][col].mustP;
                    boolean mustC = modelsBoard[row][col].mustC;
                    if (value.equals(" ") && !(mustP && mustC)) {
                        if (mustC) {
                            modelsBoard[row][col].value = "x";
                            modelsBoard = setPlus(modelsBoard, row, col);
                        } else {
                            modelsBoard[row][col].value = "+";
                            modelsBoard = setCross(modelsBoard, row, col);
                        }
                        modelsBoard[row][col].isChanged = true;
                    }
            }
        }

        return optimiseModelsWithO(modelsBoard);
    }

    private static Cell[][] optimiseModelsWithO(Cell[][] modelsBoard){
        for(int row=0;row<modelsBoard.length; row++) {
            for (int col = 0; col < modelsBoard[0].length; col++) {
                boolean mustP = modelsBoard[row][col].mustP;
                boolean mustC = modelsBoard[row][col].mustC;
                String val = modelsBoard[row][col].value;
                if (!val.equals("o") && !(mustP || mustC)){
                    modelsBoard[row][col].value = "o";
                    modelsBoard[row][col].isChanged = true;
                    modelsBoard[row][col].row = row;
                    modelsBoard[row][col].col = col;
                }
            }
        }
        return modelsBoard;
    }

    private static Cell[][] setPlus(Cell[][] models, int row, int col){
        for (int c = 0; c < models[0].length; c++) {
            if (c != col) {
                models[row][c].mustP = true;
            }
        }

        for (int r = 0; r < models.length; r++) {
            if (r != row) {
                models[r][col].mustP = true;
            }
        }
        return  models;
    }

    // A | B
    // C | D
    private static Cell[][] setCross(Cell[][] models, int row, int col){
        // D
        int r = row+1;
        for (int c = col+1; c < models[0].length && r<models.length; c++) {
            models[r++][c].mustC = true;
        }

        // A
        r = row-1;
        for (int c = col-1; c >= 0 && r >= 0; c--) {
            models[r--][c].mustC = true;
        }

        // B
        int c = col+1;
        for (r = row-1; r >=0 && c<models[0].length; r--) {
            models[r][c++].mustC = true;
        }

        // C
        c = col-1;
        for (r = row+1; c >= 0 && r <models.length; r++) {
            models[r][c--].mustC = true;
        }

        return  models;
    }

    // printOutput prints out the modelsBoard for testing
    private static void printOutput(Cell[][] modelsBoard){
        for(int row=0;row<modelsBoard.length; row++) {
            for (int col = 0; col < modelsBoard[0].length; col++) {
                System.out.println(modelsBoard[row][col].value + " "+ modelsBoard[row][col].mustP + " " + modelsBoard[row][col].mustC);
            }
            System.out.println();
            System.out.println();
        }
    }

    private static void output(Cell[][] modelsBoard, int caseNum){
        int totalScore =0;
        int counter=0;

        for(int row=0;row<modelsBoard.length; row++) {
            for (int col = 0; col < modelsBoard[0].length; col++) {

                String val = modelsBoard[row][col].value;
                if (val.equals("x") || val.equals("+")){
                    totalScore++;
                }else if (val.equals("o")){
                    totalScore += 2;
                }

                if (modelsBoard[row][col].isChanged){
                    counter++;
                }
            }
        }

        System.out.println("Case #"+ caseNum + ": " + totalScore + " " + counter);

        for(int row=0;row<modelsBoard.length; row++) {
            for (int col = 0; col < modelsBoard[0].length; col++) {
                if(modelsBoard[row][col].isChanged){
                    String val = modelsBoard[row][col].value;
                    int valRow = modelsBoard[row][col].row+1;
                    int valCol = modelsBoard[row][col].col+1;
                    System.out.println(val+ " " + valRow+ " " +  valCol);
                }
            }
        }

    }
}
