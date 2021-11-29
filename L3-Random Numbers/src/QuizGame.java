import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class QuizGame {

    static double usersAnswer, correctAnswer;
    static String displayProblem = "";
    static JPanel panel;
    static JButton newProblemButton, checkAnswerButton;
    static JLabel showProblem, showResults;
    static JTextField answerInput;
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

        newProblemButton = new JButton("New Problem");
        showProblem = new JLabel("");
        checkAnswerButton = new JButton("Check Answer");
        showResults = new JLabel("");

        answerInput = new JTextField(10);

        ButtonGroup radios = new ButtonGroup();

        addition.setBounds(100, 10, 150, 25);
        subtraction.setBounds(100, 40, 150, 25);
        multiplication.setBounds(100, 70, 150, 25);
        division.setBounds(100, 100, 150, 25);
        newProblemButton.setBounds(75, 130, 150, 25);
        showProblem.setBounds(75, 160, 150, 25);
        answerInput.setBounds(75, 190, 150, 25);
        checkAnswerButton.setBounds(75, 220, 150, 25);
        showResults.setBounds(75, 250, 150, 25);

        newProblemButton.addActionListener(new problemChoiceListener());
        checkAnswerButton.addActionListener(new checkAnswerListener());

        addition.setSelected(true);
        subtraction.setSelected(false);
        multiplication.setSelected(false);
        division.setSelected(false);

        radios.add(addition);
        radios.add(subtraction);
        radios.add(multiplication);
        radios.add(division);

        panel.add(addition);
        panel.add(subtraction);
        panel.add(multiplication);
        panel.add(division);

        panel.add(newProblemButton);
        panel.add(showProblem);
        panel.add(answerInput);
        panel.add(checkAnswerButton);
        panel.add(showResults);

        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);
    }

    private class problemChoiceListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (addition.isSelected()){
                addProblem();
            }

            if (subtraction.isSelected()){
                subProblem();
            }

            if (multiplication.isSelected()){
                mulProblem();
            }

            if (division.isSelected()){
                divProblem();
            }
            showProblem.setText(displayProblem);
            panel.remove(newProblemButton);
            panel.updateUI();
        }
    }

    private class checkAnswerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            getUserAnswer();
            checkAnswer();
        }
    }

    public static void checkAnswer(){
        if (usersAnswer == correctAnswer){
            showResults.setText("You are correct!");
            panel.add(newProblemButton);
            panel.updateUI();
        } else {
            showResults.setText("Incorrect. Try again!");
        }
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
        return Double.parseDouble(answerInput.getText());
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
