import javax.swing.*;
import java.text.DecimalFormat;

public class Payroll {

    /*
    This program should calculate an employee's pay
    which includes overtime pay.

    Overtime pay is any hours over 40 gets a wage equal
    to 1.5 times base wage.

    BASE WAGE: 12.50
    OVERTIME WAGE: 18.75

    HOURS WORKED: 50
    HOURS: 40 NORMAl, 10 OVERTIME
    PAY: 40 * 12.50 + 10 * 18.75 = 687.50

    Let's output this in proper currency form.
     */

    static double overtimeRate = 1.5;
    static double regPayRate, hours, overtimeHours, totalPay, regTimePay, overtimePay;

    static DecimalFormat money = new DecimalFormat("$#,###.00");

    public static void main(String[] args) {
        regPayRate = getInput("How much do you make each hour?");
        hours = getInput("How many hours have you worked?");

        calcOvertimeHours();

        calcRegPay();
        calcOvertimePay();
        calcTotalPay();
        displayResults();

    }

    public static double getInput(String prompt){
        return Double.parseDouble(JOptionPane.showInputDialog(prompt));
    }

    public static void calcOvertimeHours(){
        if (hours>40) {
            overtimeHours = hours-40;
            hours=40;
        } else {
            overtimeHours = 0;
        }
    }

    public static void calcRegPay(){
        regTimePay = regPayRate * hours;
    }

    public static void calcOvertimePay(){
        overtimePay = overtimeHours*(overtimeRate*regPayRate);
    }

    public static void calcTotalPay(){
        totalPay = regTimePay + overtimePay;
    }

    public static void displayResults(){
        JOptionPane.showMessageDialog(null, " You worked for: " + (hours + overtimeHours) + " hours. \n Meaning you worked for " + overtimeHours + " hours over 40. \n You earned " + money.format(regTimePay) + " in regular pay. \n You earned " + money.format(overtimePay) + " in overtime pay. \n Your pay this week is " + money.format(totalPay));
    }
}
