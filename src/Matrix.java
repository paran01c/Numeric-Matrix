import java.util.Scanner;

public class Matrix {

    Scanner sc;

    //we cary the scanner with us
    //so we can change the input type only in the main class
    public Matrix (Scanner sc) {
        this.sc = sc;
    }

    //creates the apropriate matrix
    //matrixNumber affects the text that will be displayed to the user
    //type it will choose it it is a [1][1] matrix - the constant or a normal matrix
    public double[][] makeMatrix (int matrixNumber, String type){

        int row = 0;
        int column = 0;

        //creating the size of the matrix or returning the cosntant
        chooseMatrixSize(matrixNumber, type);
        if(type.equals("const")){
            double[][] constant = new double[1][1];
            constant[0][0] = sc.nextDouble();
            return constant;
        } else if(type.equals("none")) {
            return new double[1][1];
        } else if(type.equals("matrix")) {
            row = sc. nextInt();
            column = sc.nextInt();
        }

        //creating the actula matrix
        double[][] newMatrix = new double[row][column];
        chooseMatrix(matrixNumber);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++) {
                newMatrix[i][j] = sc.nextDouble();
            }
        }

        return newMatrix;
    }

    //text for the user for size of matrix or constant input
    private static void chooseMatrixSize(int matrixNumber, String type) {

        System.out.println();

        if(matrixNumber == 1) {
            System.out.print("Enter size of first matrix: ");
        } else if (matrixNumber == 2) {
            if(type.equals("matrix")) {
                System.out.print("Enter size of second matrix: ");
            } else if(type.equals("const")){
                System.out.print("Enter constant: ");
            } else if(type.equals("none")){
                //nothing is needed in case the second argument does not exist;
            } else {
                System.out.print("UNKNOWN TYPE FOR STRING CREATOR matrix class");
            }
        }
    }

    //text for the user for matrix input
    private static void chooseMatrix (int matrixNumber) {
        if(matrixNumber == 1) {
            System.out.println("Enter first matrix:");
        } else if (matrixNumber == 2) {
            System.out.println("Enter second matrix:");
        }
    }
}