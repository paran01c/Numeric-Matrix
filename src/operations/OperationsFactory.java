package operations;

public class OperationsFactory {

    //returns the apropriate operation that the user will need;
    public static Operations createOperation (String type, double[][] A, double[][] B, String extra) {

        switch(type) {
            case "Add":
                return new Add(A, B, extra);
            case "ConstMultiply":
                return new ConstMultiply(A, B, extra);
            case"Multiply":
                return new MatrixMultiply(A, B, extra);
            case "Transpose":
                return new MatrixTranspose(A, B, extra);
            default:
                return null;
        }
    }
}