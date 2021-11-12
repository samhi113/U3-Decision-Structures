import javax.swing.*;
import java.text.DecimalFormat;

public class AddORMultiply {

    /*
    Write two methods, one that adds two numbers and second that multiplies them.
    Then, write a main method that prompts the user to enter 2 numbers.

    If the first one is larger than the second, mutiply and display the result
    If not, add them and display the results.
     */
    //Step 1: Get inputs
    //Step 2: Is num1>num2?
    //Step 3: If yes, multiply
    //Step 4: If no, add
    //Step 5: Display results

    static boolean isNum1Greater;
    static double num1, num2;

    static DecimalFormat roundTo2 = new DecimalFormat("#,###.##");

    public static void main(String[] args) {
        num1 = getInput("What will be your first number?");
        num2 = getInput("What will be your second number?");

        checkNum1Greater();

        displayResults();
    }

    public static double getInput(String prompt){
        return Double.parseDouble(JOptionPane.showInputDialog(prompt));
    }

    public static void checkNum1Greater(){
        if (num1 > num2){
            isNum1Greater = true;
        }

        if (num1 <= num2){
            isNum1Greater = false;
        }
    }

    public static void displayResults(){
        if (isNum1Greater){
            JOptionPane.showMessageDialog(null, num1 + " x " + num2 + " = " + roundTo2.format(num1*num2));
        }

        if (!isNum1Greater){
            JOptionPane.showMessageDialog(null, num1 + " + " + num2 + " = " + roundTo2.format(num1+num2));
        }
    }
}
