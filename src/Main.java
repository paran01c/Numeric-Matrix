import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //starting variables
        Scanner sc = new Scanner(System.in);
        processor.MainAction mainAction = new processor.MainAction(sc);
        int input;

        //aplication loop
        while(true) {
            mainMenu();

            input = sc.nextInt();
            //checks the input of the user in the main menu
            //checks if it si corect and then sends it to the main action class if it s corect
            if(input == 0) {
                break;
            } else if(input != 1 && input != 2 && input != 3 && input != 4) {
                System.out.println("Unknown Command, retry");
                System.out.println();
            } else {

                mainAction.setInput(input);
                mainAction.action();
                System.out.println();
            }
        }
    }

    //main menu text
    static public void mainMenu() {
        System.out.println("1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose mmatrix");
        System.out.println("0. Exit");
        System.out.print("Your: ");
    }

}