import operations.Operations;
import operations.OperationsFactory;

import java.util.Scanner;

public class MainAction {

    //fields
    Scanner sc;
    int input;

    //we carry the scanner with us so we can easyli change scanners input
    //only from main
    public MainAction (Scanner sc){
        this.sc = sc;
    }

    public void action(){

        String type = "";
        String operationType = "";

        //chooseing what kind of operation it will be performed
        //choosing if the second matrix is constant
        switch(input) {
            case 1:
                operationType = "Add";
                type = "matrix";
                break;
            case 2:
                operationType = "ConstMultiply";
                type = "const";
                break;
            case 3:
                operationType = "Multiply";
                type = "matrix";
                break;
            case 4:
                operationType = "Transpose";
                type = "none";
                break;

        }

        //in case the operation has a submenu
        processor.SubMenu subMenu = new processor.SubMenu(operationType, sc);
        String extra = subMenu.getExtra();

        //creating the 2 matrixes that will be used
        Matrix matrix = new Matrix(sc);
        double[][] A = matrix.makeMatrix(1, "matrix");
        double[][] B = matrix.makeMatrix(2, type);



        //creating the operations class with the 2 matrixes
        Operations operationNow =  OperationsFactory.createOperation (operationType, A, B, extra);

        double[][] result = operationNow.operation();

        //cecks if the operation can be done and prints the result
        if (result == null) {
            System.out.println("The Matrixes are not of the apropriate sizes");
        } else {
            resultText();
            //printing the result
            for(int i = 0; i < operationNow.getRezultingRow(); i++) {
                for (int j = 0; j < operationNow.getRezultingColumn(); j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    //the that will be used for specific results
    public void resultText(){
        if(input == 1) {
            System.out.println("The addition result is: ");
        } else if(input == 2) {
            System.out.println("The multiplication by a constatn result is:");
        } else if (input == 3) {
            System.out.println("The multiplication result is:");
        } else if(input == 4) {
            System.out.println("The transpozition result is:");
        } else {
            System.out.println("UNKNOWN OPERATION");
        }
    }

    //setter for the input variable
    public void setInput(int input) {
        this.input = input;
    }


}