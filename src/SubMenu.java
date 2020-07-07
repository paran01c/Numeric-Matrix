package processor;

import java.util.Scanner;

public class SubMenu {

    String operationType;
    String extra;
    Scanner sc;

    public SubMenu(String operationType, Scanner sc){
        this.operationType = operationType;
        this.sc = sc;
    }

    public String getExtra() {
        findExtra();
        return extra;
    }

    private void findExtra() {

        switch(operationType) {
            case "Add":
                this.extra = "nothing add";
                break;
            case "ConstMultiply":
                this.extra = "nothing const multiply";
                break;
            case "Multiply":
                this.extra = "nothing multiply";
                break;
            case "Transpose":
                this.extra = transposeExtra();
        }
    }

    private String transposeExtra () {
        System.out.println();
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");

        switch(sc.nextInt()) {
            case 1:
                return "Main Diag";
            case 2:
                return "Side Diag";
            case 3:
                return "Vert Line";
            case 4:
                return "Horiz Line";
            default:
                return "";
        }

    }
}
