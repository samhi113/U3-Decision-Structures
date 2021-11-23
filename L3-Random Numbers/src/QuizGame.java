import javax.swing.*;
import java.util.Random;
public class QuizGame {

    static double usersAnswer, correctAnswer;
    static String displayProblem = "";
    static JPanel panel;
    static JButton newProblemButton, checkAnswerButton;
    static JLabel showProblem;
    static JRadioButton addition, subtraction, multiplication, division;

    public static void main(String[] args) {
        new QuizGame();
        /*
        createProblem();
        getUserAnswer();
        checkAnswer();
        */

    }

    public QuizGame(){
        JFrame frame = new JFrame("Quiz Game");
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();

        addition = new JRadioButton("Addition");
        subtraction = new JRadioButton("Subtraction");
        multiplication = new JRadioButton("Multiplication");
        division = new JRadioButton("Division");

        addition.setBounds(100, 10, 150, 50);
        subtraction.setBounds(100, 40, 150, 50);
        multiplication.setBounds(100, 70, 150, 50);
        division.setBounds(100, 100, 150, 50);

        panel.add(addition);
        panel.add(subtraction);
        panel.add(multiplication);
        panel.add(division);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
    }

    public static void checkAnswer(){
        if (usersAnswer == correctAnswer){
            displayProblem = "You are correct!";
        } else {
            displayProblem = "Incorrect. Better luck next time.";
        }
        JOptionPane.showMessageDialog(null, displayProblem);
        System.out.println(correctAnswer);
    }

    public static void getUserAnswer(){
        usersAnswer = input(displayProblem);
    }

    public static void addProblem(){
        int num1 = randomNum();
        int num2 = randomNum();

        correctAnswer = num1 + num2;

        displayProblem = num1 + " + " + num2 + " = ?";
    }

    public static void subProblem(){
        int num1 = randomNum();
        int num2 = randomNum();

        correctAnswer = num1 - num2;

        displayProblem = num1 + " - " + num2 + " = ?";
    }

    public static void mulProblem(){
        int num1 = randomNum();
        int num2 = randomNum();

        correctAnswer = num1 * num2;

        displayProblem = num1 + " X " + num2 + " = ?";
    }

    public static void divProblem(){
        int num1 = randomNum();
        int num2 = randomNum();

        correctAnswer = (double)num1/num2;

        correctAnswer = (Math.round(correctAnswer)*100.00)/100.00;

        displayProblem = num1 + " / " + num2 + " = ?";
    }

    //HELPER METHOD
    public static int randomNum(){
        Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public static double input(String message){
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }

    public static void createProblem(){
        int choice = (int)(input("Choose: Addition(1)\nSubtraction(2)\nMultiplication(3)\nor Division(4)"));

        if (choice <= 4){
            if (choice >= 1){
                if (choice == 1){
                    addProblem();
                }
                if (choice == 2){
                    subProblem();
                }
                if (choice == 3){
                    mulProblem();
                }
                if (choice == 4){
                    divProblem();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Input. Please run the program again.");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input. Please run the program again.");
            System.exit(0);
        }
    }
}
