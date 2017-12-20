package com.javacodegeeks.examples;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField displayText;
    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;

    private JButton clearButton;
    private JButton signButton;
    private JButton percentButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton addButton;
    private JButton digitButton;
    private JButton equalsButton;
    private JPanel calculatorView;

    private Double leftOperand;
    private Double rightOperand;
    private Operation calcOperation;
    private Boolean resetDisplayFlag = true;
    private Boolean hasPointFlag = false;

    public Calculator() {
        a0Button.addActionListener(new NumberButtonClicked(a0Button.getText(), this));
        a1Button.addActionListener(new NumberButtonClicked(a1Button.getText(), this));
        a2Button.addActionListener(new NumberButtonClicked(a2Button.getText(), this));
        a3Button.addActionListener(new NumberButtonClicked(a3Button.getText(), this));
        a4Button.addActionListener(new NumberButtonClicked(a4Button.getText(), this));
        a5Button.addActionListener(new NumberButtonClicked(a5Button.getText(), this));
        a6Button.addActionListener(new NumberButtonClicked(a6Button.getText(), this));
        a7Button.addActionListener(new NumberButtonClicked(a7Button.getText(), this));
        a8Button.addActionListener(new NumberButtonClicked(a8Button.getText(), this));
        a9Button.addActionListener(new NumberButtonClicked(a9Button.getText(), this));

        percentButton.addActionListener(new OperationButtonClicked(Operation.PERCENTAGE, this));
        divideButton.addActionListener(new OperationButtonClicked(Operation.DIVISION, this));
        multiplyButton.addActionListener(new OperationButtonClicked(Operation.MULTIPLICATION, this));
        subtractButton.addActionListener(new OperationButtonClicked(Operation.SUBTRACTION, this));
        addButton.addActionListener(new OperationButtonClicked(Operation.ADDITION, this));
        clearButton.addActionListener(new ClearButtonClicked(this));
        signButton.addActionListener(new SignButtonClicked(this));
        digitButton.addActionListener(new DigitButtonClicked(this));
        equalsButton.addActionListener(new EqualsButtonClicked(this));
    }

    // Implement a method for tests to click buttons
    public void clickKey(String keyText) {
        switch(keyText) {
            case "0" :
                a0Button.doClick(1);
                break;
            case "1" :
                a1Button.doClick(1);
                break;
            case "2" :
                a2Button.doClick(1);
                break;
            case "3" :
                a3Button.doClick(1);
                break;
            case "4" :
                a4Button.doClick(1);
                break;
            case "5" :
                a5Button.doClick(1);
                break;
            case "6" :
                a6Button.doClick(1);
                break;
            case "7" :
                a7Button.doClick(1);
                break;
            case "8" :
                a8Button.doClick(1);
                break;
            case "9" :
                a9Button.doClick(1);
                break;
            case "%" :
                percentButton.doClick(1);
                break;
            case "/" :
                divideButton.doClick(1);
                break;
            case "*" :
                multiplyButton.doClick(1);
                break;
            case "-" :
                subtractButton.doClick(1);
                break;
            case "+" :
                addButton.doClick(1);
                break;
            case "c" :
                clearButton.doClick(1);
                break;
            case "s" :
                signButton.doClick(1);
                break;
            case "d" :
                digitButton.doClick(1);
                break;
            case "=" :
                equalsButton.doClick(1);
                break;
        }
    }

    // Implement a method for retrieving the display text - again for testing
    public String getText() {
        return displayText.getText();
    }

    public Double getDisplayValue() {
        String text = displayText.getText();
        if (text.equals("") || text.equals("-")) {
            return 0.0;
        } else {
            return Double.valueOf(text);
        }
    }

    public void executeOperation() {
        Double displayValue = this.getDisplayValue();
        if (calcOperation == null || resetDisplayFlag) {
            leftOperand = displayValue;
        } else {
            rightOperand = displayValue;
            Double output = calcOperation.getOperator().applyAsDouble(leftOperand, rightOperand);
            displayText.setText(output % 1 == 0 ? String.valueOf(output.intValue()) : String.valueOf(output));
            leftOperand = output;
        }
        resetDisplayFlag = true;
        hasPointFlag = false;
    }

    private class NumberButtonClicked implements ActionListener {
        private String buttonValue;
        private Calculator calculator;
        public NumberButtonClicked(String value, Calculator calculator) {
            buttonValue = value;
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String newText;
            if (resetDisplayFlag) {
                newText = buttonValue;
            } else {
                newText = displayText.getText() + buttonValue;
            }

            displayText.setText(newText);
            resetDisplayFlag = false;
        }
    }

    private class SignButtonClicked implements ActionListener {
        private Calculator calculator;
        public SignButtonClicked(Calculator calculator) {
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String newText;
            if (resetDisplayFlag) {
                newText = "-";
            } else {
                String currentText = displayText.getText();
                // Check whether number is currently negative
                if (currentText.substring(0,1).equals("-")) {
                    newText = currentText.substring(1);
                } else {
                    newText = "-" + currentText;
                }
            }

            displayText.setText(newText);
            resetDisplayFlag = false;
        }
    }

    private class OperationButtonClicked implements ActionListener {
        private Operation operation;
        private Calculator calculator;
        public OperationButtonClicked(Operation operation, Calculator calculator) {
            this.operation = operation;
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.executeOperation();
            calcOperation = operation;
        }
    }

    private class EqualsButtonClicked implements ActionListener {
        private Calculator calculator;
        public EqualsButtonClicked(Calculator calculator) {
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.executeOperation();
            calcOperation = null;
        }
    }

    private class ClearButtonClicked implements ActionListener {
        private Calculator calculator;
        public ClearButtonClicked(Calculator calculator) {
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            displayText.setText("");
            leftOperand = 0.0;
            rightOperand = 0.0;
        }
    }

    private class DigitButtonClicked implements ActionListener {
        private Calculator calculator;
        public DigitButtonClicked(Calculator calculator) {
            this.calculator = calculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!hasPointFlag) {
                displayText.setText(displayText.getText() + ".");
                hasPointFlag = true;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculatorView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
