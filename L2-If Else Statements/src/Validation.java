import javax.swing.*;

public class Validation {

    /*
    Let's create a simple program that validates
    a user's input.

    Let's say a user must enter a number greater than 10.
     */

    public static void main(String[] args) {

        int num = (int)Double.parseDouble(JOptionPane.showInputDialog("Please enter a number that's greater than 10"));

        if (num > 10){
            JOptionPane.showMessageDialog(null, "Thanks! Please continue.");
        } else {
            JOptionPane.showMessageDialog(null, " Uh oh! That number is less than 10. \n You're an absolute kindergarten-level, crayon-munching toddler :I");
        }
    }


}
