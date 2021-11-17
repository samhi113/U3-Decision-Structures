import javax.swing.*;

public class Prom {

    /* In order to purchase a ticket to go to prom,
    you must be a Junior or Senior, have no disciplinary
    records and have $40 to pay for it.
     */
    static int gradeLevel, money, recentRecords;
    public static void main(String[] args) {
        gradeLevel = getInput("What class are you in? (9, 10, 11, or 12)");
        recentRecords = getInput("How many suspensions have you had?");
        money = getInput("How much money do you have? (No $ sign)");

        if (gradeLevel >= 11){
            if (recentRecords < 0.5){
                if (money >= 40){
                    accept();
                } else {
                    reject();
                }
            } else {
                reject();
            }
        } else {
            reject();
        }
    }

    public static int getInput(String prompt){
        return (int)Double.parseDouble(JOptionPane.showInputDialog(prompt));
    }

    public static void reject(){
        JOptionPane.showMessageDialog(null, "Sorry, you can't go to prom.");
    }

    public static void accept(){
        JOptionPane.showMessageDialog(null, "Congrats! You can go to prom. Make sure to get your tickets by 6/9 @ 4:20 PM.");
    }

}
