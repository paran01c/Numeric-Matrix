package operations;

public abstract class Operations {

    //the two matrix that will be used
    double[][] A;
    double[][] B;

    String extra;

    public Operations(double[][] A, double[][] B, String extra) {
        this.A = A;
        this.B = B;
        this.extra = extra;
    }

    public abstract double[][] operation();
    public abstract int getRezultingRow();
    public abstract int getRezultingColumn();

}

//the class that will add the matrixes together
class Add extends Operations {

    public Add(double[][] A, double[][] B, String extra) {
        super(A, B, extra);
    }

    @Override
    public double[][] operation(){

        if(A.length != B.length && A[0].length != B[0].length) {
            return null;
        }

        int row = A.length;
        int columns = A[0].length;
        double[][] newMatrix = new double[row][columns];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[i][j] = A[i][j] + B[i][j];
            }
        }

        return newMatrix;
    }

    public int getRezultingRow() {
        return A.length;
    }
    public int getRezultingColumn() {
        return A[0].length;
    }
}

//the class that will multiply the matrix by a constant the b matrix will be the constant
class ConstMultiply extends Operations{


    public ConstMultiply(double[][] A, double[][] B, String extra) {
        super(A, B, extra);
    }

    //B matrix is the constant
    @Override
    public double[][] operation(){
        int row = A.length;
        int columns = A[0].length;
        double[][] newMatrix = new double[row][columns];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[i][j] = A[i][j] * B[0][0];
            }
        }

        return newMatrix;
    }

    public int getRezultingRow() {
        return A.length;
    }
    public int getRezultingColumn() {
        return A[0].length;
    }
}

//the class that will multiply 2 matrixs together
class MatrixMultiply extends Operations {

    public MatrixMultiply (double[][] A, double[][] B, String extra) {
        super(A, B, extra);
    }

    @Override
    public double[][] operation(){

        if(A[0].length != B.length) {
            return null;
        }

        int newRow = A.length;
        int newColumns = B[0].length;
        double[][] newMatrix = new double[newRow][newColumns];


        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newColumns; j++) {
                newMatrix[i][j] = multiply(A, B, i, j);
            }
        }

        return newMatrix;
    }

    public int getRezultingRow() {
        return A.length;
    }
    public int getRezultingColumn() {
        return B[0].length;
    }

    private double multiply (double[][] A, double[][] B, int indexRow, int indexColum){
        int rowsAndColumns = A[0].length;
        double number = 0;

        for(int i = 0; i < rowsAndColumns; i++) {
            number += A[indexRow][i] * B[i][indexColum];
        }

        return number;
    }
}

class MatrixTranspose extends Operations {

    int resultingRow;
    int resultingColumn;

    public MatrixTranspose (double[][] A, double[][] B, String extra) {
        super(A, B, extra);
    }

    @Override
    public double[][] operation() {

        int row = A.length;
        int column = A[0].length;

        System.out.println("Work in progress");

        double[][] test = new double[1][1];
        test[0][0] = 1;

        switch(extra) {
            case "Main Diag":
                this.resultingRow =  column;
                this.resultingColumn = row;
                return mainDiagonal(row, column);
            case "Side Diag":
                this.resultingRow =  column;
                this.resultingColumn = row;
                return sideDiagonal(row,column);
            case "Vert Line":
                this.resultingRow =  row;
                this.resultingColumn = column;
                return verticalLine(row, column);
            case "Horiz Line":
                this.resultingRow =  row;
                this.resultingColumn = column;
                return horizontalLine(row, column);
        }
        return null;
    }

    private double[][] horizontalLine(int row, int column) {

        double[][] result = new double[row][column];

        for(int i  = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = A[row - (i + 1)][j];
            }
        }

        return result;
    }

    private double[][] verticalLine (int row, int column) {

        double[][] result = new double[row][column];

        for(int i  = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = A[i][column - (j + 1)];
            }
        }

        return result;
    }

    private double [][] mainDiagonal (int row, int column) {

        double[][] result = new double[column][row];

        for(int i  = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }

    private double[][] sideDiagonal (int row, int column) {

        double[][] result = new double[column][row];

        for(int i  = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][i] = A[row - (i + 1)][column - (j + 1)];
            }
        }

        return result;
    }

    public int getRezultingRow() {
        return resultingRow;
    }
    public int getRezultingColumn() {
        return resultingColumn;
    }
}