import javax.swing.*;
import java.text.DecimalFormat;

public class ShippingCosts {

    /*
    A Shipping Company charges the following rates
    for each 100 miles shipped:

    2lbs or less ..................... $1.10
    over 2lbs but less than 6lbs ..... $2.20
    over 6lbs but less than 10lbs .... $3.70
    over 10lbs ....................... $4.80

    Write a program to calculate the shipping price. The
    distance is not prorated, in other words, the price doesn't
    increase until the next 100 miles, i.e. 150 miles for a 3lbs
    package is still just $2.20.

    Example Run:
    Weight: 5.6lbs
    Distance: 345 miles
    Price: $6.60

    As always, your program should include a method.


    Step 1: Get miles and weight
    Step 2: Calculate cost per 100 miles
    Step 3: Calculate cost to ship
    Step 4: Display Results
    */

    static double miles, weight, cost, weightCostFactor;
    static boolean validInputs;

    static DecimalFormat roundTo2 = new DecimalFormat("#,###.##");
    static DecimalFormat money = new DecimalFormat("$#,###.00");

    public static void main(String[] args) {
        miles = getInput("How many miles do you need to ship the package?");
        weight = getInput("How many pounds is the package?");

        validInputs = validateInput();

        if (validInputs){
            calcWeightCostFactor();

            calcTotalCost();

            displayResults();
        }
    }

    public static double getInput(String prompt){
        return Double.parseDouble(JOptionPane.showInputDialog(prompt));
    }

    public static boolean validateInput(){
        boolean showInvalidPrompt = false;
        String prompt = "Uh oh! You have an invalid amount of ";
        if (miles < 0){
            showInvalidPrompt = true;
            miles = 0;
            prompt = prompt +"miles and ";
        }

        if (weight < 0){
            showInvalidPrompt = true;
            weight = 0;
            prompt = prompt + "pounds and ";
        }

        if ((miles == 420) || (miles == 69) || (weight == 420) || (weight == 69)){
            prompt = "Nice.";
            JOptionPane.showMessageDialog(null, prompt);
        }

        prompt = prompt + "it looks like you'll need to run the program again.";

        if (showInvalidPrompt){
            JOptionPane.showMessageDialog(null, prompt);
        }

        return !showInvalidPrompt;
    }

    public static void calcWeightCostFactor(){
        if (weight>=10){
            weightCostFactor = 4.80;
        } else if (weight>=6){
            weightCostFactor = 3.70;
        } else if (weight>=2){
            weightCostFactor = 2.20;
        } else {
            weightCostFactor = 1.10;
        }
    }

    public static void calcTotalCost(){
        int hundredMiles;

        if (miles>=200){
            hundredMiles = (int)miles/100;
        } else {
            hundredMiles = 1;
        }

        cost = hundredMiles*weightCostFactor;
    }

    public static void displayResults(){
        JOptionPane.showMessageDialog(null, "If you ship a " + roundTo2.format(weight) + " lbs. package " + "\n" + "for " + roundTo2.format(miles) + " miles, it will cost " + "\n" + money.format(cost));
    }
}
